public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;
    private TieScore tie;
    private NormalScore normal;
    private WinScore win;
    private AdvantageScore advantage;

    public TennisGame1(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        tie = new TieScore(this.player1, this.player2);
        normal = new NormalScore(this.player1, this.player2);
        win = new WinScore(this.player1, this.player2);
        advantage = new AdvantageScore(this.player1, this.player2);
    }

    public void wonPoint(String playerName) {
        if (playerName == player1.getName())
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        if (tie.decide(player1, player2)) {
            return tie.scoreName();
        } else if (advantage.decide(player1, player2)) {
            return advantage.scoreName();
        } else if (win.decide(player1, player2)) {
            return win.scoreName();
        } else {
            return normal.scoreName();
        }
    }
}
