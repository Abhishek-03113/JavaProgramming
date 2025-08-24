import java.util.*;
import java.net.*;
import java.io.*;


public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean isConnected;
    private Scanner scanner;


    public Client(){
        this.isConnected = false;
        this.scanner = new Scanner(System.in);
    }


    public void Start(){
        try{
            socket
        }
    }

}
