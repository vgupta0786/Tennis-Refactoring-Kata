public class TieScore {

    private Player player1;
    private Player player2;

    public TieScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Boolean findIfPlayersHasATie(Player player1, Player player2) {
        return player1.hasTieWith(player2);
    }

    public String nameForTie() {
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
