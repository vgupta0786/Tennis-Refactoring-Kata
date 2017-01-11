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
        if (scoresAreSame()) {
            return nameForTie();
        } else if (advantagePlayer1()) {
            return "Advantage " + player1.getName();
        } else if (advantagePlayer2()) {
            return "Advantage " + player2.getName();
        } else if (winForPlayer1()) {
            return "Win for " + player1.getName();
        } else if (winForPlayer2()) {
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

    private boolean winForPlayer1() {
        return anyPlayerScoreAbove4() && player1.getScore() - player2.getScore() >= 2;
    }

    private boolean winForPlayer2() {
        return anyPlayerScoreAbove4() && player2.getScore() - player1.getScore() >= 2;
    }

    private boolean advantagePlayer2() {
        return anyPlayerScoreAbove4() && player1.getScore() - player2.getScore() == -1;
    }

    private boolean advantagePlayer1() {
        return anyPlayerScoreAbove4() && player1.getScore() - player2.getScore() == 1;
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

    private boolean anyPlayerScoreAbove4() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private boolean scoresAreSame() {
        return player1.getScore() == player2.getScore();
    }
}
