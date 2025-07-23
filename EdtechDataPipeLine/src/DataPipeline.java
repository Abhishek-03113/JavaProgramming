import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;

public class DataPipeline {

    public double averageScore(List<Integer> scores) {
        return scores.stream().collect(Collectors.averagingDouble(score -> score));
    }

    public List<Double> halvedValues(List<Integer> values) {
        return values.stream().map(value -> value.doubleValue() / 2).collect(Collectors.toList());
    }

    public long evenCounter(List<Integer> values) {
        return values.stream().filter(val -> val % 2 == 0).count();
    }

    public void summaryStats(List<Integer> values) {
        IntSummaryStatistics stats = values.stream().collect(Collectors.summarizingInt(e -> e));
        System.out.println("Max of array is " + stats.getMax());
        System.out.println("Min of array is " + stats.getMin());
        System.out.println("Sum of array is " + stats.getSum());

    }

    public List<String> filterByPrefix(List<String> names) {
        return names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
    }

    public double averageWordLength(List<String> words) {
        return words.stream().collect(Collectors.averagingDouble(word -> word.length()));
    }

    public String flatteningMatrix(int[][] matrix) {
        System.out.println(Arrays.stream(matrix).flatMapToInt(array -> Arrays.stream(array)).boxed().collect(Collectors.toList()));
        return Arrays.toString(Arrays.stream(matrix).flatMapToInt(Arrays::stream).toArray());
    }

    public String squaredValues(List<Integer> values) {
        return values.stream().map(val -> (val * val)).map(String::valueOf).collect(Collectors.joining(", "));
    }

    public Map<String, Integer> wordLengthMap(List<String> words) {
        return words.stream().collect(Collectors.toMap(word -> word, word -> word.length()));
    }

    public List<String> sortStudents(List<Student> students){
        students.sort(Comparator.comparing(Student::getScore).reversed().thenComparing(Student::getName));
        return students.stream().map(student -> student.getName()).collect(Collectors.toList());
    }
    public List<String> cleanStrings(List<String> strings) {
        return strings.stream().map(String::trim).filter(string -> string.length() > 0).collect(Collectors.toList());
    }



    public String addNums(String num1, String num2) {

        BigInteger bi1 = new BigInteger(num1);
        BigInteger bi2 = new BigInteger(num2);

        return String.valueOf(bi1.add(bi2));
    }

    public int addDigits(int num) {
        int sum = String.valueOf(num).length();

        while (sum > 10){
            int temp = num;

            while (temp > 0){
                sum += temp % 10;
            }

            num = sum;
        }

        return num;
    }

}