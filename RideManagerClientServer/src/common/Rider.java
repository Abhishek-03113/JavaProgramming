package common;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Rider extends User {
    private final List<Ride> rides;

    public Rider(int id, String name, Optional<String> email) {
        super(id, name, email);
        rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public List<Ride> getRides() {
        return rides;
    }
}
