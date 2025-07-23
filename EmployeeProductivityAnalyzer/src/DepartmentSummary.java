import java.util.*;
import java.util.stream.*;

public class DepartmentSummary {

    public void departmentSummaryView(List<Employee> employees) {

    }

    public void scoreDistributionBuckets(List<Employee> employees) {
        employees.stream()
                .map(Employee::getProductivityScore)
                .flatMapToInt(Arrays::stream)
                .collect(Collectors.groupingBy(
                        score -> {
                            if (score > 75) {
                                return "Excellent";
                            } else if (score > 50 && score < 75) {
                                return "Average";
                            } else {
                                return "Poor";
                            }
                        },
                        Collectors.counting()));
    }

    public void departmentPerformanceGrades(List<Employee> employees) {

    }

    public void detectDecliningWeeklyPerformance(List<Employee> employees) {

    }

    public void sortedEmployeeLeaderboard(List<Employee> employees) {
        employees.stream().sorted(Comparator.comparing(Employee::getAverageScores)).forEach(System.out::println);

    }

    public static void main(String[] args) {

        Employee Alice = new Employee("Alice", Department.ENGINEERING, new int[] {10, 15, 30, 35, 50, 60});
        Employee Bob = new Employee("Bob", Department.HR, new int[] { 10, 15, 30, 35, 50, 60 });
        Employee Charlie = new Employee("Charlie", Department.MARKETTING, new int[] { 10, 15, 30, 35, 50, 60 });

        List<Employee> employees = new ArrayList<>();

        employees.add(Alice);
        employees.add(Bob);
        employees.add(Charlie);

        sortedEmployeeLeaderboard(employees);


    }
}