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
        
        System.out.println("\n------------------------------------------------------");
        
        System.out.println("\n--- Ride Request Simulation ---");
        Rider emma = rideManager.getRiders().get(0);
        Rider john = rideManager.getRiders().get(1);
        
        rideManager.RequestRide(emma, Vehicle.SEDAN, "Airport", "City Center");
        rideManager.completeRide("RIDE101", 5);
        
        rideManager.RequestRide(john, Vehicle.BIKE, "Tech Park", "University");
        rideManager.completeRide("RIDE102", 4);
        
        rideManager.RequestRide(emma, Vehicle.SUV, "Museum", "Hotel Grand");
        rideManager.cancelRide("RIDE103");
        
        
        Analytics analytics = new Analytics(rideManager);
        analytics.generateReport();
        analytics.performDataQueries();
        
    }
}
