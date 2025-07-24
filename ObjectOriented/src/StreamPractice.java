import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {
        countWordsStartingWithVowel();
        sumSquareOfOdds();
        mostFrequentCharacter();
        groupNamesByInitial();
        averagePriceOfCategory();
        customMinTransaction();
        flattenAndDeduplicateTags();
        productOfEvenIndexedNumbers();
        mergeMapValuesByKey();
        groupBooksByPriceRange();
    }

    // 1. Count words starting with vowel
    static void countWordsStartingWithVowel() {
        List<String> words = Arrays.asList("Apple", "banana", "orange", "Avocado", "mango", "elephant");
        // TODO: Use streams and filter/lambda to count words starting with a vowel (case-insensitive)

        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

        words.stream().filter(word -> {
            return vowels.contains(word.charAt(0));
        }).toList().forEach(System.out::println);
    }

    // 2. Sum of squares of odd numbers
    static void sumSquareOfOdds() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // TODO: Use filter, map, and reduce to get sum of squares of odd numbers
        numbers.stream().filter(number -> number % 2 == 1).mapToInt(n -> n * n).reduce(Integer::sum).ifPresent(System.out::println);
    }

    // 3. Most frequent character in a string
    static void mostFrequentCharacter() {
        String input = "aabbbccdeeee";
        input.chars().mapToObj(chars -> (char) chars).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().reduce((c1, c2) -> c1.getValue() >= c2.getValue() ? c1 : c2).ifPresent(System.out::println);
        // TODO: Use stream and reduce to find most frequent character
    }

    // 4. Group names by starting letter
    static void groupNamesByInitial() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Amanda", "Brian");
        // TODO: Use streams to group names by their first character
    }

    // 5. Average price of books in a category
    static void averagePriceOfCategory() {
        List<Book> books = Arrays.asList(
                new Book("Java", 300, "Tech"),
                new Book("Python", 250, "Tech"),
                new Book("Biology", 180, "Science"),
                new Book("Physics", 210, "Science"),
                new Book("Spring Boot", 350, "Tech")
        );
        // TODO: Calculate average price of books in category = "Tech"
    }

    // 6. Custom reduce: Find Transaction with smallest amount
    static void customMinTransaction() {
        List<Transaction> txns = Arrays.asList(
                new Transaction(400),
                new Transaction(100),
                new Transaction(250)
        );

        txns.stream().reduce((t1,t2) -> t1.amount <  t2.amount ? t1 : t2).ifPresent(System.out::println);

        // TODO: Use reduce to find Transaction with smallest amount
    }

    // 7. Flatten list of tag lists and remove duplicates
    static void flattenAndDeduplicateTags() {
        List<List<String>> tagLists = Arrays.asList(
                Arrays.asList("java", "streams", "lambda"),
                Arrays.asList("java", "concurrency"),
                Arrays.asList("streams", "performance")
        );

        tagLists.stream().flatMap(Collection::stream).collect(Collectors.toSet()).forEach(System.out::println);
        // TODO: Flatten and remove duplicate tags
    }

    // 8. Product of even-indexed elements
    static void productOfEvenIndexedNumbers() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7);
        // TODO: Multiply only elements at even indices (0, 2, 4...)

        numbers.stream().filter(n -> numbers.indexOf(n) % 2 == 0).reduce((x, y) -> x * y).ifPresent(System.out::println);
    }

    // 9. Merge maps with summing values
    static void mergeMapValuesByKey() {
        List<Map<String, Integer>> maps = Arrays.asList(
                Map.of("A", 10, "B", 20),
                Map.of("A", 5, "C", 15),
                Map.of("B", 10, "C", 5)
        );


//        maps.stream().flatMap(Map.Entry::getKey).collect(Collectors.groupingBy(e ->e , Collectors.mapping()));
        // TODO: Merge into one map with values summed
    }

    // 10. Group books by price range
    static void groupBooksByPriceRange() {
        List<Book> books = Arrays.asList(
                new Book("Clean Code", 500, "Tech"),
                new Book("Effective Java", 700, "Tech"),
                new Book("DSA", 200, "Tech"),
                new Book("Algorithms", 300, "Tech"),
                new Book("Design Patterns", 800, "Tech")
        );

        System.out.println(books.stream().collect(Collectors.groupingBy(book -> {
            if(book.price >= 500) {return "500 - 1000";} else  {return "100 - 500";}
        }, Collectors.mapping(book -> book.title, Collectors.toList()))));
        // TODO: Group books into price brackets: "<300", "300-600", ">600"
    }

    // ======= Helper Classes =======

    static class Book {
        String title;
        double price;
        String category;

        Book(String title, double price, String category) {
            this.title = title;
            this.price = price;
            this.category = category;
        }

        @Override
        public String toString() {
            return title + " ($" + price + ") - " + category;
        }
    }

    static class Transaction {
        double amount;

        Transaction(double amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "₹" + amount;
        }
    }
}
