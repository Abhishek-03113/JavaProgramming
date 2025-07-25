import java.util.*;

public abstract class User {

    private String name;
    private String email;
    private List<Integer> rating;

    public User(String name, Optional<String> email, List<Integer> rating) {
        this.name = name;
        this.email = email.orElse("Email Not Provided");
        this.rating = rating;
    }

    public List<Integer> getRatings() {
        return this.rating;
    }

}