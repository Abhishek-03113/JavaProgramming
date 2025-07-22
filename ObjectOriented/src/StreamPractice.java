import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {


        List<Integer> participantScore = Arrays.asList(111, 222, 113, 411, 51, 336, 71, 81, 91, 100, 1020);
        List<Integer> participantScore2 = Arrays.asList(133, 233, 355, 466, 55, 64, 73, 82, 91, 100);
        List<Integer> participantScore3 = Arrays.asList(11, 22, 33, 44, 55, 66, 47, 38, 93, 1003);


        Participant p1 = new Participant("Alice", "computer", participantScore);
        Participant p2 = new Participant("John", "aids", participantScore2);
        Participant p3 = new Participant("Bob", "computer", participantScore3);

        List<Participant> participants = new ArrayList<>(Arrays.asList(p1, p2, p3));

        Collections.sort(participants);

        participants.forEach(participant -> System.out.println(participant.getName()));

        double average = participantScore.stream().collect(Collectors.averagingInt(Integer::intValue));


        System.out.println(average);


        participantScore.stream().max(Integer::compareTo).ifPresent(System.out::println);

        participants.sort(Comparator.comparing((Participant p) -> p.departmentName).thenComparingInt(p -> p.id));

        List<Participant> topKParticpiants = participants.stream().sorted(Comparator.comparing((Participant p) -> p.averageScore).reversed()).limit(1).toList();

        System.out.println(topKParticpiants);


        Map<String, Double> departmentWiseScores = participants.stream().collect(Collectors.groupingBy(Participant::getDepartmentName, Collectors.averagingDouble(Participant::getAverageScore)));


        List<Double> normalizedScores = participants.stream().flatMap(participant -> participant.getScores().stream()).collect(Collectors.collectingAndThen(Collectors.toList(), scores -> {
            int max = scores.stream().max(Integer::compareTo).orElse(0);
            return scores.stream().map(s -> (s * 100.0) / max).collect(Collectors.toList());
        }));


        List<String> sortedNames = participants.stream().map(Participant::getName).distinct().sorted(Comparator.naturalOrder()).toList();


        Map<String, List<Participant>> groupedByDepartment = participants.stream().collect(Collectors.groupingBy(Participant::getDepartmentName));

        List<Participant> winningParticipant = participants.stream().filter(participant -> participant.getScores().stream().allMatch(score -> score >= 40)).toList();
        List<Participant> perfectScorePeople = participants.stream().filter(participant -> participant.getScores().stream().anyMatch(score -> score == Participant.maxScore)).toList();

        Map<String, Long> failingPeople = participants.stream().filter(participant -> participant.getScores().stream().anyMatch(score -> score < 40)).collect(Collectors.groupingBy(Participant::getDepartmentName, Collectors.counting()));
        System.out.println(groupedByDepartment);
        System.out.println("Winning people" + winningParticipant);
        System.out.println("Perfect score people" + perfectScorePeople);
        System.out.println("Failing People : " + failingPeople);
        System.out.println(sortedNames);
        System.out.println(normalizedScores);
        System.out.println(departmentWiseScores.entrySet());


    }


}
