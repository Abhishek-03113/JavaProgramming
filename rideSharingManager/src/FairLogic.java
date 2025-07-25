public class FairLogic {
    private Vehicle vehicle;
    private double fare;

    public FairLogic(Vehicle vehicle, double fare) {
        this.vehicle = vehicle;
        this.fare = fare;
    }

    public static double getDefaultFare(Vehicle vehicle) {
        switch (vehicle){
            case SUV -> {
                return 50.0;
            }
            case BIKE ->
            {
                return 25.0;
            }
            case SEDAN ->
                {
                return 30.0;
                }
            default -> {
                return 0.0;
            }
        }
    }


}
