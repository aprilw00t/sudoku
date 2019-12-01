package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    private final Integer numberOfCells;
    double numberOfCellsInEachRow;
    public List<Cell> getGrid() {
        return grid;
    }

    private final List<Cell> grid;
    private final Integer cellSize;

    Sudoku(Integer numberOfCells, Integer cellSize) {
        this.numberOfCells = numberOfCells;
        grid = new ArrayList<>(numberOfCells);
        this.cellSize = cellSize;
        int cellRowNumber = 1;
        int cellColumnNumber=1;
        //double numberOfCellRows = Math.sqrt(numberOfCells);
        numberOfCellsInEachRow = numberOfCells/Math.sqrt(numberOfCells);
        for (int i = 1; i <= numberOfCells; i++) {
                Cell cell = new Cell(cellSize, cellRowNumber, cellColumnNumber);
                grid.add(cell);
                cellColumnNumber++;
            if(i % numberOfCellsInEachRow == 0){
                cellColumnNumber = 1;
                cellRowNumber++;}
        }
    }

    public String showPuzzle() {
        StringBuilder sudoku = new StringBuilder();

      for (Cell cellInGrid : grid) {
            sudoku.append(cellInGrid.toString());
            sudoku.append("\n");
        }

        System.out.println(sudoku);
        return sudoku.toString();
    }

    public boolean checkCell(Cell cellToCheck, Integer numberInserted) {
        List<Integer> rowOne = cellToCheck.getCellRow(1);
        List<Integer> rowTwo = cellToCheck.getCellRow(2);

        if (rowOne.contains(numberInserted) || rowTwo.contains(numberInserted)) {
            return false;
        } else {
            return true;
        }
    }

    public void addNumberToCell(int numberToAdd, int cellRow, int cellColumn, int rowNumber, int columNumber) {
        int cellPlaceInList = cellColumn*cellRow;
        grid.get(cellPlaceInList - 1).getCellRow(rowNumber).set(columNumber-1, numberToAdd);
        grid.get(cellPlaceInList - 1).getCellColumn(columNumber).set(rowNumber-1, numberToAdd);

                //add(columNumber - 1, numberToAdd);

    }

    public boolean checkRow(int cellRowNumber, int rowToCheck, Integer numberInserted) {
        for (Cell cellToCheck : grid) {
            if (cellToCheck.getCellRowNumber().equals(cellRowNumber) && cellToCheck.getCellRow(rowToCheck).contains(numberInserted)) {
                return false;
            }
        }
        return true;
    }


    public boolean checkColumn(int cellColumnNumber, int columnToCheck, int numberInserted) {

        for (Cell cellToCheck : grid) {
            if (cellToCheck.getCellColumnNumber().equals(cellColumnNumber) && cellToCheck.getCellColumn(columnToCheck).contains(numberInserted)) {
                return false;
            }
        }
        return true;

    }

    public String showColumns() {
        StringBuilder sudoku = new StringBuilder();

        for (Cell cellInGrid : grid) {
            sudoku.append(cellInGrid.columnToString());
            sudoku.append("\n");
        }
        System.out.println(sudoku);
        return sudoku.toString();
    }

    public void validateMyNumber(int number, int horizontalPlace, int verticalPlace){
//cellColumn = numberOfCells/horizontalPlace rounded down
        //cellRow = numberOfCells/verticalPlace rounded down
        //rowNumberInsideCell =
        //columnNumberInsideCell =
    }
}
