import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private String eventsAttended;
    private int[] feedBack;
    private double averageFeedback;
    private LinkedList<String> timestamp;

    public Student(String name, String eventsAttended, int[] feedBack, LinkedList<String> timestamp) {
        this.name = name;
        this.eventsAttended = eventsAttended;
        this.feedBack = feedBack;
        this.averageFeedback = 0;
        this.timestamp = timestamp;
    }

    public double getAverageFeedback() {
        return Arrays.stream(feedBack).average().getAsDouble();
    }

    public String getName() {
        return name;
    }

    public List<String> getEventsAttended() {
        return Arrays.asList(eventsAttended.split(","));
    }

    public void calculateAverageFeedback(){
       this.averageFeedback =  Arrays.stream(feedBack).average().getAsDouble();
    }

    public LinkedList<String> getTimestamp() {
        return timestamp;
    }
}