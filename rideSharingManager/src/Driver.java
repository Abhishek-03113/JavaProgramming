import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Driver extends User {
    private final List<Ride> rides;
    private final Vehicle vehicle;
    private final String plateNo;
    private boolean isAvailable = true;

    public Driver(int id, String name, Optional<String> email, Vehicle vehicle, String plateNo) {
        super(id, name, email);
        this.rides = new ArrayList<>();
        this.vehicle = vehicle;
        this.plateNo = plateNo;
    }

    public void setInitialRating(double rating) {
        addRating((int) Math.round(rating));
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public List<Ride> getRides() {
        return rides;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void cancelRideRequest(RideRequest rideRequest) {
    }

    public void completeRideRequest(RideRequest rideRequest) {
    }
}
