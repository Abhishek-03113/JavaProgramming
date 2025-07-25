
public class Ride {
    private String rideId;
    private String destination;
    private Rider rider;
    private Driver driver;
    private double fare;

    public Ride(String rideId, String destination, Rider rider, Driver driver, double fare) {
        this.rideId = rideId;
        this.destination = destination;
        this.rider = rider;
        this.fare = fare;
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "";
    }

}