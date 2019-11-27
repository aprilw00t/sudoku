package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    List<Integer> cellRowOne;
    List<Integer> cellRowTwo;


    public List<Integer> getCellRow(int cellRow) {
        if(cellRow == 1){
        return cellRowOne;}
        else{
            return cellRowTwo;
        }
    }

    Cell(Integer cellSize){
        cellRowOne  = new ArrayList<>(cellSize -1);
        cellRowTwo = new ArrayList<>(cellSize-1);
        for (int i = 0; i < cellSize -1; i++) {
            cellRowOne.add(i, 0);
            cellRowTwo.add(i, 0);
        }
    }

}
