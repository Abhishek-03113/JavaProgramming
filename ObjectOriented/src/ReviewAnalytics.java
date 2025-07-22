import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReviewAnalytics {
    private List<Review> reviews;

    public ReviewAnalytics(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void getAverageRatingPerRestraunt(){
        System.out.println(reviews.stream().collect(Collectors.groupingBy(Review::getRestaurantName, Collectors.averagingDouble(Review::getRating))));
    }

    public void topKRestraunts(int k){
        reviews.stream().sorted(Comparator.comparing(Review::getRating).reversed()).limit(k).forEach(System.out::println);
    }

    public void sortReviewsChronologically(){
        reviews.sort(Comparator.comparing(Review::getVisitTimestamp));
        reviews.forEach(System.out::println);
    }

    public void sortReviewsByCuisineAndName(){
        reviews.sort(Comparator.comparing(Review::getCuisineType).thenComparing(Review::getReviewerName));
        reviews.forEach(System.out::println);
    }

    public void getAllUniqueTags(){
        System.out.println(reviews.stream().flatMap(review -> review.getTagsList().stream()).distinct().toList());
    }

    public void reviewersLovingCozy(){
        reviews.stream().filter(review -> review.getRating()>3).filter(review -> review.getTagsList().contains("cozy")).map(Review::getReviewerName).forEach(System.out::println);
    }

    public void CuisineWiseReviewCount(){
        reviews.stream().collect(Collectors.groupingBy(Review::getCuisineType, Collectors.counting())).entrySet().stream().forEach(System.out::println);
    }

    public void getPeakReviewHour(){
        reviews.stream()
                .collect(Collectors.groupingBy(Review::getVisitTimestamp,Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(System.out::println);
    }

    public void normalizeRatings(){
        reviews.stream().map(review -> (review.getRating()/review.MAXRATING)*100).forEach(System.out::println);
    }

    public void getOneStarReviews(){
        reviews.stream().filter(review -> review.getRating() == 1.0).forEach(System.out::println);
    }
}
