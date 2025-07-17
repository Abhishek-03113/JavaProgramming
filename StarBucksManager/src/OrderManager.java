import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {

    static double avgOrderValue = 0;
    private final List<Order> orders = new ArrayList<>();

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public double calculateRevenue() {
        double revenue = 0;
        revenue = orders.stream().mapToDouble(Order::getOrderValue).sum();
        avgOrderValue += revenue / orders.size();

        return revenue;
    }

    public Item mostPopularItem() {
        Item mostPopularItem = null;
        int mostPopularItemCount = 0;




        for (Order order : orders) {
            Map<Item, Integer> items = order.getItems();
            for (Item item : items.keySet()) {
                if (mostPopularItemCount <= items.get(item) ) {
                    mostPopularItem = item;
                    mostPopularItemCount = items.get(item);
                }
            }

        }
        return mostPopularItem;
    }

}