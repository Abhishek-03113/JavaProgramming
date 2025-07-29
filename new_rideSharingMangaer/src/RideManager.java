import java.util.*;

import Exceptions.InsufficientBalanceException;
import Exceptions.NoAvailableDriverException;

public class RideManager {
    private List<Driver> drivers;
    private List<Ride> rides;
    private List<Rider> riders;
    private int driverIdCounter = 1;
    private int riderIdCounter = 1;

    public RideManager() {
        this.drivers = new ArrayList<>();
        this.rides = new ArrayList<>();
        this.riders = new ArrayList<>();
    }

    public void registerDriver(String name, Optional<String> email, Vehicle vehicleType, String plateNumber,
            double rating) {
        Driver driver = new Driver(driverIdCounter++, name, email, vehicleType, plateNumber);
        driver.setInitialRating(rating);
        drivers.add(driver);
        System.out.printf("Driver Registered: %s [Rating: %.1f | Vehicle: %s | Plate: %s]%n",
                name, rating, vehicleType, plateNumber);
    }

    public void registerRider(String name, Optional<String> email) {
        Rider rider = new Rider(riderIdCounter++, name, email);
        riders.add(rider);
        String emailDisplay = email.orElse("Not Provided");
        System.out.printf("Rider Registered: %s [Email: %s]%n", name, emailDisplay);
    }

    public void RequestRide(Rider rider, Vehicle vehicle, String origin, String destination)
            throws NoAvailableDriverException, InsufficientBalanceException {

        if (rider.getWallet().getBalance() < FareCalculation.calculateDefaultFare(vehicle)) {
            throw new InsufficientBalanceException("Insufficient Balance for Ride");
        }
        
        System.out.printf("%s requested a %s from '%s' to '%s'%n",
                rider.getName(), vehicle, origin, destination);
        System.out.println("Searching for available drivers...");



        Ride ride = new Ride(rider, null, destination, vehicle);

        Driver driver = matchDriver(vehicle);

        if (driver != null) {
            System.out.printf("Driver matched: %s (%s)%n", driver.getName(), vehicle);
            System.out.printf("Driver %s accepted the ride%n", driver.getName());
            System.out.printf("Ride ID %s is now ONGOING%n", ride.getRideId());

            ride.setDriver(driver);
            driver.assignRide(ride);
            rides.add(ride);
        } else {
            throw new NoAvailableDriverException(
                    "No available driver found for the requested vehicle type: " + vehicle);
        }
    }

    public Driver matchDriver(Vehicle vehicle) {
        return drivers.stream().sorted(Comparator.comparing(User::getAverageRating).reversed())
                .filter(driver -> driver.getVehicle().equals(vehicle) && driver.isAvailable()).findFirst().orElse(null);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void completeRide(String rideId, int riderRating, int driverRating) {
        rides.stream()
                .filter(ride -> ride.getRideId().equals(rideId))
                .findFirst()
                .ifPresent(ride -> {

                    try {
                        ride.getDriver().completeRide();
                    } catch (InsufficientBalanceException e) {
                        System.out.println("Error completing ride: " + e.getMessage());
                    }

                    ride.setRiderRating(riderRating);
                    ride.setDriverRating(driverRating);

                    ride.getDriver().addRating(riderRating);
                    ride.getRider().addRating(driverRating);

                    System.out.printf("Ride %s completed%n", rideId);
                    System.out.printf("Rider %s rated driver %s: %d stars%n",
                            ride.getRider().getName(), ride.getDriver().getName(), riderRating);
                    System.out.printf("Driver %s rated rider %s: %d stars%n",
                            ride.getDriver().getName(), ride.getRider().getName(), driverRating);
                });
    }

    public void cancelRide(String rideId) {
        rides.stream()
                .filter(ride -> ride.getRideId().equals(rideId))
                .findFirst()
                .ifPresent(ride -> {
                    ride.getDriver().cancelRideRequest();
                    System.out.printf("Ride %s has been cancelled%n", rideId);
                });
    }
}
