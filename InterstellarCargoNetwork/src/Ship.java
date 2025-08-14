import java.util.ArrayList;
import java.util.List;

public class Ship{
    private int id;
    private String name;
    private Status status;
    private double capacity;
    private double currentLoad;
    private List<Cargo> cargoLoaded;

    public Ship(int id, String name,double capacity, double currentLoad) {
        this.id = id;
        this.name = name;
        this.status = Status.AVAILABLE;
        this.capacity = capacity;
        this.currentLoad = currentLoad;
        this.cargoLoaded = new ArrayList<>();
    }

    public boolean canCarry(double cargoLoad){
        return cargoLoad <= capacity;
    }

    public void addCargo(Cargo cargo){
        if (Cargo.getLoad() + currentLoad <= capacity){
            cargoLoaded.add(cargo);
            System.out.println("Cargo Loaded Successfully");
            return;
        }
        System.out.println("Not Enough Capacity");
    }


    public void startDelivery(){
        this.status = Status.IN_TRANSIT;
    }

    public void completeDelivery{
        this.status = Status.COMPLETED;
    }

}