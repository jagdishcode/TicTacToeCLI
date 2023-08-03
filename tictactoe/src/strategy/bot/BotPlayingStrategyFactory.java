package strategy.bot;

import models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        return new EasyBotPlayingStrategy();
    }
}
