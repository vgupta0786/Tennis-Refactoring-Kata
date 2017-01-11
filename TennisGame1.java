public class TennisGame1 implements TennisGame {

    private static final String PLAYER1_NAME = "player1";
    private static final String PLAYER2_NAME = "player2";
    private int player1Score;
    private int player2Score;
    private String player1;
    private String player2;

    public TennisGame1(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String playerName) {
        if (playerName == PLAYER1_NAME)
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (scoresAreSame()) {
            return nameForTie();
        } else if (anyPlayerScoreAbove4()) {
            return nameWhenAtleast1PlayerScoreAbove4();
        } else {
            return nameWhenPlayersScoreBelow4();
        }
    }

    private String nameWhenPlayersScoreBelow4() {
        return nameFor(player1Score).append("-").append(nameFor(player2Score)).toString();
    }

    private String nameForTie() {
        return player1Score > 2 ? "Deuce" : nameFor(player1Score).append("-").append("All")
                .toString();
    }

    private String nameWhenAtleast1PlayerScoreAbove4() {
        String score;
        if (advantagePlayer1())
            score = "Advantage "+PLAYER1_NAME;
        else if (advantagePlayer2())
            score = "Advantage "+PLAYER2_NAME;
        else if (winForPlayer1())
            score = "Win for "+PLAYER1_NAME;
        else
            score = "Win for "+PLAYER2_NAME;
        return score;
    }

    private boolean winForPlayer1() {
        return player1Score - player2Score >= 2;
    }

    private boolean advantagePlayer2() {
        return player1Score - player2Score == -1;
    }

    private boolean advantagePlayer1() {
        return player1Score - player2Score == 1;
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
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean scoresAreSame() {
        return player1Score == player2Score;
    }
}
