import java.util.*;
import java.util.stream.*;

class Book {
    int id;
    String title;
    String author;
    String genre;
    int pages;
    List<Integer> ratings;

    public Book(int id, String title, String author, String genre, int pages, List<Integer> ratings) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.ratings = ratings;
    }

    public double getAverageRating() {
        return ratings.stream().mapToInt(i -> i).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " by " + author + " (" + genre + ")";
    }
}

class Solution {

    // === Level 1 ===
    public List<String> uniqueAuthors(List<Book> books) { return books.stream().map(book-> book.author).distinct().toList(); }

    public List<String> titlesLongerThan15(List<Book> books) { return books.stream().map(book -> book.title).filter(t -> t.length() > 15).toList(); }

    public List<Book> booksWithMoreThan300Pages(List<Book> books) { return books.stream().filter(book -> book.pages > 300).toList(); }

    public double averagePages(List<Book> books) { return books.stream().collect(Collectors.averagingDouble(book -> book.pages)); }

    public List<Book> booksWithAvgRatingOver4(List<Book> books) { return books.stream().filter(book -> book.getAverageRating() > 4).toList();}

    public Set<String> uniqueGenres(List<Book> books) { return books.stream().map(book -> book.genre).collect(Collectors.toSet()); }

    public long totalBooks(List<Book> books) { return books.size(); }

    public List<String> titlesToUpperCase(List<Book> books) { return books.stream().map(book -> book.title.toUpperCase()).toList(); }

    public List<Integer> flattenedRatings(List<Book> books) { return books.stream().flatMapToInt(book -> book.ratings.stream().mapToInt(e->e)).boxed().toList(); }

    public int maxRating(List<Book> books) { return books.stream().flatMap(book->book.ratings.stream()).max(Integer::compareTo).get(); }

    // === Level 2 ===
    public Map<String, Long> countBooksByGenre(List<Book> books) { return books.stream().collect(
            Collectors.groupingBy(
                    book -> book.genre,
                    Collectors.counting()
            )
    ); }

    public Map<String, Double> averagePagesPerGenre(List<Book> books) { return books.stream().collect(
            Collectors.groupingBy(
                    book -> book.genre,
                    Collectors.averagingDouble(book -> book.pages)
            )
    ); }

    public Map<String, Optional<Book>> topRatedBookPerGenre(List<Book> books) { return books.stream().collect(
            Collectors.groupingBy(
                    book -> book.genre,
                    Collectors.maxBy(Comparator.comparingDouble(Book::getAverageRating))
            )
    ); }

    public Map<String, List<String>> titlesByAuthor(List<Book> books) { return books.stream().collect(Collectors.groupingBy(
            book -> book.author,
            Collectors.mapping(book -> book.title, Collectors.toList())
    )); }

    public String authorWithMostBooks(List<Book> books) {

        return books.stream().collect(Collectors.groupingBy(book -> book.author, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public long countBooksWith5Star(List<Book> books) {
        return books.stream().filter(book -> book.ratings.stream().anyMatch(e-> e == 5)).count();
    }

    public Map<Boolean, List<Book>> partitionByHighRating(List<Book> books) {
            return books.stream().collect(Collectors.partitioningBy(book -> book.getAverageRating() >= 4.5));
    }

    public List<Book> sortByRatingThenTitle(List<Book> books) {
        return books.stream().sorted(
                Comparator.comparing(Book::getAverageRating).thenComparing(book -> book.title)
        ).collect(Collectors.toList());
    }

    // === Level 3 ===
    public List<Book> top3RatedBooks(List<Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getAverageRating).reversed()).limit(3).collect(Collectors.toList());
    }

    public Map<Book, List<Double>> normalizeRatingsTo100(List<Book> books) {
        return books.stream().collect(Collectors.toMap(
                book -> book,
                book -> book.ratings.stream().map(e -> (double) 1 + 19.8 * e).toList())
        );
    }

    public Map<String, List<String>> titlesSortedByRatingPerGenre(List<Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getAverageRating).reversed()).collect(
                Collectors.groupingBy(
                        book -> book.genre,
                       Collectors.mapping(book -> book.title, Collectors.toList())
                )
        );
    }

    public Map<String, Double> avgOfAvgRatingsPerGenre(List<Book> books) {
        return books.stream().collect(Collectors.groupingBy(
                book -> book.genre,
                Collectors.averagingDouble(Book::getAverageRating)
        ));

    }

    public List<String> authorsWithMultipleGenres(List<Book> books) {
        return books.stream().collect(
                Collectors.groupingBy(
                        book -> book.author,
                        Collectors.mapping(
                                book-> book.genre, Collectors.toSet()
                        )
                )
        ).entrySet().stream().filter(e -> e.getValue().size()>1).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public Map<String, Map<String, List<Book>>> booksGroupedByGenreThenAuthor(List<Book> books) {
        return books.stream().collect(Collectors.groupingBy(
                book -> book.genre,
                Collectors.groupingBy(
                        book -> book.author,
                        Collectors.mapping(book -> book, Collectors.toList())
                )
        ));
    }

    public List<String> authorsWithOnly5StarBooks(List<Book> books) {
        return books.stream().filter(book->book.ratings.stream().allMatch(rating -> rating == 5)).map(book -> book.author).collect(Collectors.toList());
    }

    public Map<String, Optional<Book>> longestBookPerGenre(List<Book> books) {
        return books.stream().collect(Collectors.groupingBy(
                book -> book.genre,
                Collectors.maxBy(Comparator.comparing(book -> book.pages))
        ));
    }

    public List<Integer> ratingsAbove3Sorted(List<Book> books) {
        return books.stream().flatMap(book -> book.ratings.stream()).filter(e -> e > 3).sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
    }

    public Map<String, Double> averageNumRatingsPerGenre(List<Book> books) {
        return books.stream().collect(
                Collectors.groupingBy(
                        book -> book.genre,
                        Collectors.mapping(book -> book.ratings.size(),  Collectors.averagingDouble(Integer::intValue))
                )
        );
    }
}

public class MoreStreams {
    public static void main(String[] args) {
        List<Book> books = getSampleBooks();
        Solution sol = new Solution();

        System.out.println("1. Unique authors: " + sol.uniqueAuthors(books));
        System.out.println("2. Titles > 15 characters: " + sol.titlesLongerThan15(books));
        System.out.println("3. Books > 300 pages: " + sol.booksWithMoreThan300Pages(books));
        System.out.println("4. Average pages: " + sol.averagePages(books));
        System.out.println("5. Books with avg rating > 4.0: " + sol.booksWithAvgRatingOver4(books));
        System.out.println("6. Unique genres: " + sol.uniqueGenres(books));
        System.out.println("7. Total books: " + sol.totalBooks(books));
        System.out.println("8. Titles in uppercase: " + sol.titlesToUpperCase(books));
        System.out.println("9. Flattened ratings: " + sol.flattenedRatings(books));
        System.out.println("10. Max rating: " + sol.maxRating(books));
        System.out.println("11. Count by genre: " + sol.countBooksByGenre(books));
        System.out.println("12. Avg pages per genre: " + sol.averagePagesPerGenre(books));
        System.out.println("13. Top rated book per genre: " + sol.topRatedBookPerGenre(books));
        System.out.println("14. Titles by author: " + sol.titlesByAuthor(books));
        System.out.println("15. Author with most books: " + sol.authorWithMostBooks(books));
        System.out.println("16. Books with any 5-star rating: " + sol.countBooksWith5Star(books));
        System.out.println("17. Partition by avgRating >= 4.5: " + sol.partitionByHighRating(books));
        System.out.println("18. Sorted by avgRating then title: " + sol.sortByRatingThenTitle(books));
        System.out.println("19. Top 3 rated books: " + sol.top3RatedBooks(books));
        System.out.println("20. Ratings normalized to 100: " + sol.normalizeRatingsTo100(books));
        System.out.println("21. Titles by genre sorted by rating: " + sol.titlesSortedByRatingPerGenre(books));
        System.out.println("22. Avg of avg ratings per genre: " + sol.avgOfAvgRatingsPerGenre(books));
        System.out.println("23. Authors with books in multiple genres: " + sol.authorsWithMultipleGenres(books));
        System.out.println("24. Grouped by genre and author: " + sol.booksGroupedByGenreThenAuthor(books));
        System.out.println("25. Authors with only 5-star books: " + sol.authorsWithOnly5StarBooks(books));
        System.out.println("26. Longest book per genre: " + sol.longestBookPerGenre(books));
        System.out.println("27. Ratings > 3 sorted desc: " + sol.ratingsAbove3Sorted(books));
        System.out.println("28. Avg num of ratings per genre: " + sol.averageNumRatingsPerGenre(books));
    }

    public static List<Book> getSampleBooks() {
        return List.of(
                new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 218, List.of(5, 4, 4, 5)),
                new Book(2, "Thinking in Java", "Bruce Eckel", "Programming", 1150, List.of(5, 5, 4, 5, 5)),
                new Book(3, "Clean Code", "Robert C. Martin", "Programming", 464, List.of(5, 5, 4)),
                new Book(4, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 309, List.of(5, 5, 5)),
                new Book(5, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", 341, List.of(5, 4, 4)),
                new Book(6, "Modern Operating Systems", "Andrew S. Tanenbaum", "Education", 1136, List.of(4, 3, 4, 3)),
                new Book(7, "The Pragmatic Programmer", "Andrew Hunt", "Programming", 352, List.of(5, 5, 5)),
                new Book(8, "Design Patterns", "Erich Gamma", "Programming", 395, List.of(5, 5, 4, 4, 4)),
                new Book(9, "Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1216, List.of(5, 5, 5, 5)),
                new Book(10, "Effective Java", "Joshua Bloch", "Programming", 416, List.of(5, 5, 5, 5, 5))
        );
    }
}
