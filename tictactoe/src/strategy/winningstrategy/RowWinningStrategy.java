package strategy.winningstrategy;

import models.*;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int rowToCheck = move.getCell().getRow();
        Player movedPlayer = move.getCell().getPlayer();

        for(int i = 0; i < board.getBoard().size(); i++){
            Cell curCell = board.getBoard().get(rowToCheck).get(i);
            if(curCell.getCellStatus().equals(CellStatus.EMPTY) || !curCell.getPlayer().equals(movedPlayer)){
                return  false;
            }

        }
        return true;
    }
}
