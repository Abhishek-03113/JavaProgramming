import java.util.*;
import java.util.stream.Collectors;

public class Analytics {
    private RideManager rideManager;
    
    public Analytics(RideManager rideManager) {
        this.rideManager = rideManager;
    }
    
    public void generateReport() {
        System.out.println("\n--- Reporting & Analytics ---");
        
        long completedRides = rideManager.getRides().stream()
            .filter(ride -> ride.getStatus() == RideStatus.COMPLETED)
            .count();
            
        System.out.println("✅ Total Rides Completed: " + completedRides);
        
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
                System.out.printf("- %s | Destination: %s | Vehicle: %s | Fare: ₹%.1f%n",
                    ride.getRideId(), 
                    ride.getRideRequest().getDestination(),
                    ride.getRideRequest().getVehicleType(),
                    ride.getRideRequest().getRideFare());
            });
        }
    }
    
    public void performDataQueries() {
        System.out.println("\n--- Data Queries (Streams & Filters) ---");
        
        System.out.println("🔍 Riders with names starting with 'E':");
        rideManager.getRiders().stream()
            .filter(rider -> rider.getName().startsWith("E"))
            .forEach(rider -> System.out.println("- " + rider.getName()));
            
        System.out.println("\n📊 Drivers sorted by rating:");
        rideManager.getDrivers().stream()
            .sorted(Comparator.comparing(User::getAverageRating).reversed())
            .forEach(driver -> System.out.printf("%d. %s - %.1f%n",
                rideManager.getDrivers().indexOf(driver) + 1,
                driver.getName(), 
                driver.getAverageRating()));
                
        System.out.println("\n🚘 Rides by Vehicle Type:");
        Map<Vehicle, Long> ridesByVehicle = rideManager.getRides().stream()
            .filter(ride -> ride.getStatus() == RideStatus.COMPLETED)
            .collect(Collectors.groupingBy(
                ride -> ride.getRideRequest().getVehicleType(),
                Collectors.counting()));
        ridesByVehicle.forEach((vehicle, count) -> 
            System.out.printf("- %s: %d%n", vehicle, count));
    }
}