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
        int cellColumnNumber = 1;
        //double numberOfCellRows = Math.sqrt(numberOfCells);
        numberOfCellsInEachRow = numberOfCells / Math.sqrt(numberOfCells);
        for (int i = 1; i <= numberOfCells; i++) {
            Cell cell = new Cell(cellSize, cellRowNumber, cellColumnNumber);
            grid.add(cell);
            cellColumnNumber++;
            if (i % numberOfCellsInEachRow == 0) {
                cellColumnNumber = 1;
                cellRowNumber++;
            }
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

    public boolean checkCellAndNumber(int cellRowNumber, int cellColumnNumber, Integer numberInserted) {
boolean check = false;
        for (Cell cellInGrid : grid) {
            if(cellInGrid.getCellRowNumber() == cellRowNumber && cellInGrid.getCellColumnNumber() == cellColumnNumber) {
                List<Integer> rowOne = cellInGrid.getCellRow(1);
                List<Integer> rowTwo = cellInGrid.getCellRow(2);

                if (rowOne.contains(numberInserted) || rowTwo.contains(numberInserted)) {
                    check = false;
                } else if (numberInserted < 1 || numberInserted > (numberOfCellsInEachRow * cellSize)) {
                    System.out.println("invalid number");
                    check = false;
                } else {
                    check = true;
                }
            }
    }
    return check;}

    public void addNumberToCell(int numberToAdd, int cellRow, int cellColumn, int rowNumber, int columNumber) {
        int cellPlaceInList = cellColumn * cellRow;
        grid.get(cellPlaceInList - 1).getCellRow(rowNumber).set(columNumber - 1, numberToAdd);
        grid.get(cellPlaceInList - 1).getCellColumn(columNumber).set(rowNumber - 1, numberToAdd);


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

    public boolean checkForEmptyCell(int cellRowNumber, int cellColumnNumber, int rowNumberInsideCell, int columnNumberInsideCell)
    {boolean check = false;

        for (Cell cellInGrid : grid) {

        if(cellInGrid.getCellRowNumber() == cellRowNumber && cellInGrid.getCellColumnNumber() == cellColumnNumber)
        {
            if(cellInGrid.getCellRow(rowNumberInsideCell).get(columnNumberInsideCell-1).equals(0)){
                check = true;
            }
            else{
                check = false;
                System.out.println("already a number here");
            }
        }
        }

        return check;
    }


    public boolean validateMyNumber(int number, double horizontalPlace, double verticalPlace) {
//cellColumn = horizontalPlace/sizeOfCell rounded up
//cellRow = verticalPlace/sizeOfCell rounded up
        //rowNumberInsideCell = (sizeOfCell) * (horizontalPlace/sizeOfCell - (cellColumn -1))
        //columnNumberInsideCell = (sizeOfCell) * (verticalPlace/sizeOfCell - (cellRow -1))
        Double cellColumn = (horizontalPlace / cellSize);
        Integer cellColumnNumber = (int) (Math.ceil(horizontalPlace / cellSize));
        Integer cellRowNumber = (int)( Math.ceil(verticalPlace / cellSize));
        Integer columnNumberInsideCell = (int)((cellSize) * ((horizontalPlace / cellSize) - (cellColumnNumber - 1)));
        Integer rowNumberInsideCell = (int)((cellSize) * ((verticalPlace / cellSize) - (cellRowNumber - 1)));
boolean rowCheck = checkRow(cellRowNumber, rowNumberInsideCell, number);
boolean columnCheck = checkColumn(cellColumnNumber, columnNumberInsideCell, number);
boolean cellCheck = checkCellAndNumber(cellColumnNumber,cellRowNumber, number);
boolean checkForEmptyCell = checkForEmptyCell(cellRowNumber, cellColumnNumber, rowNumberInsideCell, columnNumberInsideCell);
if(rowCheck&&columnCheck&&cellCheck&&checkForEmptyCell){
    addNumberToCell(number, cellRowNumber, cellColumnNumber,  rowNumberInsideCell, columnNumberInsideCell);
return true;
}
else {

    System.out.println("NOT ALLOW >:(");
    return false;
}
    }
}
