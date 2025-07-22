class Course {
    private final String courseId;
    private final String title;
    private final String category;
    private final int durationMinutes;

    public Course(String courseId, String title, String category, int durationMinutes) {
        this.courseId = courseId;
        this.title = title;
        this.category = category;
        this.durationMinutes = durationMinutes;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s [%d min]", title, courseId, category, durationMinutes);
    }
}