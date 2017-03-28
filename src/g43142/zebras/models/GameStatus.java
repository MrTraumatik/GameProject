package g43142.zebras.models;

/**
 *Enum of the game status : tell what action needs to be done
 * @author dedec
 */
public enum GameStatus {
    /**
     * Game started, first player must place impala jones
     */
    INIT,
    /**
     * new round for player, must place animal
     */
    ANIMAL, 
    /**
     * animal has been placed, player must move impala jones
     */
    IMPALA;
}
