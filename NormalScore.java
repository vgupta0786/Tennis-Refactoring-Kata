import java.util.HashMap;
import java.util.Map;

public class NormalScore extends Score {

    public NormalScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean decide() {
        return player1.getScore() <= 3 && player2.getScore() <= 3;
    }

    @Override
    public String scoreName() {
        return nameFor().get(player1.getScore()) + "-" + nameFor().get(player2.getScore());
    }

    private Map<Integer, String> nameFor() {
        Map<Integer, String> nameForScore = new HashMap<Integer, String>();
        nameForScore.put(0, "Love");
        nameForScore.put(1, "Fifteen");
        nameForScore.put(2, "Thirty");
        nameForScore.put(3, "Forty");
        return nameForScore;
    }

}
