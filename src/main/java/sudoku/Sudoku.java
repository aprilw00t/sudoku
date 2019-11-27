package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    private final Integer numberOfCells;

    public List<Cell> getGrid() {
        return grid;
    }

    private final List<Cell> grid;

    Sudoku(Integer numberOfCells, Integer cellSize){
grid = new ArrayList<>(numberOfCells);
        this.numberOfCells = numberOfCells;
        for(int i = 0; i<numberOfCells; i++){
Cell cell = new Cell(cellSize);
grid.add(cell);
        }
    }

    public String showPuzzle(){
        String sudoku = "____\n____\n____\n____";
        System.out.println(sudoku);
        return sudoku;
    }

    public boolean checkCell(Cell cellToCheck, Integer numberInserted){
List<Integer> rowOne = cellToCheck.getCellRow(1);
        List<Integer> rowTwo = cellToCheck.getCellRow(2);

        if(rowOne.contains(numberInserted) || rowTwo.contains(numberInserted)){
            return false;
        }
        else{
return true;
        }
    }

    public void addNumberToCell(int numberToAdd, int cellNumber, int rowNumber, int columNumber){

        grid.get(cellNumber-1).getCellRow(rowNumber).add(columNumber-1, numberToAdd);
        System.out.println(grid.get(cellNumber-1).getCellRow(1));
        //grid.get(cellNumber).getCellRowOne().add(columNumber, numberToAdd);
    }


}
