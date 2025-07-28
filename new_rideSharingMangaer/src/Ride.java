public class Ride {
    public static int rideCounter = 100;
    private String rideId;
    private Rider rider;
    private Driver driver;
    private RideRequest rideRequest;
    private RideStatus status;
    private int rating;

    public Ride(Rider rider, Driver driver, RideRequest rideRequest) {
        this.rideId = "RIDE" + (rideCounter + 1);
        this.rider = rider;
        this.driver = driver;
        this.rideRequest = rideRequest;
        this.status = RideStatus.REQUESTED;
        rideCounter++;
    }

    public String getRideId() { return rideId; }
    public Rider getRider() { return rider; }
    public Driver getDriver() { return driver; }
    public RideRequest getRideRequest() { return rideRequest; }
    public RideStatus getStatus() { return status; }
    public int getRating() { return rating; }

    public void setDriver(Driver driver) { this.driver = driver; }
    public void setStatus(RideStatus status) { this.status = status; }
    public void setRating(int rating) { this.rating = rating; }
}
