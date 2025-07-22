class Review {
    private final double rating;
    private final String feedback;

    public Review(double rating, String feedback) {
        this.rating = rating;
        this.feedback = feedback;
    }

    public double getRating() {
        return rating;
    }

    public String getFeedback() {
        return feedback;
    }

    @Override
    public String toString() {
        return String.format("Rating: %.1f, Feedback: %s", rating, feedback);
    }
}