package server;

import java.util.*;
import java.util.stream.Collectors;

public class Analytics {
    private RideManager rideManager;

    public Analytics(RideManager rideManager) {
        this.rideManager = rideManager;
    }

    public void generateReport() {
        System.out.println("\n=== RIDE SHARING ANALYTICS REPORT ===");
        
        List<Ride> rides = rideManager.getRides();
        List<Driver> drivers = rideManager.getDrivers();
        List<Rider> riders = rideManager.getRiders();

        // Basic statistics
        System.out.println("\n--- Basic Statistics ---");
        System.out.println("Total Drivers: " + drivers.size());
        System.out.println("Total Riders: " + riders.size());
        System.out.println("Total Rides: " + rides.size());

        long completedRides = rides.stream().filter(r -> r.getStatus() == RideStatus.COMPLETED).count();
        long cancelledRides = rides.stream().filter(r -> r.getStatus() == RideStatus.CANCELLED).count();
        
        System.out.println("Completed Rides: " + completedRides);
        System.out.println("Cancelled Rides: " + cancelledRides);

        if (!rides.isEmpty()) {
            // Revenue analysis
            double totalRevenue = rides.stream()
                    .filter(r -> r.getStatus() == RideStatus.COMPLETED)
                    .mapToDouble(Ride::getFare)
                    .sum();
            System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
            System.out.println("Average Fare: $" + String.format("%.2f", totalRevenue / completedRides));

            // Vehicle type analysis
            System.out.println("\n--- Vehicle Type Analysis ---");
            Map<Vehicle, Long> vehicleUsage = rides.stream()
                    .collect(Collectors.groupingBy(Ride::getVehicleType, Collectors.counting()));
            vehicleUsage.forEach((vehicle, count) -> 
                System.out.println(vehicle + ": " + count + " rides"));

            // Driver performance
            System.out.println("\n--- Driver Performance ---");
            drivers.forEach(driver -> {
                long driverRides = rides.stream()
                        .filter(r -> r.getDriver() != null && r.getDriver().equals(driver))
                        .filter(r -> r.getStatus() == RideStatus.COMPLETED)
                        .count();
                double driverEarnings = rides.stream()
                        .filter(r -> r.getDriver() != null && r.getDriver().equals(driver))
                        .filter(r -> r.getStatus() == RideStatus.COMPLETED)
                        .mapToDouble(r -> r.getFare() * 0.8)
                        .sum();
                System.out.println(driver.getName() + ": " + driverRides + " rides, $" + 
                                 String.format("%.2f", driverEarnings) + " earned");
            });
        }
    }

    public void performDataQueries() {
        System.out.println("\n=== DATA QUERIES ===");
        
        List<Ride> rides = rideManager.getRides();
        
        // Most popular destinations
        System.out.println("\n--- Most Popular Destinations ---");
        Map<String, Long> destinations = rides.stream()
                .collect(Collectors.groupingBy(Ride::getDestination, Collectors.counting()));
        destinations.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " rides"));

        // Highest rated drivers
        System.out.println("\n--- Highest Rated Drivers ---");
        rideManager.getDrivers().stream()
                .sorted(Comparator.comparingDouble(Driver::getRating).reversed())
                .limit(3)
                .forEach(driver -> System.out.println(driver.getName() + ": " + driver.getRating() + " stars"));

        // Riders with highest spending
        System.out.println("\n--- Top Spending Riders ---");
        Map<Rider, Double> riderSpending = new HashMap<>();
        rides.stream()
                .filter(r -> r.getStatus() == RideStatus.COMPLETED)
                .forEach(ride -> {
                    Rider rider = ride.getRider();
                    riderSpending.put(rider, riderSpending.getOrDefault(rider, 0.0) + ride.getFare());
                });
        
        riderSpending.entrySet().stream()
                .sorted(Map.Entry.<Rider, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey().getName() + ": $" + 
                                                   String.format("%.2f", entry.getValue())));
    }
}
