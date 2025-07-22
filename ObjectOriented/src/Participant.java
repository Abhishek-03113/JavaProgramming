import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Participant implements Comparable<Participant> {
    public static int maxScore = 100;
    public String name;
    public int id;
    public double averageScore;
    public String departmentName;
    public List<Integer> scores;

    public List<Integer> getScores() {
        return scores;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int failingRounds(){
        return scores.stream().filter(score -> score < 40).toList().size();
    }

    public Participant(String name, String departmentName, List<Integer> scores) {
        this.name = name;
        this.departmentName = departmentName;
        this.scores = scores;
        id = 1;
        this.averageScore = getAverageScore();
    }

    public double getAverageScore() {
        this.averageScore = scores.stream().mapToInt(Integer::intValue).sum();
        return averageScore/scores.size();
    }

    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Participant o) {

        if ((int)this.averageScore - (int)o.averageScore != 0) {
            if ((int) this.averageScore > (int) o.averageScore) {
                return -1;
            }
            else if ((int) this.averageScore < (int) o.averageScore) {return  1;}

        }
        else{
            return this.name.compareTo(o.name);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Participant [name=" + name + ", averageScore=" + averageScore + ", departmentName=" + departmentName + ", scores=" + scores + "]";
    }
}


