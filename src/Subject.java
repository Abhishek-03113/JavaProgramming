import java.util.ArrayList;

interface subjectInterface {
    void calculateResult(double passingScore, Student student);

}

public class Subject implements subjectInterface {
    public static int subjectCounter;
    private String subjectName;
    private ArrayList<Student> students;
    private double passingScore;
    private double studentScore;
    private boolean hasLab = false;

    public Subject(String subjectName, boolean hasLab) {
        this.subjectName = subjectName;
        this.hasLab = hasLab;
        if (!hasLab) {
            subjectCounter++;
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public double getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(double passingScore) {
        this.passingScore = passingScore;
    }

    public void calculateResult(double passingScore, Student student, double studentScore) {
        boolean displayResult = studentScore >= passingScore;
        Result result = new Result(student.studentID, subjectName, student.studentName, studentScore, displayResult);

    }
}
