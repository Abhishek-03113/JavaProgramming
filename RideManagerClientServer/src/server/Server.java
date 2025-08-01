package server;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.*;
import java.util.concurrent.*;

public class Server {
    private static final int PORT = 5000;
    private ServerSocket serverSocket;
    private RideManager rideManager;
    private Map<String, ClientHandler> clients;
    private boolean isRunning;

    public Server() {
        this.rideManager = new RideManager();
        this.clients = new ConcurrentHashMap<>();
        this.isRunning = false;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            isRunning = true;

            System.out.println("Server started on port :" + PORT);
            System.out.println("Waiting for clients to connect...");

            while (isRunning) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                    new Thread(clientHandler).start();
                } catch (IOException e) {

                    if (isRunning) {
                        System.out.println("Error accepting client connection: " + e.getMessage());

                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    public void stop() {
        isRunning = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                System.out.println("Server stopped.");
            }
            clients.values().forEach(ClientHandler::disconnect);
            clients.clear();
        } catch (IOException e) {
            System.err.println("Error Stopping the server");

        }
    }

    public void addClient(String clientId, ClientHandler handler) {
        clients.put(clientId, handler);
        System.out.println("Client Connected " + clientId);
    }

    public void removeClient(String clientId) {
        clients.remove(clientId);
        System.out.println("Client Disconnected");

    }

    public void handleRegisterDriver() {
    }

    public void handleRequestRide() {
    }

    public void handleCompleteRide() {
    }

    public void handleCancelRide() {
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));

    }

    public Map<String, ClientHandler> getClients() {
        return clients;
    }

}
