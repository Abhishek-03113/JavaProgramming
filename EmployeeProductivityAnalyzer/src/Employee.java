import java.util.Arrays;
import java.util.stream.Collectors;

public class Employee {

    private String name;
    private Department department;
    private int[] productivityScore;
    private double averageScores;

    public double getAverageScores() {
        return averageScores;
    }

    public void setAverageScores(double averageScores) {
        this.averageScores = averageScores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int[] getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(int[] productivityScore) {
        this.productivityScore = productivityScore;
    }

    public Employee(String name, Department department, int[] productivityScore) {
        this.name = name;
        this.department = department;
        this.productivityScore = productivityScore;
        this.averageScores = 0;
    }

    public void calculateAverageScore() {
        this.averageScores = Arrays.stream(productivityScore).mapToDouble(e -> e).average().getAsDouble();
    }

    public void validateInputs(String name, Department department, int[] productivityScore) throws Exception {
        if (name.isEmpty()) {
            throw new Exception("Invalid Name");
        } else if (name.isEmpty()) {
            throw new Exception("Invlid Department Name");
        } else {
            for (int i = 0; i < productivityScore.length; i++) {
                if (productivityScore[i] < 0 || productivityScore[i] > 100) {
                    throw new InvalidScoreException();
                }
            }
        }
    }
}
