import java.util.HashMap;
import java.util.Map;

public abstract class Score {

    protected Player player1;
    protected Player player2;

    public Score(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public abstract Boolean decide();

    public abstract String scoreName();
    
    public Map<Integer, String> nameFor() {
        Map<Integer, String> nameForScore = new HashMap<Integer, String>();
        nameForScore.put(0, "Love");
        nameForScore.put(1, "Fifteen");
        nameForScore.put(2, "Thirty");
        nameForScore.put(3, "Forty");
        return nameForScore;
    }
}
