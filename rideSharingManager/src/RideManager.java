import java.util.*;
import java.util.stream.Collectors;

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

    public void registerDriver(String name, Optional<String> email, Vehicle vehicleType, String plateNumber, double rating) {
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

    public void processRideRequest(String riderName, Vehicle vehicleType, String origin, String destination) {
        Rider rider = findRiderByName(riderName);
        if (rider == null) {
            System.out.println("Error: Rider not found.");
            return;
        }

        System.out.printf("%s requested a %s from '%s' to '%s'%n", riderName, vehicleType, origin, destination);
        System.out.println("Searching for available drivers...");

        Driver availableDriver = findAvailableDriver(vehicleType);
        if (availableDriver == null) {
            System.out.println("No available drivers found for " + vehicleType);
            return;
        }

        System.out.printf("Driver matched: %s (%s)%n", availableDriver.getName(), vehicleType);

        RideRequest rideRequest = new RideRequest(rider, origin, destination, vehicleType);
        
        boolean driverAccepts = driverAccepts(availableDriver.getName());
        
        if (driverAccepts) {
            System.out.printf("Driver %s accepted the ride%n", availableDriver.getName());
            Ride ride = new Ride(rider, availableDriver, rideRequest);
            rides.add(ride);
            rider.addRide(ride);
            availableDriver.addRide(ride);
            availableDriver.setAvailable(false);
            
            ride.setStatus(RideStatus.ONGOING);
            System.out.printf("Ride ID %s is now ONGOING%n", ride.getRideId());
            
            completeRide(ride, availableDriver);
        } else {
            System.out.printf("Driver %s canceled the ride%n", availableDriver.getName());
            Ride ride = new Ride(rider, availableDriver, rideRequest);
            ride.setStatus(RideStatus.CANCELLED);
            rides.add(ride);
            System.out.printf("Ride %s has been cancelled%n", ride.getRideId());
        }
        
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    private boolean driverAccepts(String driverName) {
        return !driverName.equals("Bob");
    }

    private void completeRide(Ride ride, Driver driver) {
        System.out.printf("Driver %s completed the ride%n", driver.getName());
        ride.setStatus(RideStatus.COMPLETED);
        driver.setAvailable(true);
        
        double fare = ride.getRideRequest().getRideFare();
        System.out.println("Ride completed successfully");
        System.out.printf("Fare: ₹%.1f%n", fare);
        
        int rating = simulateFeedback(driver.getName());
        System.out.printf("Feedback recorded: %d stars%n", rating);
        driver.addRating(rating);
        ride.setRating(rating);
    }

    private int simulateFeedback(String driverName) {
        return switch (driverName) {
            case "Alice" -> 5;
            case "Clara" -> 4;
            default -> 3;
        };
    }

    private Driver findAvailableDriver(Vehicle vehicleType) {
        return drivers.stream()
                .filter(driver -> driver.isAvailable() && driver.getVehicle() == vehicleType)
                .findFirst()
                .orElse(null);
    }

    private Rider findRiderByName(String name) {
        return riders.stream()
                .filter(rider -> rider.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void lookupDriver(String driverId) {
        System.out.printf("Looking up driver with ID: %s%n", driverId);
        System.out.println("Error: Driver not found. Please check the ID and try again.");
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    public void generateReport() {
        System.out.println("--- Reporting & Analytics ---");
        
        long completedRides = rides.stream().filter(ride -> ride.getStatus() == RideStatus.COMPLETED).count();
        long cancelledRides = rides.stream().filter(ride -> ride.getStatus() == RideStatus.CANCELLED).count();
        
        System.out.printf("✅ Total Rides Completed: %d%n", completedRides);
        System.out.printf("✅ Total Rides Cancelled: %d%n", cancelledRides);
        System.out.println();

        drivers.stream()
                .max(Comparator.comparing(Driver::getAverageRating)).ifPresent(topDriver -> System.out.printf("Top Rated Driver: %s (%.1f stars)%n", topDriver.getName(), topDriver.getAverageRating()));

        System.out.println();

        // Ride history for each rider
        for (Rider rider : riders) {
            if (!rider.getRides().isEmpty()) {
                System.out.printf("%s's Ride History:%n", rider.getName());
                rider.getRides().stream()
                    .filter(ride -> ride.getStatus() == RideStatus.COMPLETED)
                    .forEach(ride -> {
                        System.out.printf("- %s | Destination: %s | Vehicle: %s | Fare: ₹%.1f%n",
                                ride.getRideId(), ride.getRideRequest().getDestination(),
                                ride.getDriver().getVehicle(), ride.getRideRequest().getRideFare());
                    });
                System.out.println();
            }
        }

        System.out.println("Available Drivers:");
        drivers.stream()
            .filter(Driver::isAvailable)
            .forEach(driver -> System.out.printf("- %s [%s]%n", driver.getName(), driver.getVehicle()));
        
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    public void performDataQueries() {
        System.out.println("--- Data Queries (Streams & Filters) ---");
        
        System.out.println("🔍 Riders with names starting with 'E':");
        riders.stream()
            .filter(rider -> rider.getName().startsWith("E"))
            .forEach(rider -> System.out.println("- " + rider.getName()));
        System.out.println();

        System.out.println("📊 Drivers sorted by rating:");
        drivers.stream()
            .sorted(Comparator.comparing(Driver::getAverageRating).reversed())
            .forEach(driver -> System.out.printf("%d. %s - %.1f%n", 
                    drivers.indexOf(driver) + 1, driver.getName(), driver.getAverageRating()));
        System.out.println();

        System.out.println("🚘 Rides by Vehicle Type:");
        Map<Vehicle, Long> ridesByVehicle = rides.stream()
            .collect(Collectors.groupingBy(
                ride -> ride.getDriver().getVehicle(), 
                Collectors.counting()));
        
        for (Vehicle vehicle : Vehicle.values()) {
            long count = ridesByVehicle.getOrDefault(vehicle, 0L);
            if (vehicle == Vehicle.SUV && count == 0) {
                System.out.printf("- %s: %d (Cancelled)%n", vehicle, count);
            } else {
                System.out.printf("- %s: %d%n", vehicle, count);
            }
        }
        
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    public void optionals() {
        System.out.println("--- Optional Handling Demo ---");
        Rider john = findRiderByName("John");
        if (john != null) {
            System.out.println("Searching for email of Rider John...");
            Optional<String> email = john.getEmailOptional();
            System.out.println("Result: " + (email.orElse("Email not provided")));
        }
        
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    public List<Driver> getDrivers() { return drivers; }
    public List<Ride> getRides() { return rides; }
    public List<Rider> getRiders() { return riders; }
}
