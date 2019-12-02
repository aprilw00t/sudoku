package sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cell {
    private Map<Integer, ArrayList<Integer>> columnsInsideCells = new HashMap<>();
    private Map<Integer, ArrayList<Integer>> rowsInsideCells = new HashMap<>();
//
//    private  List<Integer> cellColumnOne;
//    private  List<Integer> cellColumnTwo;
//    private List<Integer> cellRowOne;
//   private List<Integer> cellRowTwo;

    public Integer getCellRowNumber() {
        return cellRowNumber;
    }


    private final Integer cellRowNumber;

    public Integer getCellColumnNumber() {
        return cellColumnNumber;
    }

    private final Integer cellColumnNumber;


//    public List<Integer> getCellRow(int cellRow) {
//        if(cellRow == 1){
//        return cellRowOne;}
//        else{
//            return cellRowTwo;
//        }
//    }
//
//    public List<Integer> getCellColumn(int cellColumn) {
//        if(cellColumn == 1){
//            return cellColumnOne;}
//        else{
//            return cellColumnTwo;
//        }
//    }


    public List<Integer> getCellRowFromMap(int cellRow) {
        return rowsInsideCells.get(cellRow);
    }


    public List<Integer> getCellColumnFromMap(int cellColumn) {
        return columnsInsideCells.get(cellColumn);
    }


    Cell(Integer cellSize, Integer cellRowNumber, Integer cellColumnNumber) {

        for (int i = 1; i <= cellSize; i++) {
            ArrayList<Integer> listOfColumnNumbers = new ArrayList<Integer>(cellSize);
            ArrayList<Integer> listOfRowNumbers = new ArrayList<Integer>(cellSize);
            columnsInsideCells.put(i, listOfColumnNumbers);
            rowsInsideCells.put(i, listOfRowNumbers);
        }

        for (Map.Entry<Integer, ArrayList<Integer>> rowNumberAndNumberList : rowsInsideCells.entrySet()
        ) {
            for (int i = 0; i < cellSize; i++) {
                rowNumberAndNumberList.getValue().add(0);
            }

        }

        for (Map.Entry<Integer, ArrayList<Integer>> columnNumberAndNumberList : columnsInsideCells.entrySet()
        ) {
            for (int i = 0; i < cellSize; i++) {
                columnNumberAndNumberList.getValue().add(0);
            }

        }
//
//        cellRowOne  = new ArrayList<>(cellSize);
//        cellRowTwo = new ArrayList<>(cellSize);
//        cellColumnTwo = new ArrayList<>(cellSize);
//        cellColumnOne = new ArrayList<>(cellSize);
        this.cellRowNumber = cellRowNumber;
        this.cellColumnNumber = cellColumnNumber;
//        for (int i = 0; i < cellSize; i++) {
//            cellColumnOne.add(i, 0);
//            cellColumnTwo.add(i,0);
//            cellRowOne.add(i, 0);
//            cellRowTwo.add(i, 0);
//        }
    }

    @Override
    public String toString() {
        return "Cell{" +
                "columnsInsideCells=" + columnsInsideCells +
                ", rowsInsideCells=" + rowsInsideCells +
                ", cellRowNumber=" + cellRowNumber +
                ", cellColumnNumber=" + cellColumnNumber +
                '}';
    }

    //    @Override
//    public String toString() {
//        StringBuilder rows = new StringBuilder();
//        for (Map.Entry<Integer, ArrayList<Integer>> rowsInMap : rowsInsideCells.entrySet()
//        ) {
//            rows.append(rowsInMap.getValue());
//            rows.append("\n");
//        }
//        return rows.toString();
//    }

    public String rowToString(int rowNumber) {
        StringBuilder row = new StringBuilder();
        row.append(rowsInsideCells.get(rowNumber));

        return row.toString();
    }
//
//    public String columnToString() {
//        return cellColumnOne + "\n" + cellColumnTwo+ "\n"+
//                " cellRowNumber = " + cellRowNumber + " cellColumnNumber = " + cellColumnNumber;
//    }
}
