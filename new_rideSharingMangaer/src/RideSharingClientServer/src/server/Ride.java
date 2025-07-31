package server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ride {
    private String rideId;
    private Rider rider;
    private Driver driver;
    private Vehicle vehicleType;
    private String pickupLocation;
    private String destination;
    private RideStatus status;
    private double fare;
    private LocalDateTime requestTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double distance;
    private double duration;

    public Ride(Rider rider, Vehicle vehicleType, String pickupLocation, String destination) {
        this.rideId = generateRideId();
        this.rider = rider;
        this.vehicleType = vehicleType;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.status = RideStatus.REQUESTED;
        this.requestTime = LocalDateTime.now();
        this.fare = FareCalculation.calculateFare(vehicleType, pickupLocation, destination);
    }

    private String generateRideId() {
        return "RIDE_" + System.currentTimeMillis();
    }

    // Getters
    public String getRideId() { return rideId; }
    public Rider getRider() { return rider; }
    public Driver getDriver() { return driver; }
    public Vehicle getVehicleType() { return vehicleType; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDestination() { return destination; }
    public RideStatus getStatus() { return status; }
    public double getFare() { return fare; }
    public LocalDateTime getRequestTime() { return requestTime; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public double getDistance() { return distance; }
    public double getDuration() { return duration; }

    // Setters
    public void setDriver(Driver driver) { this.driver = driver; }
    public void setStatus(RideStatus status) { this.status = status; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public void setDistance(double distance) { this.distance = distance; }
    public void setDuration(double duration) { this.duration = duration; }
    public void setFare(double fare) { this.fare = fare; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("Ride{id=%s, rider=%s, driver=%s, vehicle=%s, from=%s, to=%s, status=%s, fare=$%.2f, requested=%s}", 
                           rideId, rider.getName(), 
                           driver != null ? driver.getName() : "Not Assigned",
                           vehicleType, pickupLocation, destination, status, fare,
                           requestTime.format(formatter));
    }
}
