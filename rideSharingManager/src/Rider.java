import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Rider extends User {
    private List<RideRequest> rideRequests;
    private List<Ride> rides;

    public Rider(int id, String name, Optional<String> email) {
        super(id, name, email);
        rideRequests = new ArrayList<>();
        rides = new ArrayList<>();
    }

    public void requestRide(String destination, Vehicle vehicle) {
        rideRequests.add(new RideRequest(this, "", destination, vehicle));
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public List<Ride> getRides() {
        return rides;
    }

    public List<RideRequest> getRideRequests() {
        return rideRequests;
    }
}
