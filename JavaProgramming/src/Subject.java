import java.util.ArrayList;

interface subjectInterface {
    void calculateResult(Student student, double studentScore,Report report);

}

public class Subject implements subjectInterface {
    public static int subjectCounter;
    private final String subjectName;
    private final ArrayList<Student> students;

    private double passingScore;
    public Subject(String subjectName, boolean isLab, double passingScore) {
        this.subjectName = subjectName;
        if (!isLab) {
            subjectCounter++;
        }
        this.students = new ArrayList<>();
        this.passingScore = passingScore;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void enrollStudent(Student student) {
        this.students.add(student);
        student.addSubject(this);
    }

    public double getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(double passingScore) {
        this.passingScore = passingScore;
    }

    @Override
    public void calculateResult(Student student, double studentScore, Report report) {
        boolean displayResult = studentScore >= passingScore;
        Result result = new Result(student, this,studentScore ,displayResult);
        student.addResults(this, result);
        report.addResult(result);
    }

}
