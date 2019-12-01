package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private  List<Integer> cellColumnOne;
    private  List<Integer> cellColumnTwo;
    private List<Integer> cellRowOne;
   private List<Integer> cellRowTwo;

    public Integer getCellRowNumber() {
        return cellRowNumber;
    }


    private final Integer cellRowNumber;

    public Integer getCellColumnNumber() {
        return cellColumnNumber;
    }

    private final Integer cellColumnNumber;


    public List<Integer> getCellRow(int cellRow) {
        if(cellRow == 1){
        return cellRowOne;}
        else{
            return cellRowTwo;
        }
    }

    public List<Integer> getCellColumn(int cellColumn) {
        if(cellColumn == 1){
            return cellColumnOne;}
        else{
            return cellColumnTwo;
        }
    }

    Cell(Integer cellSize, Integer cellRowNumber, Integer cellColumnNumber){
        cellRowOne  = new ArrayList<>(cellSize);
        cellRowTwo = new ArrayList<>(cellSize);
        cellColumnTwo = new ArrayList<>(cellSize);
        cellColumnOne = new ArrayList<>(cellSize);
        this.cellRowNumber = cellRowNumber;
        this.cellColumnNumber = cellColumnNumber;
        for (int i = 0; i < cellSize; i++) {
            cellColumnOne.add(i, 0);
            cellColumnTwo.add(i,0);
            cellRowOne.add(i, 0);
            cellRowTwo.add(i, 0);
        }
    }

    @Override
    public String toString() {
        return cellRowOne + "\n" + cellRowTwo+ "\n"+
                " cellRowNumber = " + cellRowNumber + " cellColumnNumber = " + cellColumnNumber;
    }

    public String rowOneToString() {
        return cellRowOne.toString();
    }
    public String rowTwoToString() {
        return cellRowTwo.toString();
    }

    public String columnToString() {
        return cellColumnOne + "\n" + cellColumnTwo+ "\n"+
                " cellRowNumber = " + cellRowNumber + " cellColumnNumber = " + cellColumnNumber;
    }
}
