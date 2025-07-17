import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {

    static double avgOrderValue = 0;
    public int mostPopularItemCount = 0;
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


        Map.Entry<Item, Integer> mostPopularEntry =  orders.stream()
                .flatMap(order -> order.getItems().entrySet().stream())
                .max(Map.Entry.comparingByValue())
                .orElse(null);


        if (mostPopularEntry != null) {
            mostPopularItem = mostPopularEntry.getKey();
            mostPopularItemCount = mostPopularEntry.getValue();

        }
        this.mostPopularItemCount = mostPopularItemCount;

//
//        for (Order order : orders) {
//            Map<Item, Integer> items = order.getItems();
//            for (Item item : items.keySet()) {
//                if (mostPopularItemCount <= items.get(item) ) {
//                    mostPopularItem = item;
//                    mostPopularItemCount = items.get(item);
//                }
//            }
//
//        }
        return mostPopularItem;
    }

    int getMostPopularItemCount() {
        return mostPopularItemCount;
    }

}