import java.util.List;
import java.util.stream.Collectors;

public class Book {

    private String title;

    public double getRevenue() {
        return revenue;
    }

    private double revenue;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    private Author author;
    private String publisher;
    private double price;
    private Genre genre;
    private List<Integer> ratings;
    private Double averageRating;


    public Book(String title, Author author, String publisher, double price, Genre genre, List<Integer> ratings) {
        this.title = title;
        this.author = author;
        author.addBook(this);
        this.publisher = publisher;
        this.price = price;
        this.genre = genre;
        this.ratings = ratings;
        this.averageRating = ratings.stream().collect(Collectors.averagingDouble(Integer::doubleValue));
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
    public void purchaseBook() {
        revenue+=price;
    }

    @Override
    public String toString() {
        return "Book Title : " + title + "\nAuthor " + author.getName() + "\nPublisher " + publisher + "\nPrice " + price;
    }
}
