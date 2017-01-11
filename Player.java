public class Player {

    private String name;
    private Integer score = 0;

    public Player(String name) {
        super();
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void wonPoint() {
        score++;
    }

    public Boolean wonAgainst(Player otherPlayer) {
        return score >= 4 && score - otherPlayer.getScore() >= 2;
    }

    public Boolean advantageOver(Player otherPlayer) {
        return score >= 4 && score - otherPlayer.getScore() == 1;
    }

    public Boolean hasTieWith(Player otherPlayer) {
        return score == otherPlayer.getScore();
    }

}
