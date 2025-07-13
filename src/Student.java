import java.util.ArrayList;

public class Student {
    public int studentID;
    public String studentName;
    private ArrayList<Subject> subjects;
    private ArrayList<Result> results;

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }


    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.enrollStudent(this);
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    public ArrayList<Result> getResults() {
        return results;
    }

}
