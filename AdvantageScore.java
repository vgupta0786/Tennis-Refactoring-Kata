
public class AdvantageScore {
    
    private Player player1;
    private Player player2;

    public AdvantageScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public Boolean findIfPlayersAreInAdvantage(Player player1, Player player2) {
        return player1.advantageOver(player2) || player2.advantageOver(player1);
    }

    public Player playerInAdvantage() {
        return player1.advantageOver(player2) ? player1 : player2;
    }

}
