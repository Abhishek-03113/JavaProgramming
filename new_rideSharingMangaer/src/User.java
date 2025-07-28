import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
    private int id;
    private String name;
    private List<Integer> ratings;

    public User(int id, String name, Optional<String> email) {
        this.id = id;
        this.name = name;
        this.ratings = new ArrayList<>();
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        return ratings.stream().collect(Collectors.averagingDouble(Integer::doubleValue));
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void addRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
