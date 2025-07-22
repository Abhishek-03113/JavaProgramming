import java.time.LocalDateTime;
import java.util.List;

class Enrollment {
    private final String enrollmentId;
    private final Student student;
    private final Course course;
    private final LocalDateTime enrolledAt;
    private final List<Integer> progressTimeline;
    private final Review review;

    public Enrollment(String enrollmentId, Student student, Course course,
                      LocalDateTime enrolledAt, List<Integer> progressTimeline, Review review) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrolledAt = enrolledAt;
        this.progressTimeline = progressTimeline;
        this.review = review;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public List<Integer> getProgressTimeline() {
        return progressTimeline;
    }

    public Review getReview() {
        return review;
    }

    public double getAvgProgress() {
        return this.progressTimeline.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format("%s enrolled in %s at %s | Progress: %s | %s",
                student.getName(), course.getTitle(), enrolledAt, progressTimeline,
                review != null ? review.toString() : "No review");
    }
}