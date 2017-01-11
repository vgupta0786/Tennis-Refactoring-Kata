import java.util.HashMap;
import java.util.Map;

public class TieScore extends Score {

    public TieScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean decide() {
        return player1.hasTieWith(player2);
    }

    @Override
    public String scoreName() {
        return player1.getScore() > 2 ? "Deuce" : nameFor().get(player1.getScore()) + "-All";
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
