package server;

public class Wallet {
    private double balance;
    private String ownerId;

    public Wallet(String ownerId) {
        this.ownerId = ownerId;
        this.balance = 0.0;
    }

    public void rechargeWallet(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Wallet recharged with $" + amount + ". Current balance: $" + balance);
        } else {
            throw new IllegalArgumentException("Recharge amount must be positive");
        }
    }

    public boolean deduct(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Deducted $" + amount + " from wallet. Remaining balance: $" + balance);
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerId() {
        return ownerId;
    }

    @Override
    public String toString() {
        return String.format("Wallet{owner=%s, balance=$%.2f}", ownerId, balance);
    }
}
