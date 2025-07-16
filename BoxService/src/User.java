import java.util.*;


public class User {
    private String name;
    private String username;
    private Set<Subscription> subscriptions;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }
}

