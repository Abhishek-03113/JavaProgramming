import java.util.Optional;
import Exceptions.InsufficientBalanceException;
import Exceptions.NoAvailableDriverException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Smart Ride-Sharing System");
        System.out.println("--- Initializing System ---");

        RideManager rideManager = new RideManager();

        rideManager.registerDriver("Alice", Optional.of("alice@something.com"), Vehicle.SEDAN, "AL1234", 4.8);
//        rideManager.registerDriver("Bob", Optional.of("bob@something.com"), Vehicle.SUV, "BO9987", 4.5);
//        rideManager.registerDriver("Clara", Optional.of("clara@something.com"), Vehicle.BIKE, "CL5678", 4.9);

        rideManager.registerRider("Emma", Optional.of("emma@somethingelse.com"));
        rideManager.registerRider("John", Optional.empty());
        rideManager.registerRider("Eve", Optional.of("eve@somethingelse.com"));

        System.out.println("\n------------------------------------------------------");

        System.out.println("\n--- Ride Request Simulation ---");
        Rider emma = rideManager.getRiders().get(0);
        Rider john = rideManager.getRiders().get(1);
        emma.getWallet().rechargeWallet(1000);
        john.getWallet().rechargeWallet(1000);

        System.out.println("--------------------------------------------------------------------------\n");
        try {
            rideManager.RequestRide(john, Vehicle.SEDAN, "Kothrud", "Baner");
        } catch (InsufficientBalanceException | NoAvailableDriverException e) {
            System.out.println(e.getMessage());
        }

        try {
            rideManager.RequestRide(emma, Vehicle.SEDAN, "Airport", "City Center");
            String firstRideId = rideManager.getRides().get(rideManager.getRides().size() - 1).getRideId();
            rideManager.completeRide(firstRideId, 5, 4);
        } catch (NoAvailableDriverException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------\n");

        try {
            rideManager.RequestRide(john, Vehicle.BIKE, "Tech Park", "University");
        } catch (NoAvailableDriverException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        String secondRideId = rideManager.getRides().get(rideManager.getRides().size() - 1).getRideId();
        rideManager.completeRide(secondRideId, 4, 5);

        System.out.println("--------------------------------------------------------------------------\n");

        try {
            rideManager.RequestRide(emma, Vehicle.SUV, "Museum", "Hotel Grand");
            String thirdRideId = rideManager.getRides().get(rideManager.getRides().size() - 1).getRideId();
            rideManager.cancelRide(thirdRideId);
        } catch (NoAvailableDriverException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Ride requests processed.");
        }
//
        Analytics analytics = new Analytics(rideManager);
        analytics.generateReport();
        analytics.performDataQueries();

    }
}