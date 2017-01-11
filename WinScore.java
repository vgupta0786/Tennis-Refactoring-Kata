public class WinScore {

    private Player player1;
    private Player player2;

    public WinScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Boolean decide(Player player1, Player player2) {
        return player1.wonAgainst(player2) || player2.wonAgainst(player1);
    }

    public String scoreName() {
        return "Win for " + (player1.wonAgainst(player2) ? player1 : player2).getName();
    }

}
