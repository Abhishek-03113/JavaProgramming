import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Smart Ride-Sharing System");
        System.out.println("--- Initializing System ---");
        
        RideManager rideManager = new RideManager();
        
        rideManager.registerDriver("Alice", Optional.of("alice@company.com"), Vehicle.SEDAN, "AL1234", 4.8);
        rideManager.registerDriver("Bob", Optional.of("bob@company.com"), Vehicle.SUV, "BO9987", 4.5);
        rideManager.registerDriver("Clara", Optional.of("clara@company.com"), Vehicle.BIKE, "CL5678", 4.9);
        
        rideManager.registerRider("Emma", Optional.of("emma@citymail.com"));
        rideManager.registerRider("John", Optional.empty());
        
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();
        
        System.out.println("--- Ride Request Simulation ---");
        rideManager.processRideRequest("Emma", Vehicle.SEDAN, "Airport", "City Center");
        rideManager.processRideRequest("John", Vehicle.BIKE, "Tech Park", "University");
        rideManager.processRideRequest("Emma", Vehicle.SUV, "Museum", "Hotel Grand");
        
        System.out.println("--- Invalid Operation Simulation ---");
        rideManager.lookupDriver("d999");
        
        rideManager.generateReport();
        rideManager.performDataQueries();
        rideManager.demonstrateOptionalHandling();
        
        System.out.println("--- Simulation Complete ---");
    }
}
