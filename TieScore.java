
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

}
