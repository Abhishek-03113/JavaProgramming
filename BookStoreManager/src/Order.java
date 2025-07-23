import java.util.*;
import java.util.stream.Collectors;

public class Order {
    private List<Book> books;
    private Customer customer;
    private int orderId;
    private double orderValue;

    public Order(List<Book> books, Customer customer, int orderId) {
        this.books = books;
        this.customer = customer;
        this.orderId = orderId;
        this.orderValue = orderId;
        orderValue = books.stream().map(Book::getPrice).mapToDouble(Double::doubleValue).sum();
        books.forEach(Book::purchaseBook);
        CustomerPurchase(customer);

    }

    public void CustomerPurchase(Customer customer) {
        books.forEach(customer::addBook);
    }
    @Override
    public String toString() {
        return "---------Order Details------------\n " + "Order Id : " + orderId + "\n" + "Books : " + books.stream().map(Book::getTitle).toList() + "\n" + "Customer : " + customer.getName() + "\n" + "Order Price : " + orderValue;
    }
}
