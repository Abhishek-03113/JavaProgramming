public class RideRequest {
    private Rider rider;
    private String destination;
    private Vehicle vehicleType;
    private Double rideFare;

    public RideRequest(Rider rider, String origin, String destination, Vehicle vehicleType) {
        this.rider = rider;
        this.destination = destination;
        this.vehicleType = vehicleType;
        this.rideFare = FareCalculation.calculateDefaultFare(vehicleType);
    }

    public Rider getRider() { return rider; }
    public String getDestination() { return destination; }
    public Vehicle getVehicleType() { return vehicleType; }
    public Double getRideFare() { return rideFare; }
}
