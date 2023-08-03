import controllers.GameController;
import models.*;
import strategy.bot.BotPlayingStrategy;
import strategy.winningstrategy.ColWinningStrategy;
import strategy.winningstrategy.RowWinningStrategy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {




        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        System.out.println("Lets begin Tic Tac Toe .........");
        System.out.println("What dimension of the board do you need ?");
        int dimension = sc.nextInt();

        System.out.println("How many players?");
        int numberOfPlayer = sc.nextInt();
        System.out.println("Will there be a bot in the game? Y or N");
        String  isBot = sc.next().toUpperCase();
        if(isBot.equals("Y")){
            numberOfPlayer = numberOfPlayer - 1;
        }

        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayer; i++){
            System.out.println("Enter the name of the player : " + i);
            String playerName = sc.next();
            System.out.println("Enter the player symbol : ");

            Character symbol = sc.next().charAt(0);
            playerList.add(
                    new Player(playerName, symbol,
                            i, PlayerType.HUMAN, sc));
        }
        if(isBot.equals("Y")){
            System.out.println("Enter the name of the bot : " );
            String playerName = sc.next();
            System.out.println("Enter the bot player symbol : ");

            Character symbol = sc.next().charAt(0);
            playerList.add(
                    new Bot(playerName, symbol,2,  BotDifficultyLevel.EASY, sc));
        }
        Game game = gameController.createGame(dimension, playerList);

        while (gameController.getGameStatus(game).equals(GameState.IN_PROGRESS)){
            System.out.println("This is the current Board: ");
            gameController.displayBoard(game);
            System.out.println();
            //TODO: add undo check here
            gameController.executeNextMove(game);
        }
        System.out.println("Results of the game: ");

        if(gameController.getGameStatus(game).equals(GameState.DRAW)){
            System.out.println("GAME IS DRAW");
        }else{
            System.out.println("The winner is: " + gameController.getWinner(game));
        }


    }
}