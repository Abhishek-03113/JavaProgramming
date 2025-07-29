import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
    private int id;
    private final String name;
    private final List<Integer> ratings;
    private double averageRating;
    private Wallet wallet;

    public User(int id, String name, Optional<String> email) {
        this.id = id;
        this.name = name;
        this.ratings = new ArrayList<>();
        this.averageRating = 0.0;
        this.wallet = new Wallet();
        
    }

    public double getAverageRating() {
        return averageRating;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void addRating(int rating) throws IllegalArgumentException {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            updateAverageRating();
        } else {
            throw new IllegalArgumentException("Invalid rating");
        }
    }

    private void updateAverageRating() {
        if (ratings.isEmpty()) {
            this.averageRating = 0.0;
        } else {
            this.averageRating = ratings.stream().collect(Collectors.averagingDouble(Integer::doubleValue));
        }
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public int getId() {
        return id;
    }

    

}
