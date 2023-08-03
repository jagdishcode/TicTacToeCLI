package strategy.bot;

import models.Board;
import models.Move;

public interface BotPlayingStrategy {
    // TODO: implement by getting player and board
    //Move makeMove()
    Move suggestMove(Board currBoard);

}
