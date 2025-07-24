import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.*;

public class ReducePractice {

    public static void main(String[] args) {
        sumOfEvenNumbers();
        findLongestString();
        multiplyAllElements();
        concatenateWithSeparator();
        findCheapestBook();
        totalRevenueFromOrders();
        findMaximumWithOptional();
        longestWordInSentences();
        aggregateTransactions();
        totalCharacterCountParallel();
    }

    // 1. Sum of Even Numbers
    static void sumOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(2, 5, 6, 7, 8, 10);

        System.out.println(numbers.stream().mapToInt(number -> {
            if (number % 2 == 0) {
                return number;
            }
            else return 0;
        }).reduce(0, Integer::sum));

        // TODO: Use reduce to sum even numbers
    }

    // 2. Find Longest String
    static void findLongestString() {
        List<String> words = Arrays.asList("Java", "Stream", "API", "Reduction", "Powerful");
        System.out.println(words.stream().reduce("", (s1, s2)-> {
            if (s1.length() > s2.length()) {
                return s1;
            }
            else{
                return s2;
            }
        }));
        // TODO: Use reduce to find the longest word

    }

    // 3. Multiply All Elements
    static void multiplyAllElements() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        // TODO: Use reduce to get product
        System.out.println( numbers.stream().reduce(1,  (a, b) -> a * b));

    }

    // 4. Concatenate with Separator
    static void concatenateWithSeparator() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        System.out.println(words.stream().reduce((a, b) -> a+"-"+b).orElse(""));
        // TODO: Use reduce to create "apple-banana-cherry"
    }

    // 5. Find Cheapest Book
    static void findCheapestBook() {
        List<Book> books = Arrays.asList(
                new Book("Java Basics", 199.0),
                new Book("Advanced Java", 50.0),
                new Book("Effective Java", 149.0)
        );

        System.out.println(books.stream().reduce(null, (a, b) -> {
            if (a != null && b != null) {
                if (a.price < b.price) return a;
                else return b;
            }
            else return b;
        }));

        // TODO: Use reduce to find the cheapest book
    }

    // 6. Total Revenue from Orders
    static void totalRevenueFromOrders() {
        List<Order> orders = Arrays.asList(
                new Order(Arrays.asList(new Book("A", 120), new Book("B", 130))),
                new Order(Arrays.asList(new Book("C", 90), new Book("D", 160)))
        );
        orders.stream().mapToDouble(Order::getOrderValue).reduce(Double::sum).ifPresent(System.out::println);

        // TODO: Use reduce to get total revenue from all orders
    }

    // 7. Find Maximum Using Optional
    static void findMaximumWithOptional() {
        List<Integer> numbers = Arrays.asList(10, 25, 30, 5);

        System.out.println(numbers.stream().reduce(Integer::max).orElse(0));
        // TODO: Use reduce to find max value
    }

    // 8. Flatten and Reduce: Longest Word in Sentences
    static void longestWordInSentences() {
        List<String> sentences = Arrays.asList("Java streams are powerfull", "Reduce is tricky but useful");
        // TODO: Flatten into words and find longest using reduce
        System.out.println(sentences.stream().flatMap(word -> Arrays.stream(word.split(" "))).reduce((a, b) -> {
            if (a.length() > b.length()) {
                return a;
            }
            else return b;
        }).orElse(""));
    }

    // 9. Custom Aggregation: Aggregate Transactions
    static void aggregateTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(100),
                new Transaction(200),
                new Transaction(150)
        );
        // TODO: Use reduce to create a combined Transaction
        System.out.println(transactions.stream().reduce(new Transaction(0, 0) , Transaction::combine));
    }

    // 10. Parallel Stream Reduce: Character Count
    static void totalCharacterCountParallel() {
        List<String> words = Arrays.asList("Java", "Streams", "Parallel", "Reduction");
        // TODO: Use 3-arg reduce on parallel stream to count total characters
    }

    // ===== Helper Classes =====

    static class Book {
        String title;
        double price;

        Book(String title, double price) {
            this.title = title;
            this.price = price;
        }

        @Override
        public String toString() {
            return title + " ($" + price + ")";
        }
    }

    static class Order {
        List<Book> books;

        Order(List<Book> books) {
            this.books = books;
        }

        double getOrderValue() {
            return books.stream().mapToDouble(b -> b.price).sum();
        }
    }

    static class Transaction {
        double amount;
        int count;

        Transaction(double amount) {
            this.amount = amount;
            this.count = 1;
        }

        Transaction(double amount, int count) {
            this.amount = amount;
            this.count = count;
        }

        Transaction combine(Transaction other) {
            return new Transaction(this.amount + other.amount, this.count + other.count);
        }

        @Override
        public String toString() {
            return "Total: " + amount + ", Count: " + count;
        }
    }
}
