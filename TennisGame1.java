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
        if (tie.findIfPlayersHasATie(player1, player2)) {
            return tie.nameForTie();
        } else if (advantage.findIfPlayersAreInAdvantage(player1, player2)) {
            return "Advantage " + advantage.playerInAdvantage().getName();
        } else if (win.findIf1PlayerWinOverOther(player1, player2)) {
            return "Win for " + win.wonAgainst().getName();
        } else {
            return normal.nameWhenPlayersScoreBelow4();
        }
    }
}
