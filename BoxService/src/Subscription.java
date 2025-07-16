import java.util.Set;

public class Subscription {
    private final String name;
    private Set<Box> boxes;
    private boolean active;
    private String deliverySchedule;

    public Set<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(Set<Box> boxes) {
        this.boxes = boxes;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setDeliverySchedule(String deliverySchedule) {
        this.deliverySchedule = deliverySchedule;
    }

    public Subscription(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public String getDeliverySchedule() {
        return deliverySchedule;
    }
}

