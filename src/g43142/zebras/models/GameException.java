package g43142.zebras.models;

/**
 * Exception class for the game. Will be use if an error happens because
 * of a game related problem (board game is full, no more animals ...).
 * 
 * @author dedec
 */
public class GameException extends Exception {

    /**
     * Creates a new instance of <code>GameException</code> without detail
     * message.
     */
    public GameException() {
    }

    /**
     * Constructs an instance of <code>GameException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GameException(String msg) {
        super(msg);
    }
}
