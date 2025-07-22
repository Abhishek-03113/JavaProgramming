import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ReviewAnalysis {
    public static final double MAX_RATING = 5.0;

    public static void main(String[] args) {
        List<Review> reviews = Arrays.asList(
                new Review("Alice", "Bistro Cafe", "French", 4.5, "cozy, romantic, wine", LocalDateTime.of(2025, 7, 20, 19, 30)),
                new Review("Bob", "Sushi Place", "Japanese", 3.8, "fresh, bar seating", LocalDateTime.of(2025, 7, 21, 12, 15)),
                new Review("Charlie", "Taco Town", "Mexican", 5.0, "spicy, casual, quick", LocalDateTime.of(2025, 7, 19, 13, 45)),
                new Review("Diana", "Pasta Palace", "Italian", 4.2, "family-friendly, pasta, wine", LocalDateTime.of(2025, 7, 18, 18, 0)),
                new Review("Eve", "Curry Corner", "Indian", 1.0, "spicy, vegetarian, aromatic", LocalDateTime.of(2025, 7, 17, 20, 20)),
                new Review("Frank", "Burger Barn", "American", 4.0, "casual, burgers, fries", LocalDateTime.of(2025, 7, 22, 14, 10)),
                new Review("Grace", "Sushi Place", "Japanese", 4.8, "fresh, sushi, omakase", LocalDateTime.of(2025, 7, 16, 11, 30)),
                new Review("Heidi", "Green Salad", "Healthy", 4.1, "fresh, vegan, quick", LocalDateTime.of(2025, 7, 15, 13, 0)),
                new Review("Ivan", "Bistro Cafe", "French", 3.9, "brunch, cozy, coffee", LocalDateTime.of(2025, 7, 14, 10, 45)),
                new Review("Judy", "Taco Town", "Mexican", 1.0, "tacos, spicy, late-night", LocalDateTime.of(2025, 7, 13, 18, 15)),
                new Review("Kevin", "Spice Route", "Indian", 4.3, "tandoori, spicy, naan", LocalDateTime.of(2025, 7, 12, 20, 30)),
                new Review("Laura", "Pasta Palace", "Italian", 2.5, "overcooked, bland", LocalDateTime.of(2025, 7, 11, 17, 0)),
                new Review("Mike", "Green Salad", "Healthy", 5.0, "organic, green, cozy", LocalDateTime.of(2025, 7, 10, 12, 10)),
                new Review("Nina", "Curry Corner", "Indian", 2.0, "too hot, salty", LocalDateTime.of(2025, 7, 9, 19, 50)),
                new Review("Oscar", "Sushi Place", "Japanese", 1.5, "soggy, overpriced", LocalDateTime.of(2025, 7, 8, 13, 15)),
                new Review("Pam", "Burger Barn", "American", 5.0, "delicious, juicy, fast", LocalDateTime.of(2025, 7, 7, 14, 25)),
                new Review("Quincy", "Bistro Cafe", "French", 2.0, "slow, cold, overpriced", LocalDateTime.of(2025, 7, 6, 11, 30)),
                new Review("Rita", "Pizza Plaza", "Italian", 3.7, "cheesy, fast, casual", LocalDateTime.of(2025, 7, 5, 20, 5)),
                new Review("Steve", "Taco Town", "Mexican", 4.1, "nachos, salsa, cozy", LocalDateTime.of(2025, 7, 4, 15, 45)),
                new Review("Trudy", "Spice Route", "Indian", 4.9, "authentic, cozy, flavorful", LocalDateTime.of(2025, 7, 3, 18, 10)),
                new Review("Uma", "Green Salad", "Healthy", 3.2, "crunchy, bland", LocalDateTime.of(2025, 7, 2, 16, 40)),
                new Review("Victor", "Pasta Palace", "Italian", 3.0, "okay, cheesy", LocalDateTime.of(2025, 7, 1, 19, 20)),
                new Review("Wendy", "Sushi Place", "Japanese", 5.0, "cozy, quiet, delicious", LocalDateTime.of(2025, 6, 30, 13, 10)),
                new Review("Xavier", "Pizza Plaza", "Italian", 1.8, "burnt, late", LocalDateTime.of(2025, 6, 29, 21, 0)),
                new Review("Yara", "Burger Barn", "American", 3.5, "standard, big portions", LocalDateTime.of(2025, 6, 28, 12, 25)),
                new Review("Zane", "Taco Town", "Mexican", 4.6, "guacamole, fast, street-style", LocalDateTime.of(2025, 6, 27, 14, 35)),
                new Review("Ava", "Spice Route", "Indian", 2.9, "mild, okay", LocalDateTime.of(2025, 6, 26, 19, 45)),
                new Review("Ben", "Bistro Cafe", "French", 4.4, "wine, cozy, dessert", LocalDateTime.of(2025, 6, 25, 10, 30)),
                new Review("Cara", "Pizza Plaza", "Italian", 4.2, "wood-fired, rustic", LocalDateTime.of(2025, 6, 24, 20, 20)),
                new Review("Dan", "Burger Barn", "American", 2.0, "greasy, loud", LocalDateTime.of(2025, 6, 23, 13, 50))
        );

        ReviewAnalytics reviewAnalytics = new ReviewAnalytics(reviews);

        // TODO Requirement 3: Compute Average Rating per Restaurant
        System.out.println("Average Rating per Restraunt");
        reviewAnalytics.getAverageRatingPerRestraunt();

        // TODO Requirement 4: Top-K Restaurants by Rating
        System.out.println("Top k Restraunts");

        reviewAnalytics.topKRestraunts(5);

        // TODO Requirement 5: Sort Reviews Chronologically
        System.out.println("Sorted review Chronologically");
        reviewAnalytics.sortReviewsChronologically();

        // TODO Requirement 6: Sort Restaurants by Cuisine then Name

        System.out.println("Sorted Restraunts by Cuisine and Name");
        reviewAnalytics.sortReviewsByCuisineAndName();
        // TODO Requirement 7: Find All Unique Tags
        reviewAnalytics.getAllUniqueTags();

        // TODO Requirement 8: Find Reviewers Who Love "Cozy"

        reviewAnalytics.reviewersLovingCozy();
        // TODO Requirement 9: Cuisine-Wise Review Counts
        reviewAnalytics.CuisineWiseReviewCount();
        // TODO Requirement 10: Peak Review Hour
        reviewAnalytics.getPeakReviewHour();

        // TODO Requirement 11: Normalize Ratings
        reviewAnalytics.normalizeRatings();
        // TODO Requirement 12: Find One-Star Reviews
        reviewAnalytics.getOneStarReviews();
    }
}