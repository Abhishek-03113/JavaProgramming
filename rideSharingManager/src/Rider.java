import java.util.*;
import java.util.stream.*;

public class Rider extends User {
    private int riderId;
    private double averageRating;
    private List<Ride> rideHistory;

    public Rider(String name, Optional<String> email, List<Integer> rating, int riderId) {
        super(name, email, rating);
        this.riderId = riderId;
        this.averageRating = rating.stream().collect(Collectors.averagingDouble(e -> e));
        this.rideHistory = new ArrayList<>();
    }

    public void requestRide(String rideId, String destination, Vehicle vehicleType) {
        RideManager.requestedRides.add(new Ride(rideId, destination, this, null, 0.0));

    }

    public void giveRating(Ride ride, Optional<Integer> rating) {
        ride.getDriver().getRatings().add(rating.orElse(3));
        ride.getDriver().updateRatings();
    }

}