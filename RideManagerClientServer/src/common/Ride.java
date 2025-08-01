package common;

import java.util.UUID;

import server.FareCalculation;

public class Ride {
    private final String rideId;
    private final Rider rider;
    private Driver driver;
    private final String destination;
    private final Vehicle vehicleType;
    private final double rideFare;
    private RideStatus status;
    private int riderRating;
    private int driverRating;

    public Ride(Rider rider, Driver driver, String destination, Vehicle vehicleType) {
        this.rideId = "RIDE-" + UUID.randomUUID().toString().substring(0, 8);
        this.rider = rider;
        this.driver = driver;
        this.destination = destination;
        this.vehicleType = vehicleType;
        this.rideFare = FareCalculation.calculateDefaultFare(vehicleType);
        this.status = RideStatus.REQUESTED;
        this.riderRating = 0;
        this.driverRating = 0;
    }

    public String getRideId() {
        return rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getDestination() {
        return destination;
    }

    public Vehicle getVehicleType() {
        return vehicleType;
    }

    public double getRideFare() {
        return rideFare;
    }

    public RideStatus getStatus() {
        return status;
    }

    public int getRiderRating() {
        return riderRating;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public void setRiderRating(int riderRating) {
        this.riderRating = riderRating;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }
}
