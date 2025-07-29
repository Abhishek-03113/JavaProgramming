import java.util.*;
import java.util.stream.Collectors;

public class Analytics {
    private final RideManager rideManager;

    public Analytics(RideManager rideManager) {
        this.rideManager = rideManager;
    }

    public void generateReport() {
        System.out.println("\n--- Reporting & Analytics ---");

        long completedRides = rideManager.getRides().stream()
                .filter(ride -> ride.getStatus() == RideStatus.COMPLETED)
                .count();

        long cancelledRides = rideManager.getRides().stream()
                .filter(ride -> ride.getStatus() == RideStatus.CANCELLED)
                .count();

        System.out.println("Total number of drivers: " + rideManager.getDrivers().size());
        System.out.println("Total number of riders: " + rideManager.getRiders().size());
        System.out.println("Total number of rides: " + rideManager.getRides().size());

        System.out.println("Total Rides Completed: " + completedRides);
        System.out.println("Total Rides Cancelled : " + cancelledRides);

        Driver topDriver = rideManager.getDrivers().stream()
                .max(Comparator.comparing(User::getAverageRating))
                .orElse(null);
        if (topDriver != null) {
            System.out.printf("Top Rated Driver: %s (%.1f stars)%n",
                    topDriver.getName(), topDriver.getAverageRating());
        }

        for (Rider rider : rideManager.getRiders()) {
            System.out.printf("%n%s's Ride History:%n", rider.getName());
            rider.getRides().forEach(ride -> {
                String statusInfo = "";
                if (ride.getStatus() == RideStatus.COMPLETED) {
                    statusInfo = String.format(" | Ratings - Rider gave: %d, Driver gave: %d",
                            ride.getRiderRating(), ride.getDriverRating());
                } else if (ride.getStatus() == RideStatus.CANCELLED) {
                    statusInfo = " | Status: CANCELLED";
                } else if (ride.getStatus() == RideStatus.ONGOING) {
                    statusInfo = " | Status: ONGOING";
                }
                System.out.printf("- %s | Destination: %s | Vehicle: %s | Fare: ₹%.1f%s%n",
                        ride.getRideId(),
                        ride.getDestination(),
                        ride.getVehicleType(),
                        ride.getRideFare(),
                        statusInfo);
            });
        }

        for (Driver driver : rideManager.getDrivers()) {
            System.out.printf("%n%s's Ride History:%n", driver.getName());
            driver.getRides().forEach(ride -> {
                String statusInfo = "";
                if (ride.getStatus() == RideStatus.COMPLETED) {
                    statusInfo = String.format(" | Ratings - Rider gave: %d, Driver gave: %d",
                            ride.getRiderRating(), ride.getDriverRating());
                } else if (ride.getStatus() == RideStatus.CANCELLED) {
                    statusInfo = " | Status: CANCELLED";
                } else if (ride.getStatus() == RideStatus.ONGOING) {
                    statusInfo = " | Status: ONGOING";
                }
                System.out.printf("- %s | Rider: %s | Destination: %s | Vehicle: %s | Fare: ₹%.1f%s%n",
                        ride.getRideId(),
                        ride.getRider().getName(),
                        ride.getDestination(),
                        ride.getVehicleType(),
                        ride.getRideFare(),
                        statusInfo);
            });
        }
    }

    public void performDataQueries() {
        System.out.println("\n--- Data Queries (Streams & Filters) ---");

        System.out.println("------------------------- Driver id Query: ------------------------------------");
        System.out.println("Searching for driver with ID 100:");
        rideManager.getDrivers().stream()
                .filter(driver -> driver.getId() == 100)
                .findFirst().ifPresentOrElse(driver -> System.out.printf("Driver with ID 100: %s%n", driver.getName()),
                        () -> System.out.println("Driver with ID 100 not found."));

        System.out.println("Riders with names starting with 'E':");
        rideManager.getRiders().stream()
                .filter(rider -> rider.getName().startsWith("E"))
                .forEach(rider -> System.out.println("- " + rider.getName()));

        System.out.println("\nDrivers sorted by rating:");
        rideManager.getDrivers().stream()
                .sorted(Comparator.comparing(User::getAverageRating).reversed())
                .forEach(driver -> System.out.printf("%d. %s - %.1f%n",
                        rideManager.getDrivers().indexOf(driver) + 1,
                        driver.getName(),
                        driver.getAverageRating()));

        System.out.println("\nRides by Vehicle Type:");
        Map<Vehicle, Long> ridesByVehicle = rideManager.getRides().stream()
                .filter(ride -> ride.getStatus() == RideStatus.COMPLETED)
                .collect(Collectors.groupingBy(
                        Ride::getVehicleType,
                        Collectors.counting()));
        ridesByVehicle.forEach((vehicle, count) -> System.out.printf("- %s: %d%n", vehicle, count));
    }
}