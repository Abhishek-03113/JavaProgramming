public class Result {
    private int studentID;
    private String SubjectName;
    private String StudentName;
    private final double studentScore;
    private final Boolean result;

    public Result(int studentID, String SubjectName, String StudentName, double studentScore, Boolean result) {
        this.studentID = studentID;
        this.SubjectName = SubjectName;
        this.StudentName = StudentName;
        this.studentScore = studentScore;
        this.result = result;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void displayResult() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + StudentName);
        System.out.println("Student Score: " + studentScore);
        if (result) {
            System.out.println("Student Result: " + "Passed");
        } else {
            System.out.println("Student Result: Failed");
        }
    }
}
