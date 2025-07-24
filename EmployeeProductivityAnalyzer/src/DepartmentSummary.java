import java.util.*;
import java.util.stream.*;

public class DepartmentSummary {


    void departmentSummaryView(List<Employee> employees) {
        System.out.println(employees.stream().collect(Collectors.groupingBy(employee -> "[" + employee.getDepartment() + "]" + " " + employee.getDepartment().getDescription(), Collectors.counting())));

    }

    public void scoreDistributionBuckets(List<Employee> employees) {
        System.out.println(employees.stream()
                .map(Employee::getProductivityScore)
                .flatMapToInt(Arrays::stream)
                .boxed()
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
                        Collectors.counting())));
    }

    public void departmentPerformanceGrades(List<Employee> employees) {

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(emp -> emp.getAverageScores()))));


    }

    public void detectDecliningWeeklyPerformance(List<Employee> employees) {

        for  (Employee employee : employees) {
            int flg =1;
            int[] prodScores = employee.getProductivityScore();
            for (int i = 1; i < prodScores.length; i++) {
                if (prodScores[i] > prodScores[i-1]) {
                    flg = 0;
                    break;
                }

            }
            if (flg == 1){
                System.out.println(employee.getName());
            }
            else{
                continue;
            }
        }

    }

    public void sortedEmployeeLeaderboard(List<Employee> employees) {
        employees.stream().sorted(Comparator.comparing(Employee::getAverageScores)).forEach(e-> System.out.println(e.getName()));

    }

    public static void main(String[] args) {

        List<Employee> employees = null;
        try {
            employees = List.of(
                    new Employee("Alice", Department.ENGINEERING, new int[]{85, 88, 89, 87}),
                    new Employee("Bob", Department.MARKETING, new int[]{60, 70, 65, 78}),
                    new Employee("Charlie", Department.SALES, new int[]{90, 92, 95, 88}),
                    new Employee("Diana", Department.HR, new int[]{50, 45, 40, 35}),
                    new Employee("Eva", Department.ENGINEERING, new int[]{80, 31, 85, 81})
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        DepartmentSummary departmentSummary = new DepartmentSummary();

        if (employees != null) {
            departmentSummary.sortedEmployeeLeaderboard(employees); //working
            departmentSummary.departmentSummaryView(employees); //working
            departmentSummary.scoreDistributionBuckets(employees);//working
            departmentSummary.detectDecliningWeeklyPerformance(employees); // working
            departmentSummary.departmentPerformanceGrades(employees); //working
        }
        else{
            System.out.println("Exception found");
        }


    }
}