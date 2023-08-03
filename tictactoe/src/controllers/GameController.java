package controllers;

import models.Game;
import models.GameState;
import models.Player;
import models.PlayerType;
import services.BoardService;
import services.GameService;
import strategy.winningstrategy.ColWinningStrategy;
import strategy.winningstrategy.RowWinningStrategy;

import java.util.List;

/**
 *
 * simple interface to interact with Game for the controller
 *
 */
public class GameController {

    public Game createGame(int dimension, List<Player> playerList){

        return Game.getBuilder()
                .setPlayer(playerList)
                .addWinningStrategy(new ColWinningStrategy())
                .addWinningStrategy(new RowWinningStrategy())
                .setDimension(dimension)
                .build();


    }

    public void undo(){

    }

    public void displayBoard(Game game){
        BoardService boardService = new BoardService(game.getBoard());
        boardService.display();
    }

    public GameState getGameStatus(Game game){
        return game.getGameState();
    }

    public  void executeNextMove(Game game){

        GameService gameService = new GameService(game);
        gameService.executeNextMove();



    }
    public String getWinner(Game game){
        return game.getWinner(game).getName();
    }
}
