import java.util.*;

public class PipelineManager {

    public static void main(String[] args) {

        Student alice = new Student("Alice", 26);
        Student bob = new Student("Bob", 25);
        Student charlie = new Student("Charlie", 30);

        List<String> names = List.of("Alice", "Bob", "Charlie");

        List<String> strings = List.of("", " Alice", "    ", "bob.   ");

        List<Student> students = new ArrayList<>();
        students.add(alice);
        students.add(bob);
        students.add(charlie);

        List<Integer> scores = List.of(10, 12, 40, 23, 55, 60, 43, 220, 100, 45);

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        DataPipeline pipeline = new DataPipeline();

        System.out.println("Average Values " + pipeline.averageScore(scores));
        System.out.println("Even Counter " +pipeline.evenCounter(scores));
        System.out.println("Squared Values " +pipeline.squaredValues(scores));
        System.out.println("Halved Values " + pipeline.halvedValues(scores));
        System.out.println("Filtering with prefix  A " + pipeline.filterByPrefix(names));
        System.out.println("Cleaning Strings " + pipeline.cleanStrings(strings));
        System.out.println("Average Word Length " + pipeline.averageWordLength(names));
        System.out.println("Word Length Map " + pipeline.wordLengthMap(names));
        System.out.println("Sorting students on name and scores" + pipeline.sortStudents(students));
        System.out.println("Flattened Map " + pipeline.flatteningMatrix(matrix));
        pipeline.summaryStats(scores);


        System.out.println(pipeline.addNums("3876620623801494171", "6529364523802684779"));

    }
}