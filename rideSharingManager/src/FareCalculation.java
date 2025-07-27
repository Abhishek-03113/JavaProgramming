public class FareCalculation {
    private Vehicle vehicle;


    public FareCalculation(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public static double calculateDefaultFare(Vehicle vehicle) {

        return switch (vehicle) {
            case BIKE -> 10.0;
            case SEDAN -> 30.0;
            case AUTO -> 15.0;
            case SUV -> 40.0;
            case null, default -> 0.0;
        };

    }


}
