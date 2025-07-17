import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

public class StreamPractice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("World");
//        list.add(50);

        System.out.println(list);
    }
}

class Vehicle<T>{
    T value;

    public void setValue(T value) {
        this.value = value;
    }

    Object object = new Student(001, "AP3X");

}