package server;

import java.util.Optional;

public class Driver extends User {
    private Vehicle vehicleType;
    private String licensePlate;
    private double rating;
    private boolean isAvailable;

    public Driver(String name, Optional<String> email, Vehicle vehicleType, 
                  String licensePlate, double rating) {
        super(name, email);
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
        this.rating = rating;
        this.isAvailable = true;
    }

    // Getters
    public Vehicle getVehicleType() { return vehicleType; }
    public String getLicensePlate() { return licensePlate; }
    public double getRating() { return rating; }
    public boolean isAvailable() { return isAvailable; }

    // Setters
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public void setRating(double rating) { this.rating = rating; }
    public void setVehicleType(Vehicle vehicleType) { this.vehicleType = vehicleType; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    @Override
    public String toString() {
        return String.format("Driver{id=%s, name=%s, email=%s, vehicle=%s, plate=%s, rating=%.1f, available=%s}", 
                           userId, name, email.orElse("None"), vehicleType, licensePlate, rating, isAvailable);
    }
}
