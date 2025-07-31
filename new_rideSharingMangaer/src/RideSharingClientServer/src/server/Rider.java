package server;

import java.util.Optional;

public class Rider extends User {
    
    public Rider(String name, Optional<String> email) {
        super(name, email);
    }

    @Override
    public String toString() {
        return String.format("Rider{id=%s, name=%s, email=%s, balance=$%.2f}", 
                           userId, name, email.orElse("None"), wallet.getBalance());
    }
}
