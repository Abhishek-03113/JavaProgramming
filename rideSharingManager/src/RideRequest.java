public class RideRequest {
    private Rider rider;
    private String origin;
    private String destination;
    private Vehicle vehicleType;
    private Double rideFare;

    public RideRequest(Rider rider, String origin, String destination, Vehicle vehicleType) {
        this.rider = rider;
        this.origin = origin;
        this.destination = destination;
        this.vehicleType = vehicleType;
        this.rideFare = FareCalculation.calculateDefaultFare(vehicleType);
    }

    public RideRequest(Rider rider, String destination, Vehicle vehicleType) {
        this(rider, "", destination, vehicleType);
    }

    public Rider getRider() { return rider; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public Vehicle getVehicleType() { return vehicleType; }
    public Double getRideFare() { return rideFare; }

    public void setRider(Rider rider) { this.rider = rider; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setVehicleType(Vehicle vehicleType) { this.vehicleType = vehicleType; }
    public void setRideFare(Double rideFare) { this.rideFare = rideFare; }
}
