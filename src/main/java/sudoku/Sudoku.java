package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    private final Integer numberOfCells;

    Sudoku(Integer numberOfCells){

        this.numberOfCells = numberOfCells;
        for(int i = 0; i<numberOfCells; i++){

        }
    }

    public String showPuzzle(){
        String sudoku = "____\n____\n____\n____";
        System.out.println(sudoku);
        return sudoku;
    }

    public boolean checkCell(Cell cellToCheck, Integer numberInserted){
List<Integer> rowOne = cellToCheck.getCellRowOne();
        List<Integer> rowTwo = cellToCheck.getCellRowTwo();

        if(rowOne.contains(numberInserted) || rowTwo.contains(numberInserted)){
            return false;
        }
        else{
            cellToCheck.getCellRowOne().add(numberInserted);
return true;
        }
    }

    public void addNumberToCell(){

    }


}
