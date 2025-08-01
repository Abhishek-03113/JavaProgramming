package client;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class RiderClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5000;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String riderId;
    private boolean isConnected;
    private Scanner scanner;

    public RiderClient() {
        this.isConnected = false;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        try {
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            isConnected = true;
            System.out.println("Connected to the server at " + SERVER_HOST + ":" + SERVER_PORT);

            Thread messageListener = new Thread(this::listenForMessages);
            messageListener.setDaemon(true); // Allow the program to exit even if this thread is running
            messageListener.start();

            showWelcomeMenu();
        } catch (IOException e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
        }
    }

    private void showWelcomeMenu() {
        while (isConnected) {
            if (riderId == null) {
                System.out.println("Welcome to the Ride Manager!");
                System.out.println("1. Register as a new rider");
                System.out.println("2. Login as an existing rider");
                System.out.println("3. Exit");
                System.out.print("Please choose an option: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        registerRider();
                        break;
                    case "2":
                        loginRider();
                        break;
                    case "3":
                        disconnect();
                        return;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } else {
                showMainMenu();
            }

        }
    }

    private void showMainMenu() {
        System.out.println("Welcome, Rider " + riderId + "!");
        System.out.println("1. Request a ride");
        System.out.println("2. View ride history");
        System.out.println("3. Logout");
        System.out.print("Please choose an option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                requestRide();
                break;
            case "2":
                viewRideHistory();
                break;
            case "3":
                logout();
                break;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }

    private void requestRide() {

    }

    private void viewRideHistory() {

    }

    private void logout() {

    }

    private void registerRider() {
    }

    private void listenForMessages() {
    }

    private void loginRider() {
    }

    private void disconnect() {
    }

}
