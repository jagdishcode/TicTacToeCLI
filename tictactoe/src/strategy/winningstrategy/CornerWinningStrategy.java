package strategy.winningstrategy;

import models.*;

public class CornerWinningStrategy implements  WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        Player curPlayer = move.getCell().getPlayer();
        int boardSize = board.getBoard().size();

        //if(board.getBoard().get(0).get(0).getCellStatus())
        int[] row = {0,0,boardSize-1, boardSize-1};
        int[] col = {boardSize-1, 0, boardSize-1, 0};

        for(int i = 0; i < 4; i++){
            Cell currentCell = board.getBoard().get(row[i]).get(col[i]);
            if(currentCell.getCellStatus().equals(CellStatus.EMPTY) || !currentCell.getPlayer().equals(curPlayer)){
                return false;
            }
        }

        return true;
    }
}
