import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Review implements Comparable<Review>{
    public static int MAXRATING = 5;
    private final String reviewerName;
    private final String restaurantName;
    private final String cuisineType;
    private final double rating;
    private final String tags;
    private final LocalDateTime visitTimestamp;

    public Review(String reviewerName,
                  String restaurantName,
                  String cuisineType,
                  double rating,
                  String tags,
                  LocalDateTime visitTimestamp) {
        this.reviewerName = reviewerName;
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.tags = tags;
        this.visitTimestamp = visitTimestamp;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public double getRating() {
        return rating;
    }

    public List<String> getTagsList() {
        return Arrays.stream(this.tags.split(","))
                .map(String::trim)
                .toList();
    }

    public LocalDateTime getVisitTimestamp() {
        return visitTimestamp;
    }

    @Override
    public String toString() {
        return String.format("%s reviewed %s (%s) with rating %.1f at %s | Tags: [%s]",
                reviewerName, restaurantName, cuisineType, rating, visitTimestamp, tags);
    }

    @Override
    public int compareTo(Review o) {
        return this.visitTimestamp.compareTo(o.visitTimestamp);
    }
}