
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

}
