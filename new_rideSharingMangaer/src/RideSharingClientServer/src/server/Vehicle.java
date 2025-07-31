package server;

public enum Vehicle {
    SEDAN(1.0, 4),
    SUV(1.5, 6), 
    BIKE(0.8, 2);

    private final double fareMultiplier;
    private final int capacity;

    Vehicle(double fareMultiplier, int capacity) {
        this.fareMultiplier = fareMultiplier;
        this.capacity = capacity;
    }

    public double getFareMultiplier() {
        return fareMultiplier;
    }

    public int getCapacity() {
        return capacity;
    }
}
