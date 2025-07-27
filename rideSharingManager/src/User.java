import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
    private int id;
    private String name;
    private String email;
    private List<Integer> ratings;
    private double averageRating;

    public User(int id, String name, Optional<String> email) {
        this.id = id;
        this.name = name;
        this.email = email.orElse(null);
        this.ratings = new ArrayList<>();
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        return ratings.stream().collect(Collectors.averagingDouble(Integer::doubleValue));
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void giveRating(User user, Integer rating) {
        if (rating > 5 || rating < 1) {
            System.out.println("Invalid rating");
            return;
        }
        user.getRatings().add(rating);
    }

    public void addRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<String> getEmailOptional() {
        return Optional.ofNullable(email);
    }
}
