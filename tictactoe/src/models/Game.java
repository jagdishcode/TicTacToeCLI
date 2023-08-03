package models;

import javafx.util.Builder;
import strategy.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Run the application then Game will ask for the player their name.
 * We ask them to choose a symbol
 * ex : "X", "0" "O"
 *
 *
 */

public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    int currentPlayerMoveIndex;

    Player nextPlayerTurn;
    GameState gameState;
    Player winner;
    List<WinningStrategy> winningStrategies;

    //TODO():Add builder design pattern

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.currentPlayerMoveIndex = 0;
        this.gameState = GameState.IN_PROGRESS;

    }
    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        // Players
        // Dimension
        // winning strategy

        List<Player> players;
        List<WinningStrategy> winningStrategies;
        int dimension;


        private Builder(){
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public Builder setPlayer(List<Player> players){
            this.players = players;
            return  this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies){
            this.winningStrategies = winningStrategies;
            return  this;
        }

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return  this;
        }

//        public void

        public Game build(){
            // validations here
            return new Game(dimension, players, winningStrategies);
        }


    }

    //TODO: SRP, Controller, services
//    public void makeMove(){
//        Player currentPlayer = players.get(currentPlayerMoveIndex);
//        System.out.printf("Player turn : %s", currentPlayer.getName());
//
//        Move move = currentPlayer.makeMove(board);
//        moves.add(move);
////        this.board.getBoard().get(move.getCell().setPlayer(currentPlayer));
//        int row = move.getCell().getRow();
//        int col = move.getCell().getCol();
//
//    // updating the cell in the board with the move that player took
//        this.board.getBoard().get(row).set(col, move.getCell());
//
//        for(WinningStrategy winningStrategy: winningStrategies){
//            if(winningStrategy.checkWinner(board, move)){
//                System.out.printf("This Player %s has won. \n ", currentPlayer.getName());
//                gameState = GameState.WIN;
//                break;
//            }
//        }
//        currentPlayerMoveIndex = (currentPlayerMoveIndex+1)%players.size();
//    //Display the board
//        this.board.display();
//
//
//
//    }

    public Board getBoard(){
        return board;
    }
    public GameState getGameState(){
        return gameState;
    }

    public Player getCurrentPlayer(){
        return players.get(currentPlayerMoveIndex);
    }

    public void addMove(Move move){
        moves.add(move);
    }

    public List<WinningStrategy> getWinningStrategies(){
        return winningStrategies;
    }

    public void setWinner(Player winner){
        this.winner = winner;
    }

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }


    public  void nextPlayerTurn(){
        currentPlayerMoveIndex = (currentPlayerMoveIndex+1)%players.size();
    }

    public  void updateBoard(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // updating the cell in the board with the move that player took
        this.board.getBoard().get(row).set(col, move.getCell());
    }

    public  Player getWinner(Game game){
        return winner;
    }
}

