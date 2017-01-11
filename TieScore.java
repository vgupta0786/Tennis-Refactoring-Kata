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
        return player1.getScore() > 2 ? "Deuce" : nameFor(player1.getScore()).append("-")
                .append("All").toString();
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
