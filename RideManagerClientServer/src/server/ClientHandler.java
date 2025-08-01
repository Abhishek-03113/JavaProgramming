package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket; 
    private Server server;
    private PrintWriter out;
    private BufferedReader in;
    private String clientId;
    private Boolean isConnected;


    public ClientHandler(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
        this.isConnected = true;
    }


public void disconnect(){
    isConnected = false; 
    try {
        if (clientId != null) {
            server.getClients().remove(clientId);
        }
        if (clientSocket != null && !clientSocket.isClosed()) {
            clientSocket.close();
            System.out.println("Client disconnected: " + clientId);
        }
        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();

    }
    } catch (Exception e) {
        System.err.println("Error disconnecting client: " + e.getMessage());
    }
    
}

@Override
public void run() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'run'");
}

}

