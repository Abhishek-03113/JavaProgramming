public class studentReportManager {
    public static void main(String[] args) {
        Report report = new Report();
        Student alice = new Student(1, "Alice");
        Student bob = new Student(2, "Bob");

        Subject Mathematics = new Subject("Mathematics", false, 40);
        Subject Physics = new Subject("Physics", false, 35);
        Subject PhysicsLaboratory = new Subject("Physics Laboratory", true, 30);


        Mathematics.enrollStudent(alice);
        PhysicsLaboratory.enrollStudent(alice);
        Physics.enrollStudent(alice);

        Result aliceMaths, alicePhysics, alicePhysicsLaboratory;
        Mathematics.calculateResult(alice, 100, report);
        Physics.calculateResult(alice, 25, report);
        PhysicsLaboratory.calculateResult(alice, 40, report);

        report.generateReport(alice);
        System.out.println(Subject.subjectCounter);
    }


}
