package common;

public class Wallet {
    private double Balance;

    public Wallet() {
        this.Balance = 0.0;
    }

    public void rechargeWallet(double amount) {
        if (amount > 0) {
            Balance += amount;
            System.out.printf("Wallet recharged by %.2f. New balance: %.2f%n", amount, Balance);
        } else {
            System.out.println("Recharge amount must be positive.");
        }
    }

    public double getBalance() {
        return Balance;
    }

    public void deductFare(Driver driver, double fare ) {
        if (Balance >= fare) {
            Balance -= fare;
            driver.getWallet().addBalance(fare);
            System.out.printf("Fare of %.2f deducted from wallet. New balance: %.2f%n", fare, Balance);
        } else {
            System.out.println("Insufficient balance to deduct fare.");
        }
    }

    public void addBalance(double amount) {
        Balance += amount;
    }

}
