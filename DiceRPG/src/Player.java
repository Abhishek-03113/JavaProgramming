import java.util.HashSet;
import java.util.Set;

public class player {
    private String playerName;
    private Set<Hero> Heros;

    public player(String playerName) {
        this.playerName = playerName;
        Heros = new HashSet<Hero>();
    }
}