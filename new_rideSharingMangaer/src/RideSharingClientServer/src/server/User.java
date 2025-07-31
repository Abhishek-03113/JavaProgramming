package server;

import java.util.Optional;

public abstract class User {
    protected String userId;
    protected String name;
    protected Optional<String> email;
    protected Wallet wallet;

    public User(String name, Optional<String> email) {
        this.userId = generateUserId();
        this.name = name;
        this.email = email;
        this.wallet = new Wallet(this.userId);
    }

    private String generateUserId() {
        return getClass().getSimpleName().toLowerCase() + "_" + System.currentTimeMillis();
    }

    // Getters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public Optional<String> getEmail() { return email; }
    public Wallet getWallet() { return wallet; }

    // Setters
    public void setEmail(Optional<String> email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("%s{id=%s, name=%s, email=%s}", 
                           getClass().getSimpleName(), userId, name, email.orElse("None"));
    }
}
