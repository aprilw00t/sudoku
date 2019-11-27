package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    List<Integer> cellRowOne;
    List<Integer> cellRowTwo;

    public List<Integer> getCellRowOne() {
        return cellRowOne;
    }

    public void setCellRowOne(List<Integer> cellRowOne) {
        this.cellRowOne = cellRowOne;
    }

    public List<Integer> getCellRowTwo() {
        return cellRowTwo;
    }

    public void setCellRowTwo(List<Integer> cellRowTwo) {
        this.cellRowTwo = cellRowTwo;
    }

    Cell(){
        cellRowOne  = new ArrayList<>(3);
        cellRowTwo = new ArrayList<>(3);
    }

}
