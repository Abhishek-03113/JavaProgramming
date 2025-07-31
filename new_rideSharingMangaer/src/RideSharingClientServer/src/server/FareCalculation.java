package server;

public class FareCalculation {
    private static final double BASE_FARE = 5.0;
    private static final double PER_KM_RATE = 2.0;
    private static final double TIME_FACTOR = 0.5;

    public static double calculateFare(Vehicle vehicleType, double distance, double duration) {
        double baseFare = BASE_FARE * vehicleType.getFareMultiplier();
        double distanceFare = distance * PER_KM_RATE;
        double timeFare = duration * TIME_FACTOR;
        
        return baseFare + distanceFare + timeFare;
    }

    public static double calculateFare(Vehicle vehicleType, String pickup, String destination) {
        // Simplified calculation based on location names
        double estimatedDistance = estimateDistance(pickup, destination);
        double estimatedDuration = estimatedDistance * 2; // Assuming 2 minutes per km
        
        return calculateFare(vehicleType, estimatedDistance, estimatedDuration);
    }

    private static double estimateDistance(String pickup, String destination) {
        // Simple hash-based distance estimation for demo purposes
        int hash1 = pickup.hashCode();
        int hash2 = destination.hashCode();
        return Math.abs(hash1 - hash2) % 20 + 5; // Distance between 5-24 km
    }
}
