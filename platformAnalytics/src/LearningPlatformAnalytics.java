import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LearningPlatformAnalytics {
    public static void main(String[] args) {
        // Sample setup
        Student alice = new Student("S1", "Alice", "India");
        Student bob = new Student("S2", "Bob", "USA");
        Student charlie = new Student("S3", "Charlie", "UK");

        Course java = new Course("C1", "Java Programming", "Programming", 180);
        Course ux = new Course("C2", "UX Design", "Design", 120);
        Course sales = new Course("C3", "Sales Fundamentals", "Business", 90);

        List<Enrollment> enrollments = Arrays.asList(
                new Enrollment("E1", alice, java, LocalDateTime.of(2025, 7, 1, 10, 0), List.of(10, 40, 100), new Review(4.5, "Great!")),
                new Enrollment("E2", bob, java, LocalDateTime.of(2025, 7, 2, 9, 0), List.of(10, 25, 60), new Review(3.0, "Good but long")),
                new Enrollment("E3", bob, ux, LocalDateTime.of(2025, 7, 3, 12, 0), List.of(10, 20, 30), null),
                new Enrollment("E4", charlie, sales, LocalDateTime.of(2025, 7, 4, 14, 0), List.of(50, 70, 100), new Review(5.0, "Perfect!")),
                new Enrollment("E5", alice, ux, LocalDateTime.of(2025, 7, 5, 16, 0), List.of(10, 20, 40), null),
                new Enrollment("E6", charlie, java, LocalDateTime.of(2025, 7, 6, 17, 0), List.of(5, 10, 15), new Review(1.5, "Too basic"))
        );

        // TODO: Top N Most Engaged Students

        System.out.println(enrollments.stream().collect(
                Collectors.groupingBy(Enrollment::getStudent, Collectors.averagingDouble(Enrollment::getAvgProgress))
        ));

        // TODO: Average Completion Rate per Course

        System.out.println(enrollments.stream().collect(Collectors.groupingBy(Enrollment::getCourse, Collectors.averagingDouble(Enrollment::getAvgProgress))));

        // TODO: Country-wise Average Rating

        System.out.println(enrollments.stream().filter(enrollment -> enrollment.getReview() != null).collect(Collectors.groupingBy(enrollment -> enrollment.getStudent().getCountry(), Collectors.averagingDouble(enrollment -> enrollment.getReview().getRating()))));

        // TODO: List Inactive Students

        enrollments.stream().filter(enrollment -> enrollment.getAvgProgress()<20).map(Enrollment::getStudent).forEach(System.out::println);

        // TODO: Category-wise Course Count and Duration

        System.out.println(enrollments.stream().collect(Collectors.groupingBy(enrollment -> enrollment.getCourse().getCategory(), Collectors.counting())));
        System.out.println(enrollments.stream().collect(Collectors.groupingBy(enrollment -> enrollment.getCourse().getCategory(), Collectors.summingDouble(enrollment->enrollment.getCourse().getDurationMinutes()))));

        // TODO: Most Reviewed Course per Category

        System.out.println(enrollments.stream().filter(enrollment -> enrollment.getReview()!=null)
                .collect(Collectors.groupingBy(
                        e->e.getCourse().getCategory(),
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(
                                        Enrollment::getCourse, Collectors.counting()),
                                countMap -> countMap.entrySet().stream()
                                        .max(Map.Entry.comparingByValue())
                                        .map(Map.Entry::getKey)
                                )
                        )
                ));

        // TODO: Courses with Median Completion Rate

        Map<Course, List<Double>>maps = enrollments.stream().collect(Collectors.groupingBy(Enrollment::getCourse, Collectors.mapping(Enrollment::getAvgProgress, Collectors.toList())));

        System.out.println(maps);

        // TODO: Students Who Rated Below 2.0
        enrollments.stream().filter(enrollment -> enrollment.getReview()!=null).filter(enrollment -> enrollment.getReview().getRating() < 2.0).map(Enrollment::getStudent).forEach(System.out::println);

        // TODO: Courses with >=50% Completion by >=75% Students

        // TODO: Summary per Course
    }
}