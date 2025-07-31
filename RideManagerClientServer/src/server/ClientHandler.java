package server;

import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket; 
    private Server server;

    public ClientHandler(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }


public void disconnect(){
    
}

@Override
public void run() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'run'");
}

}
