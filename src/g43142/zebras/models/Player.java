package g43142.zebras.models;

/**
 * Class of player
 * @author dedec
 */
public class Player {
    private Color color;

    /**
     *Constructor of a player with his color
     * @param color red or green
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     * Getter of the player's color
     * @return the player's color
     */
    public Color getColor() {
        return color;
    }    
}
