package models;

import strategy.bot.BotPlayingStrategy;
import strategy.bot.BotPlayingStrategyFactory;

import java.util.Scanner;

public class Bot extends Player{

    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, char symbol, int id,
               BotDifficultyLevel botDifficultyLevel,
               Scanner scanner) {
        super(name, symbol, id, PlayerType.BOT, scanner);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }



    //TODO: Override makeMove() method
    @Override
    public Move makeMove(Board currBoard)  {

        Move botMove =  botPlayingStrategy.suggestMove(currBoard);
        // NPE check
        if(botMove == null){
            return null;
        }
        System.out.printf("Bot is making move now : %d % d. \n", botMove.getCell().getRow(),botMove.getCell().getCol());
        botMove.getCell().setPlayer(this);
        botMove.getCell().setCellStatus(CellStatus.OCCUPIED);

        return botMove;
    }

}
