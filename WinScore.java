public class WinScore extends Score {

    public WinScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean decide() {
        return player1.wonAgainst(player2) || player2.wonAgainst(player1);
    }

    @Override
    public String scoreName() {
        return "Win for " + (player1.wonAgainst(player2) ? player1 : player2).getName();
    }

}
