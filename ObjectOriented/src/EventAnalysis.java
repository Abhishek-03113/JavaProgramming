import java.util.*;

public class EventAnalysis {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", "Coding, Dance, Debate", new int[]{85, 80, 88},
                        new LinkedList<>(Arrays.asList("10:00|Coding", "11:30|Dance", "14:00|Debate"))),

                new Student("Bob", "Music, Dance, Drama", new int[]{90, 85, 86},
                        new LinkedList<>(Arrays.asList("09:00|Music", "12:00|Dance", "13:30|Drama"))),

                new Student("Charlie", "Coding, Music, Quiz", new int[]{70, 80, 84},
                        new LinkedList<>(Arrays.asList("08:00|Quiz", "10:30|Coding", "15:00|Music"))),

                new Student("Diana", "Drama, Debate, Quiz", new int[]{88, 90, 89},
                        new LinkedList<>(Arrays.asList("11:00|Debate", "13:00|Drama", "16:00|Quiz"))),

                new Student("Eve", "Music, Coding, Dance", new int[]{60, 65, 70},
                        new LinkedList<>(Arrays.asList("10:00|Music", "11:00|Dance", "14:30|Coding")))
        );

        EventAnalytics eventAnalytics = new EventAnalytics(students);

        eventAnalytics.parseStudentEvents();
        eventAnalytics.getUniqueEvents();
        eventAnalytics.mostCommonEvent();
        eventAnalytics.getSortedTimeLine();

    }
}