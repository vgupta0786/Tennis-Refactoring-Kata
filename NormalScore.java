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
        return nameFor(player1.getScore()).append("-").append(nameFor(player2.getScore()))
                .toString();
    }

    private StringBuilder nameFor(int currentPlayerScore) {
        StringBuilder name = new StringBuilder();
        switch (currentPlayerScore) {
            case 0:
                name.append("Love");
                break;
            case 1:
                name.append("Fifteen");
                break;
            case 2:
                name.append("Thirty");
                break;
            case 3:
                name.append("Forty");
                break;
        }
        return name;
    }

}
