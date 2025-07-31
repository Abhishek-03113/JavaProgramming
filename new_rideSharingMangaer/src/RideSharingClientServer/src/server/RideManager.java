package server;

import server.Exceptions.InsufficientBalanceException;
import server.Exceptions.NoAvailableDriverException;
import java.time.LocalDateTime;
import java.util.*;

public class RideManager {
    private List<Driver> drivers;
    private List<Rider> riders;
    private List<Ride> rides;

    public RideManager() {
        this.drivers = new ArrayList<>();
        this.riders = new ArrayList<>();
        this.rides = new ArrayList<>();
    }

    // Registration methods
    public void registerDriver(String name, Optional<String> email, Vehicle vehicleType, 
                              String licensePlate, double rating) {
        Driver driver = new Driver(name, email, vehicleType, licensePlate, rating);
        drivers.add(driver);
        System.out.println("Driver registered: " + driver);
    }

    public void registerRider(String name, Optional<String> email) {
        Rider rider = new Rider(name, email);
        riders.add(rider);
        System.out.println("Rider registered: " + rider);
    }

    // Ride operations
    public String RequestRide(Rider rider, Vehicle vehicleType, String pickup, String destination) 
            throws NoAvailableDriverException, InsufficientBalanceException {
        
        System.out.println("\n--- Processing Ride Request ---");
        System.out.println("Rider: " + rider.getName());
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("From: " + pickup + " To: " + destination);

        // Create ride
        Ride ride = new Ride(rider, vehicleType, pickup, destination);
        
        // Check if rider has sufficient balance
        if (rider.getWallet().getBalance() < ride.getFare()) {
            throw new InsufficientBalanceException(
                String.format("Insufficient balance. Required: $%.2f, Available: $%.2f", 
                            ride.getFare(), rider.getWallet().getBalance()));
        }

        // Find available driver
        Driver assignedDriver = findAvailableDriver(vehicleType);
        if (assignedDriver == null) {
            throw new NoAvailableDriverException("No available driver found for " + vehicleType);
        }

        // Assign driver and update status
        ride.setDriver(assignedDriver);
        ride.setStatus(RideStatus.ASSIGNED);
        assignedDriver.setAvailable(false);
        
        rides.add(ride);
        
        System.out.println("Ride assigned to driver: " + assignedDriver.getName());
        System.out.println("Estimated fare: $" + ride.getFare());
        System.out.println("Ride ID: " + ride.getRideId());

        return ride.getRideId();
    }

    private Driver findAvailableDriver(Vehicle vehicleType) {
        return drivers.stream()
                .filter(driver -> driver.isAvailable() && driver.getVehicleType() == vehicleType)
                .max(Comparator.comparingDouble(Driver::getRating))
                .orElse(null);
    }

    public void completeRide(String rideId, double actualDistance, double actualDuration) {
        Ride ride = findRideById(rideId);
        if (ride == null) {
            System.err.println("Ride not found: " + rideId);
            return;
        }

        System.out.println("\n--- Completing Ride ---");
        System.out.println("Ride ID: " + rideId);

        // Update ride details
        ride.setDistance(actualDistance);
        ride.setDuration(actualDuration);
        ride.setEndTime(LocalDateTime.now());
        ride.setStatus(RideStatus.COMPLETED);

        // Recalculate fare based on actual distance and duration
        double actualFare = FareCalculation.calculateFare(ride.getVehicleType(), actualDistance, actualDuration);
        ride.setFare(actualFare);

        // Process payment
        if (ride.getRider().getWallet().deduct(actualFare)) {
            ride.getDriver().getWallet().rechargeWallet(actualFare * 0.8); // Driver gets 80%
            ride.getDriver().setAvailable(true);
            System.out.println("Ride completed successfully!");
            System.out.println("Final fare: $" + actualFare);
        } else {
            System.err.println("Payment failed - insufficient balance");
            ride.setStatus(RideStatus.CANCELLED);
        }
    }

    public void cancelRide(String rideId) {
        Ride ride = findRideById(rideId);
        if (ride == null) {
            System.err.println("Ride not found: " + rideId);
            return;
        }

        System.out.println("\n--- Cancelling Ride ---");
        System.out.println("Ride ID: " + rideId);

        ride.setStatus(RideStatus.CANCELLED);
        if (ride.getDriver() != null) {
            ride.getDriver().setAvailable(true);
        }
        
        System.out.println("Ride cancelled successfully");
    }

    private Ride findRideById(String rideId) {
        return rides.stream()
                .filter(ride -> ride.getRideId().equals(rideId))
                .findFirst()
                .orElse(null);
    }

    // Getters
    public List<Driver> getDrivers() { return new ArrayList<>(drivers); }
    public List<Rider> getRiders() { return new ArrayList<>(riders); }
    public List<Ride> getRides() { return new ArrayList<>(rides); }

    // Find methods
    public Driver findDriverById(String driverId) {
        return drivers.stream()
                .filter(driver -> driver.getUserId().equals(driverId))
                .findFirst()
                .orElse(null);
    }

    public Rider findRiderById(String riderId) {
        return riders.stream()
                .filter(rider -> rider.getUserId().equals(riderId))
                .findFirst()
                .orElse(null);
    }
}
