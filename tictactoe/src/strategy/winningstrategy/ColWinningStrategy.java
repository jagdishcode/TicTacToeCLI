package strategy.winningstrategy;

import models.*;

/**
 * ColWinningStrategy return boolean
 * to asnwer weather the player who played
 * the last move has won the game or not
 *
 * By checking every cel in that column should have symbol
 */
public class ColWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int columnToCheck = move.getCell().getCol();
        Player movedPlayer = move.getCell().getPlayer();

        for(int i = 0; i < board.getBoard().size(); i++){
            Cell curCell = board.getBoard().get(i).get(columnToCheck);
            if(curCell.getCellStatus().equals(CellStatus.EMPTY) || !curCell.getPlayer().equals(movedPlayer)){
                return  false;
            }

        }
        return true;
    }
}
