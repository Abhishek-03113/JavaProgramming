import java.util.ArrayList;

public class Report {
    private final ArrayList<Result> results;

    public Report() {
        this.results = new ArrayList<>();
    }

    void generateReport(Student student) {
        for (Result result : results) {
            if (result.student.equals(student)) {
                result.displayResult();
            }
        }
    }

    public void addResult(Result result) {
        results.add(result);
    }

}
