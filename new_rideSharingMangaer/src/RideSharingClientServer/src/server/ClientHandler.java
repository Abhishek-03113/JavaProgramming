package server;

import common.Message;
import common.MessageType;
import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private RideManagerServer server;
    private PrintWriter out;
    private BufferedReader in;
    private String userId;
    private boolean isConnected;

    public ClientHandler(Socket socket, RideManagerServer server) {
        this.socket = socket;
        this.server = server;
        this.isConnected = true;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String clientId = "client_" + System.currentTimeMillis();
            server.addClient(clientId, this);

            String inputLine;
            while (isConnected && (inputLine = in.readLine()) != null) {
                try {
                    Message message = parseMessage(inputLine);
                    if (message != null) {
                        server.handleMessage(message, this);
                    }
                } catch (Exception e) {
                    System.err.println("Error processing message from client: " + e.getMessage());
                    sendErrorMessage("Error processing message: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Client connection error: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    private Message parseMessage(String messageString) {
        try {
            // Simple message parsing - format: TYPE|SENDER|PAYLOAD_KEY=VALUE,KEY=VALUE
            String[] parts = messageString.split("\\|", 3);
            if (parts.length < 2) {
                return null;
            }

            MessageType type = MessageType.valueOf(parts[0]);
            String senderId = parts[1];

            Message message = new Message(type, senderId);

            if (parts.length > 2 && !parts[2].isEmpty()) {
                String[] payloadPairs = parts[2].split(",");
                for (String pair : payloadPairs) {
                    String[] keyValue = pair.split("=", 2);
                    if (keyValue.length == 2) {
                        message.addPayload(keyValue[0].trim(), keyValue[1].trim());
                    }
                }
            }

            return message;
        } catch (Exception e) {
            System.err.println("Error parsing message: " + messageString + " - " + e.getMessage());
            return null;
        }
    }

    public void sendMessage(Message message) {
        if (out != null && isConnected) {
            out.println(formatMessage(message));
        }
    }

    private String formatMessage(Message message) {
        StringBuilder sb = new StringBuilder();
        sb.append(message.getType()).append("|");
        sb.append(message.getSenderId()).append("|");
        
        boolean first = true;
        for (String key : message.getPayload().keySet()) {
            if (!first) sb.append(",");
            sb.append(key).append("=").append(message.getPayload().get(key));
            first = false;
        }
        
        return sb.toString();
    }

    private void sendErrorMessage(String errorMessage) {
        if (out != null && isConnected) {
            out.println("ERROR|server|message=" + errorMessage);
        }
    }

    public void disconnect() {
        isConnected = false;
        try {
            if (userId != null) {
                server.removeClient(userId);
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing client connection: " + e.getMessage());
        }
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
