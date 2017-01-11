import java.util.List;
import static java.util.Arrays.asList;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }

    public void wonPoint(String playerName) {
        (player1.getName() == playerName ? player1 : player2).wonPoint();
    }

    private List<Score> scores() {
        return asList(new TieScore(player1, player2), new AdvantageScore(player1, player2),
                new WinScore(player1, player2), new NormalScore(player1, player2));
    }

    public String getScore() {
        for (Score score : scores()) {
            if (score.decide()) {
                return score.scoreName();
            }
        }
        return "";
    }
}
