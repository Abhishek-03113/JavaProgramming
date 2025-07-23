import java.util.*;
public class Customer {
    public String getName() {
        return name;
    }

    private String name;

    public List<Book> getBooksPurchased() {
        return booksPurchased;
    }

    private List<Book> booksPurchased;

    public Customer(String name) {
        this.name = name;
        this.booksPurchased = new ArrayList<>();
    }

    public void addBook(Book book) {
        booksPurchased.add(book);
    }
}
