import java.util.*;
import java.util.stream.*;

public class Driver extends User {
    private int driverId;
    private Double averageRating;
    private Vehicle vehicleType;
    private String plateNo;
    private boolean isAvailable;
    private List<Ride> rides;

    public Driver(int driverId, String name, Optional<String> email, List<Integer> rating, Vehicle vehicleType,
                  String plateNo) {
        super(name, email, rating);
        this.driverId = driverId;
        this.plateNo = plateNo;
        this.isAvailable = true;
        this.vehicleType = vehicleType;
        this.averageRating = rating.stream().collect(Collectors.averagingDouble(e -> e));
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public List<Integer> getDriverRatings() {
        return this.getRatings();
    }
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Vehicle getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Vehicle vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }


    public void cancelRequest(Ride ride) {

    }

    public void finishRequest(Ride ride) {

    }

    public void giveRating(Ride ride) {

    }

    public void updateRatings() {
        averageRating = getRatings().stream().collect(Collectors.averagingDouble(e->e));
    }
}