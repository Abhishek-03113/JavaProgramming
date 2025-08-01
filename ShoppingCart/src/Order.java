import java.util.List;

public class Order {
    private int orderId;
    private String orderName;
    private double totalOrderValue;


    public Order(int orderId, String orderName,double totalOrderValue) {
        this.orderId = orderId;
        this.totalOrderValue = totalOrderValue;
    }

    public void applyDiscount(Discount discount) {
        this.totalOrderValue -= totalOrderValue * discount.getPercentage() / 100;
        this.totalOrderValue -= discount.getFlatDiscount();
    }

    public double getOrderValue(){
        return totalOrderValue;
    }
    }

