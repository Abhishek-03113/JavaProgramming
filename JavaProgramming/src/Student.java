import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    public int studentID;
    public String studentName;
    private final ArrayList<Subject> subjects;
    private HashMap<Subject, Result> results;


    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.subjects = new ArrayList<>();
        this.results = new HashMap<>();
    }


    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void addResults(Subject subject, Result result) {
        this.results.put(subject, result);
    }

}
