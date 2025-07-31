package client;

import common.Message;
import common.MessageType;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class RiderClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String userId;
    private boolean isConnected;
    private Scanner scanner;

    public RiderClient() {
        this.scanner = new Scanner(System.in);
        this.isConnected = false;
    }

    public void start() {
        try {
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            isConnected = true;

            System.out.println("🚗 Connected to Ride Sharing Server");

            // Start message listener in separate thread
            Thread messageListener = new Thread(this::listenForMessages);
            messageListener.setDaemon(true);
            messageListener.start();

            // Show main menu
            showWelcomeMenu();

        } catch (IOException e) {
            System.err.println("Failed to connect to server: " + e.getMessage());
        }
    }

    private void showWelcomeMenu() {
        while (isConnected) {
            if (userId == null) {
                System.out.println("\n=== RIDER CLIENT ===");
                System.out.println("1. Register as Rider");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");

                int choice = getIntInput();
                switch (choice) {
                    case 1:
                        registerRider();
                        break;
                    case 2:
                        disconnect();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                showMainMenu();
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== RIDER DASHBOARD ===");
        System.out.println("1. Request Ride");
        System.out.println("2. Recharge Wallet");
        System.out.println("3. View Analytics");
        System.out.println("4. Logout");
        System.out.print("Choose an option: ");

        int choice = getIntInput();
        switch (choice) {
            case 1:
                requestRide();
                break;
            case 2:
                rechargeWallet();
                break;
            case 3:
                viewAnalytics();
                break;
            case 4:
                logout();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void registerRider() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter your email (optional, press Enter to skip): ");
        String email = scanner.nextLine().trim();

        sendMessage("REGISTER_RIDER|temp_id|name=" + name +
                (email.isEmpty() ? "" : ",email=" + email));
    }

    private void requestRide() {
        System.out.println("\n--- Request Ride ---");
        System.out.println("Available vehicle types: SEDAN, SUV, BIKE");
        System.out.print("Choose vehicle type: ");
        String vehicleType = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter pickup location: ");
        String pickup = scanner.nextLine().trim();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine().trim();

        sendMessage("REQUEST_RIDE|" + userId + "|vehicleType=" + vehicleType +
                ",pickup=" + pickup + ",destination=" + destination);
    }

    private void rechargeWallet() {
        System.out.print("Enter amount to recharge: $");
        double amount = getDoubleInput();

        if (amount > 0) {
            sendMessage("RECHARGE_WALLET|" + userId + "|amount=" + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private void viewAnalytics() {
        sendMessage("ANALYTICS_REQUEST|" + userId + "|");
    }

    private void logout() {
        userId = null;
        System.out.println("Logged out successfully.");
    }

    private void listenForMessages() {
        try {
            String message;
            while (isConnected && (message = in.readLine()) != null) {
                handleServerMessage(message);
            }
        } catch (IOException e) {
            if (isConnected) {
                System.err.println("Connection to server lost: " + e.getMessage());
            }
        }
    }

    private void handleServerMessage(String messageString) {
        try {
            String[] parts = messageString.split("\\|", 3);
            if (parts.length < 2)
                return;

            MessageType type = MessageType.valueOf(parts[0]);
            String senderId = parts[1];

            switch (type) {
                case SUCCESS:
                    handleSuccessMessage(parts.length > 2 ? parts[2] : "");
                    break;
                case ERROR:
                    handleErrorMessage(parts.length > 2 ? parts[2] : "");
                    break;
                case ANALYTICS_RESPONSE:
                    System.out.println("\n✅ Analytics report generated on server console.");
                    break;
                default:
                    System.out.println("Received: " + messageString);
            }
        } catch (Exception e) {
            System.err.println("Error handling server message: " + e.getMessage());
        }
    }

    private void handleSuccessMessage(String payload) {
        String message = extractValue(payload, "message");
        String newUserId = extractValue(payload, "userId");
        String rideId = extractValue(payload, "rideId");
        String balance = extractValue(payload, "balance");

        System.out.println("\n✅ " + message);

        if (newUserId != null && userId == null) {
            userId = newUserId;
            System.out.println("Your user ID: " + userId);
        }

        if (rideId != null) {
            System.out.println("Ride ID: " + rideId);
        }

        if (balance != null) {
            System.out.println("Current balance: $" + balance);
        }
    }

    private void handleErrorMessage(String payload) {
        String error = extractValue(payload, "error");
        String message = extractValue(payload, "message");

        System.out.println("\n❌ Error: " + (error != null ? error : message));
    }

    private String extractValue(String payload, String key) {
        if (payload == null || payload.isEmpty())
            return null;

        String[] pairs = payload.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=", 2);
            if (keyValue.length == 2 && keyValue[0].trim().equals(key)) {
                return keyValue[1].trim();
            }
        }
        return null;
    }

    private void sendMessage(String message) {
        if (out != null && isConnected) {
            out.println(message);
        }
    }

    private int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private double getDoubleInput() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void disconnect() {
        isConnected = false;
        try {
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
            System.err.println("Error disconnecting: " + e.getMessage());
        }
        System.out.println("Disconnected from server. Goodbye!");
    }

    public static void main(String[] args) {
        RiderClient client = new RiderClient();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(client::disconnect));

        client.start();
    }
}
