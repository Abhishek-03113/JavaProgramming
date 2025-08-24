import java.util.*;
import java.net.*;
import java.io.*;
import java.net.ServerSocket;


public class Server {
    public static final int PORT = 8080;
    private ServerSocket serverSocket;
    private boolean isRunning = false;

    public Server() {
        this.serverSocket = null;
        this.isRunning = false;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            isRunning = true;

            while (isRunning) {
                try {
                    Socket clientSocket = serverSocket.accept();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void close(){
        isRunning = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
