package models;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Player {
    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getId() {
        return id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    private String name;
    private char symbol;
    private int id;
    private PlayerType playerType;
    private  Scanner scanner;

    private static boolean cellAvailabity(Board board){

        for(int i = 0; i < board.getBoard().size(); i++){
            for(int j = 0; j < board.getBoard().size(); j++){
                if(board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)){
                    return true;
                }
            }
        }

        return false;
    }


    public Player(String name, char symbol, int id, PlayerType playerType, Scanner scanner){
        this.name = name;
        this.symbol = symbol;
        this.id = id;
        this.playerType = playerType;
        this.scanner = scanner;
    }

    //TODO(Jagdish): Add a method to make move and make it simple once implemented
    public Move makeMove(Board currBoard)  {

        if(!cellAvailabity(currBoard)){
            return null;
        }
        System.out.println("Enter the cell row and col number : ");

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        // currBoard.getBoard().get(row).get(col)  --> get the cell from the board
        // Update the cell --> board ends up getting updated

        Cell cell = currBoard.getBoard().get(row).get(col);

        System.out.printf("The player %s is making a move at cell : %d %d \n",
                this.name, cell.getRow(), cell.getCol());
        if(cell.getCellStatus().equals(CellStatus.OCCUPIED)){
            throw new IllegalArgumentException("The cell is occupied");
        }
        cell.setPlayer(this);
        cell.setCellStatus(CellStatus.OCCUPIED);
        return new Move(cell);
    }

}
