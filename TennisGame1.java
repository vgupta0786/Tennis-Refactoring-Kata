public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;
    private Score tie;
    private Score normal;
    private Score win;
    private Score advantage;

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
        if (tie.decide()) {
            return tie.scoreName();
        } else if (advantage.decide()) {
            return advantage.scoreName();
        } else if (win.decide()) {
            return win.scoreName();
        } else {
            return normal.scoreName();
        }
    }
}
