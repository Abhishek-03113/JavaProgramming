import java.util.*;

public class Author {
    private String name;
    private int publications;
    private List<Book> publishedBooks;

    public Author(String name) {
        this.name = name;
        this.publications = 0;
        this.publishedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        publishedBooks.add(book);
        publications++;
    }

    @Override
    public String toString() {
        return "Author Details : " + "\nAuthor Name " + name + "\nNo. of published books " + publications + "\nPublished Books " + publishedBooks.stream().map(Book::getTitle).toList();
    }
}
