public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }

    public void wonPoint(String playerName) {
        if (playerName == player1.getName())
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        if (player1.hasTieWith(player2)) {
            return nameForTie();
        } else if (player1.advantageOver(player2)) {
            return "Advantage " + player1.getName();
        } else if (player2.advantageOver(player1)) {
            return "Advantage " + player2.getName();
        } else if (player1.wonAgainst(player2)) {
            return "Win for " + player1.getName();
        } else if (player2.wonAgainst(player1)) {
            return "Win for " + player2.getName();
        } else {
            return nameWhenPlayersScoreBelow4();
        }
    }

    private String nameWhenPlayersScoreBelow4() {
        return nameFor(player1.getScore()).append("-").append(nameFor(player2.getScore()))
                .toString();
    }

    private String nameForTie() {
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
