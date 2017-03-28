/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g43142.zebras;

import g43142.zebras.models.GameStatus;
import g43142.zebras.models.ImpalaJones;
import g43142.zebras.models.Pieces;
import g43142.zebras.models.Player;
import g43142.zebras.models.Reserve;
import java.util.List;

/**
 *
 * @author dedec
 */
public class Game {
    private List<Player> players;
    private Reserve reserve;
    private ImpalaJones impala;
    private Pieces pieces;
    private GameStatus status;
    private Player currentPlayer;

    public Game(List<Player> players, Reserve reserve, ImpalaJones impala, Pieces pieces, GameStatus status, Player currentPlayer) {
        this.players = players;
        this.reserve = reserve;
        this.impala = impala;
        this.pieces = pieces;
        this.status = status;
        this.currentPlayer = currentPlayer;
    }
    
}
