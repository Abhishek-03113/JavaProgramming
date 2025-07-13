import java.util.ArrayList;

interface subjectInterface {
    Result calculateResult(double passingScore, Student student, double studentScore);

}

public class Subject implements subjectInterface {
    public static int subjectCounter;
    private final String subjectName;
    private ArrayList<Student> students;
    private double passingScore;
    private double studentScore;

    public Subject(String subjectName, boolean isLab) {
        this.subjectName = subjectName;
        if (!isLab) {
            subjectCounter++;
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void enrollStudent(Student student) {
        students.add(student);
        student.addSubject(this);
    }

    public double getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(double passingScore) {
        this.passingScore = passingScore;
    }

    @Override
    public Result calculateResult(double passingScore, Student student, double studentScore) {
        boolean displayResult = studentScore >= passingScore;
        return new Result(student.studentID, subjectName, student.studentName, studentScore, displayResult);

    }
}
