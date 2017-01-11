public class AdvantageScore extends Score {

    public AdvantageScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean decide() {
        return player1.advantageOver(player2) || player2.advantageOver(player1);
    }

    @Override
    public String scoreName() {
        return "Advantage " + (player1.advantageOver(player2) ? player1 : player2).getName();
    }
}
