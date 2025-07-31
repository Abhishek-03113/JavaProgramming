package server;

import common.Message;
import common.MessageType;
import server.Exceptions.InsufficientBalanceException;
import server.Exceptions.NoAvailableDriverException;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RideManagerServer {
    private static final int PORT = 8080;
    private ServerSocket serverSocket;
    private RideManager rideManager;
    private Map<String, ClientHandler> connectedClients;
    private boolean isRunning;

    public RideManagerServer() {
        this.rideManager = new RideManager();
        this.connectedClients = new ConcurrentHashMap<>();
        this.isRunning = false;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            isRunning = true;
            System.out.println("🚗 Ride Manager Server started on port " + PORT);
            System.out.println("Waiting for client connections...");

            // Initialize with some sample data
            initializeSampleData();

            while (isRunning) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                    new Thread(clientHandler).start();
                } catch (IOException e) {
                    if (isRunning) {
                        System.err.println("Error accepting client connection: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Server failed to start: " + e.getMessage());
        }
    }

    private void initializeSampleData() {
        // Register some sample drivers
        rideManager.registerDriver("Alice", Optional.of("alice@example.com"), Vehicle.SEDAN, "AL1234", 4.8);
        rideManager.registerDriver("Bob", Optional.of("bob@example.com"), Vehicle.SUV, "BO9987", 4.5);
        rideManager.registerDriver("Clara", Optional.of("clara@example.com"), Vehicle.BIKE, "CL5678", 4.9);
        System.out.println("Sample drivers initialized.");
    }

    public void stop() {
        isRunning = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            // Close all client connections
            connectedClients.values().forEach(ClientHandler::disconnect);
            connectedClients.clear();
        } catch (IOException e) {
            System.err.println("Error stopping server: " + e.getMessage());
        }
        System.out.println("Server stopped.");
    }

    public void addClient(String clientId, ClientHandler handler) {
        connectedClients.put(clientId, handler);
        System.out.println("Client connected: " + clientId);
    }

    public void removeClient(String clientId) {
        connectedClients.remove(clientId);
        System.out.println("Client disconnected: " + clientId);
    }

    public void handleMessage(Message message, ClientHandler sender) {
        try {
            switch (message.getType()) {
                case REGISTER_RIDER:
                    handleRegisterRider(message, sender);
                    break;
                case REGISTER_DRIVER:
                    handleRegisterDriver(message, sender);
                    break;
                case REQUEST_RIDE:
                    handleRequestRide(message, sender);
                    break;
                case COMPLETE_RIDE:
                    handleCompleteRide(message, sender);
                    break;
                case CANCEL_RIDE:
                    handleCancelRide(message, sender);
                    break;
                case RECHARGE_WALLET:
                    handleRechargeWallet(message, sender);
                    break;
                case ANALYTICS_REQUEST:
                    handleAnalyticsRequest(message, sender);
                    break;
                default:
                    sendErrorMessage(sender, "Unknown message type: " + message.getType());
            }
        } catch (Exception e) {
            sendErrorMessage(sender, "Error processing message: " + e.getMessage());
        }
    }

    private void handleRegisterRider(Message message, ClientHandler sender) {
        String name = message.getPayloadString("name");
        String email = message.getPayloadString("email");
        
        Optional<String> emailOpt = (email != null && !email.isEmpty()) ? 
                                   Optional.of(email) : Optional.empty();
        
        rideManager.registerRider(name, emailOpt);
        
        // Find the registered rider and send back their ID
        Rider rider = rideManager.getRiders().stream()
                .filter(r -> r.getName().equals(name))
                .max(Comparator.comparing(r -> r.getUserId()))
                .orElse(null);
        
        if (rider != null) {
            sender.setUserId(rider.getUserId());
            Message response = new Message(MessageType.SUCCESS, "server", rider.getUserId());
            response.addPayload("message", "Rider registered successfully");
            response.addPayload("userId", rider.getUserId());
            sender.sendMessage(response);
        }
    }

    private void handleRegisterDriver(Message message, ClientHandler sender) {
        String name = message.getPayloadString("name");
        String email = message.getPayloadString("email");
        String vehicleType = message.getPayloadString("vehicleType");
        String licensePlate = message.getPayloadString("licensePlate");
        Double rating = message.getPayloadDouble("rating");
        
        Optional<String> emailOpt = (email != null && !email.isEmpty()) ? 
                                   Optional.of(email) : Optional.empty();
        
        Vehicle vehicle = Vehicle.valueOf(vehicleType.toUpperCase());
        rideManager.registerDriver(name, emailOpt, vehicle, licensePlate, rating);
        
        // Find the registered driver and send back their ID
        Driver driver = rideManager.getDrivers().stream()
                .filter(d -> d.getName().equals(name))
                .max(Comparator.comparing(d -> d.getUserId()))
                .orElse(null);
        
        if (driver != null) {
            sender.setUserId(driver.getUserId());
            Message response = new Message(MessageType.SUCCESS, "server", driver.getUserId());
            response.addPayload("message", "Driver registered successfully");
            response.addPayload("userId", driver.getUserId());
            sender.sendMessage(response);
        }
    }

    private void handleRequestRide(Message message, ClientHandler sender) {
        String riderId = message.getSenderId();
        String vehicleType = message.getPayloadString("vehicleType");
        String pickup = message.getPayloadString("pickup");
        String destination = message.getPayloadString("destination");
        
        Rider rider = rideManager.findRiderById(riderId);
        if (rider == null) {
            sendErrorMessage(sender, "Rider not found");
            return;
        }
        
        try {
            Vehicle vehicle = Vehicle.valueOf(vehicleType.toUpperCase());
            String rideId = rideManager.RequestRide(rider, vehicle, pickup, destination);
            
            Message response = new Message(MessageType.SUCCESS, "server", riderId);
            response.addPayload("message", "Ride requested successfully");
            response.addPayload("rideId", rideId);
            sender.sendMessage(response);
            
        } catch (NoAvailableDriverException | InsufficientBalanceException e) {
            sendErrorMessage(sender, e.getMessage());
        }
    }

    private void handleCompleteRide(Message message, ClientHandler sender) {
        String rideId = message.getPayloadString("rideId");
        Double distance = message.getPayloadDouble("distance");
        Double duration = message.getPayloadDouble("duration");
        
        rideManager.completeRide(rideId, distance, duration);
        
        Message response = new Message(MessageType.SUCCESS, "server", sender.getUserId());
        response.addPayload("message", "Ride completed successfully");
        sender.sendMessage(response);
    }

    private void handleCancelRide(Message message, ClientHandler sender) {
        String rideId = message.getPayloadString("rideId");
        
        rideManager.cancelRide(rideId);
        
        Message response = new Message(MessageType.SUCCESS, "server", sender.getUserId());
        response.addPayload("message", "Ride cancelled successfully");
        sender.sendMessage(response);
    }

    private void handleRechargeWallet(Message message, ClientHandler sender) {
        String userId = message.getSenderId();
        Double amount = message.getPayloadDouble("amount");
        
        // Find user (could be rider or driver)
        Rider rider = rideManager.findRiderById(userId);
        Driver driver = rideManager.findDriverById(userId);
        
        if (rider != null) {
            rider.getWallet().rechargeWallet(amount);
            Message response = new Message(MessageType.SUCCESS, "server", userId);
            response.addPayload("message", "Wallet recharged successfully");
            response.addPayload("balance", rider.getWallet().getBalance());
            sender.sendMessage(response);
        } else if (driver != null) {
            driver.getWallet().rechargeWallet(amount);
            Message response = new Message(MessageType.SUCCESS, "server", userId);
            response.addPayload("message", "Wallet recharged successfully");
            response.addPayload("balance", driver.getWallet().getBalance());
            sender.sendMessage(response);
        } else {
            sendErrorMessage(sender, "User not found");
        }
    }

    private void handleAnalyticsRequest(Message message, ClientHandler sender) {
        Analytics analytics = new Analytics(rideManager);
        analytics.generateReport();
        analytics.performDataQueries();
        
        Message response = new Message(MessageType.ANALYTICS_RESPONSE, "server", sender.getUserId());
        response.addPayload("message", "Analytics report generated (check server console)");
        sender.sendMessage(response);
    }

    private void sendErrorMessage(ClientHandler client, String errorMessage) {
        Message errorMsg = new Message(MessageType.ERROR, "server", client.getUserId());
        errorMsg.addPayload("error", errorMessage);
        client.sendMessage(errorMsg);
    }

    public static void main(String[] args) {
        RideManagerServer server = new RideManagerServer();
        
        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
        
        server.start();
    }
}
