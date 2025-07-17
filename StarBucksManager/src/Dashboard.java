import java.util.HashMap;
import java.util.Map;

public class Dashboard {
    public static void main(String[] args) {

        Item coldCoffee = new Item("Cold Coffee", 100, true, Category.ColdBeverage);
        Item coffee = new Item("coffee", 50, true, Category.HotBeverage);
        Item pasta = new Item("pasta", 150, false, Category.Snacks);

        Map<Item, Integer> order1 = new HashMap<>();
        order1.put(coffee, 2);

        Map<Item, Integer> order2 = new HashMap<>();
        order2.put(pasta, 2);
        order2.put(coldCoffee, 3);

        Map<Item, Integer> order3 = new HashMap<>();
        order3.put(coldCoffee, 4);
        order3.put(pasta, 4);

        Order o1 = new Order(123, order1);
        Order o2 = new Order(345, order2);
        Order o3 = new Order(149, order3);

        OrderManager orderManager = new OrderManager();
        orderManager.placeOrder(o1);
        orderManager.placeOrder(o2);

        System.out.println("==================== STARBUCKS STORE DASHBOARD ====================");
        System.out.println("Total Revenue : " + orderManager.calculateRevenue());
        System.out.println("Average Order Value : " + OrderManager.avgOrderValue);
        System.out.println("Total Vegetarian Items Ordered : " + Item.vegCounter);
        System.out.println("The Most Popular Item is : " + orderManager.mostPopularItem().getName());

    }
}