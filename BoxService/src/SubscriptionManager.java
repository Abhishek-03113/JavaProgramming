import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SubscriptionManager implements SubscriptionManagement{
    private HashMap<User>

    public SubscriptionManager(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void addSubscription(Box box) {
        if (subscription.getBoxes().contains(box)) {
            System.out.println("Subscription already exists");
        }
        else{
            subscription.getBoxes().add(box);
        }
    }

    @Override
    public void pauseSubscription(Box box) {
        subscription.getBoxes().remove(box);

    }

    @Override
    public void resumeSubscription(Box box) {
        subscription.getBoxes().add(box);
    }

    @Override
    public void deleteSubscription(Box box) {
        subscription.getBoxes().remove(box);
    }
}
