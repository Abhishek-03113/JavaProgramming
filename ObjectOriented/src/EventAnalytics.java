import java.util.*;
import java.util.stream.Collectors;

public class EventAnalytics {
    private List<Student> students;

    public EventAnalytics(List<Student> students) {
        this.students = students;
    }

    public void parseStudentEvents(){
        System.out.println(students.stream().collect(Collectors.toMap(Student::getName, Student::getEventsAttended)));
    }

    public void getUniqueEvents(){
        System.out.println(students.stream().flatMap(student -> student.getEventsAttended().stream()).distinct().sorted().toList());
    }

    public void mostCommonEvent(){
        Map<Object, Long> eventFrequencies = students.stream().flatMap(student -> student.getEventsAttended().stream()).collect(Collectors.groupingBy(e->e, Collectors.counting()));
        eventFrequencies.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(System.out::println);
    }


    public void getSortedTimeLine(){
        System.out.println("Students Sorted Event timeline   " + students.stream().flatMap(student -> student.getTimestamp().stream()
                .sorted(Comparator.comparing(entry -> entry.split("\\|")[0]))
                .map(entry -> {
                    String[] split = entry.split("\\|");
                    String time = split[0];
                    String eventName = split[1];
                    return student.getName() + "-" + time + "-" + eventName;
                })).toList());
    }


}