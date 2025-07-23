import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

public class BookStoreManager {
    public static void main(String[] args) {
        // Authors
        Author orwell = new Author("George Orwell");
        Author rowling = new Author("J.K. Rowling");
        Author asimov = new Author("Isaac Asimov");

        // Books
        Book book1 = new Book("1984", orwell, "Penguin", 350.0, Genre.FICTION, Arrays.asList(5, 4, 5));
        Book book2 = new Book("Animal Farm", orwell, "Penguin", 250.0, Genre.FICTION, Arrays.asList(5, 5, 4));
        Book book3 = new Book("Harry Potter 1", rowling, "Bloomsbury", 500.0, Genre.FANTASY, Arrays.asList(5, 5, 5));
        Book book4 = new Book("Harry Potter 2", rowling, "Bloomsbury", 520.0, Genre.FANTASY, Arrays.asList(5, 4, 5));
        Book book5 = new Book("Foundation", asimov, "Spectra", 450.0, Genre.SCIENCE_FICTION, Arrays.asList(4, 5, 4));
        Book book6 = new Book("I, Robot", asimov, "Gnome Press", 300.0, Genre.SCIENCE_FICTION, Arrays.asList(5, 3, 4));
        Book book7 = new Book("The Caves of Steel", asimov, "Doubleday", 280.0, Genre.SCIENCE_FICTION, Arrays.asList(4, 4, 4));
        Book book8 = new Book("Harry Potter 3", rowling, "Bloomsbury", 540.0, Genre.FANTASY, Arrays.asList(5, 5, 5));
        Book book9 = new Book("Keep the Aspidistra Flying", orwell, "Penguin", 275.0, Genre.FICTION, Arrays.asList(3, 4, 4));
        Book book10 = new Book("The Naked Sun", asimov, "Doubleday", 310.0, Genre.SCIENCE_FICTION, Arrays.asList(4, 4, 5));


        List<Book> books = new ArrayList<>(List.of(book1, book2, book3, book4, book5, book6, book7, book8,  book9, book10));
        // Customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");
        Customer charlie = new Customer("Charlie");

        // Orders
        Order order1 = new Order(List.of(book1, book3, book5), alice, 101);
        Order order2 = new Order(List.of(book2, book4, book6, book10), bob, 102);
        Order order3 = new Order(List.of(book7, book8, book9), charlie, 103);

//        books.stream().map(Book::getRevenue).forEach(System.out::println);

        System.out.println("Top 10 bestSellers by Revenue ");

        Map<String, Double> sortedBooksByRevenue = books.stream()
                .collect(Collectors.toMap(
                        Book::getTitle,
                        Book::getRevenue
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2)-> e1,
                       LinkedHashMap::new

                       // ensures order is preserved
                ));

        System.out.println(sortedBooksByRevenue);


        System.out.println("Filtering Books based on Genre");
        books.stream().filter(book -> book.getGenre().equals(Genre.FANTASY)).forEach(book -> System.out.println(book.getTitle()));
        System.out.println("Filtering Books based on Rating");
        books.stream().filter(book -> book.getAverageRating() >= 3).forEach(book -> System.out.println(book.getTitle()));

        System.out.println("Total Money Alice Spent on Books " + alice.getBooksPurchased().stream().mapToDouble(Book::getPrice).sum());

        Comparator<Book> customComparator = Comparator.comparing(Book::getPrice).thenComparing(Book::getAverageRating);


        System.out.println("Custom Sorted using comparator ");
        books.stream().sorted(customComparator).forEach(book -> System.out.println(book.getTitle()+ " " +  book.getAverageRating() + " " + book.getPrice()));



    }

}
