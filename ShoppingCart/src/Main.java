public class Main {
    public static void main(String[] args) {
        Order order1  = new Order(1, "Abhishek's Order", 100);
        Order order2 = new Order(1, "Aditya's Order", 500);
        Order order3  = new Order(1, "Parth's Order", 1000);


        Discount discount1 = new Discount(100, 20);
        Discount d2 = new Discount(101, 0, 75);
        Discount d3 = new Discount(103, 15);

        order1.applyDiscount(discount1);
        System.out.println(order1.getOrderValue());

        order2.applyDiscount(d2);
        System.out.println(order2.getOrderValue());

        order3.applyDiscount(d3);
        System.out.println(order3.getOrderValue());

        order3.applyDiscount(d2);
        
        System.out.println(order3.getOrderValue());
    }
}
