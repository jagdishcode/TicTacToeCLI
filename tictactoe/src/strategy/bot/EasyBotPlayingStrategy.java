package strategy.bot;

import models.Board;
import models.CellStatus;
import models.Move;

/**
 *
 * EASY Bot playing strategy simply return first empty cell
 * this will suggest a move .
 *
 *
 */
public class EasyBotPlayingStrategy  implements BotPlayingStrategy{

    @Override
    public Move suggestMove(Board currBoard) {
        for(int i = 0; i < currBoard.getBoard().size(); i++){
            for(int j = 0; j < currBoard.getBoard().size(); j++){
                if(currBoard.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)){
                    return new Move(currBoard.getBoard().get(i).get(j));
                }
            }
        }

        return null;    }
}
