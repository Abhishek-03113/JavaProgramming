import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Exceptions.InsufficientBalanceException;

public class Driver extends User {
    private final List<Ride> rides;
    private final Vehicle vehicle;
    private final String plateNo;
    private boolean isAvailable = true;
    private Ride assignedRide;

    public Driver(int id, String name, Optional<String> email, Vehicle vehicle, String plateNo) {
        super(id, name, email);
        this.rides = new ArrayList<>();
        this.vehicle = vehicle;
        this.plateNo = plateNo;
    }

    public void setInitialRating(double rating) {
        addRating((int) Math.round(rating));
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

    public void assignRide(Ride ride) {
        assignedRide = ride;
        ride.setStatus(RideStatus.ONGOING);
        isAvailable = false;
        rides.add(ride);
    }
    public void cancelRideRequest() {
        if (assignedRide != null) {
            assignedRide.setStatus(RideStatus.CANCELLED);
            assignedRide.getRider().addRide(assignedRide);
            System.out.println("Ride request cancelled");
            isAvailable = true;
            assignedRide = null;
        }
    }

    public void completeRide() throws InsufficientBalanceException {

        if (assignedRide == null) {
            System.out.println("No ride assigned to complete.");
            return;
        }
        assignedRide.setStatus(RideStatus.COMPLETED);
        assignedRide.getRider().addRide(assignedRide);
        assignedRide.getRider().getWallet().deductFare(this, assignedRide.getRideFare());
        isAvailable = true;
        assignedRide = null;
    }
}
