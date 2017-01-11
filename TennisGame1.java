public class TennisGame1 implements TennisGame {

    private static final String PLAYER1_NAME = "player1";
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
        String score = "";
        int currentPlayerScore;
        if (scoresAreSame()) {
            switch (player1Score) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (anyPlayerScoreAbove4()) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1)
                score = "Advantage player1";
            else if (minusResult == -1)
                score = "Advantage player2";
            else if (minusResult >= 2)
                score = "Win for player1";
            else
                score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1)
                    currentPlayerScore = player1Score;
                else {
                    score += "-";
                    currentPlayerScore = player2Score;
                }
                score += nameForCurrentPlayerScore(currentPlayerScore);
            }
        }
        return score;
    }

    private String nameForCurrentPlayerScore(int currentPlayerScore) {
        String name="";
        switch (currentPlayerScore) {
            case 0:
                name += "Love";
                break;
            case 1:
                name += "Fifteen";
                break;
            case 2:
                name += "Thirty";
                break;
            case 3:
                name += "Forty";
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
