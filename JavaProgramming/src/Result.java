public class Result {
    Student student;
    Subject subject;
    private final Double subjectScore;
    private final boolean result;

    public Result(Student student, Subject subject, double subjectScore, boolean result) {
        this.student = student;
        this.subject = subject;
        this.result = result;
        this.subjectScore =  subjectScore;

    }

    public void displayResult() {
        System.out.println("---------------------------------");
        System.out.println("Subject : " + subject.getSubjectName());
        System.out.println("Student ID: " + student.studentID);
        System.out.println("Student Name: " + student.studentName);
        System.out.println("Student Score: " + this.subjectScore);
        if (result) {
            System.out.println("Student Result: " + "Passed");
        } else {
            System.out.println("Student Result: Failed");
        }
        System.out.println("---------------------------------");
    }
}


