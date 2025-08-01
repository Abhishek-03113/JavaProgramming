package common;

public enum Vehicle {
    SUV(30),
    BIKE(10),
    SEDAN(20),
    AUTO(15);

    private Vehicle(int cost) {
        this.cost = cost;
    }

    private int cost;

    public int getCost() {
        return cost;
    }
}
