public class Result {
    private int studentID;
    private String SubjectName;
    private String StudentName;
    private double studentScore;
    private Boolean result;

    public Result(int studentID, String SubjectName, String StudentName, double studentScore, Boolean result) {
        this.studentID = studentID;
        this.SubjectName = SubjectName;
        this.StudentName = StudentName;
        this.studentScore = studentScore;
        this.result = result;
    }
}
