import java.util.ArrayList;

public class Report{
    private ArrayList<Result> results;

    void generateReport(int studentID,String studentName){
        for (Result result : results) {
            if (result.getStudentName().equals(studentName) && result.getStudentID() == studentID){
                result.displayResult();
            }
        }
    }

    public void addResult(Result result){
        results.add(result);
    }

}
