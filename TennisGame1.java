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
        if (findIfPlayersHasATie(player1,player2)) {
            return nameForTie();
        } else if (findIfPlayersAreInAdvantage(player1,player2)) {
            return "Advantage " + playerInAdvantage().getName();
        }else if (findIf1PlayerWinOverOther(player1,player2)) {
            return "Win for " + wonAgainst().getName();
        } else {
            return nameWhenPlayersScoreBelow4();
        }
    }
    
    public static Boolean findIfPlayersHasATie(Player player1, Player player2) {
               return player1.hasTieWith(player2);
    }
    
    public static Boolean findIfPlayersAreInAdvantage(Player player1, Player player2) {
        return player1.advantageOver(player2) || player2.advantageOver(player1);
    }

    private Player playerInAdvantage() {
        return player1.advantageOver(player2) ? player1 : player2;
    }
    
    public static Boolean findIf1PlayerWinOverOther(Player player1, Player player2) {
        return player1.wonAgainst(player2) || player2.wonAgainst(player1);
    }

    private Player wonAgainst() {
        return player1.wonAgainst(player2) ? player1 : player2;
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
