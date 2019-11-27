package sudoku;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SudokuTest {

    private Sudoku sudoku;

    @Before
    public void setUp() {
        sudoku = new Sudoku(4, 2);
    }

    @Test
    public void printsEmptyGrid() {
        String result = sudoku.showPuzzle();
        Assertions.assertThat(result).contains("____\n____\n____\n____");
        Assertions.assertThat(result.equals("____\n____\n____\n____")).isTrue();
    }

    @Test
    public void checksAgainstInvalidCell() {
        Cell cellToCheck = new Cell(4);
        cellToCheck.getCellRow(2).add(9);
        boolean isValid = sudoku.checkCell(cellToCheck, 9);
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    public void checksAgainstValidCell() {
        Cell cellToCheck = new Cell(4);
        boolean isValid = sudoku.checkCell(cellToCheck, 8);
        Assertions.assertThat(isValid).isTrue();
    }

    @Test
    public void createsAGridOfAppropriateSize() {
        Sudoku sudoku2 = new Sudoku(13, 2);
        Assertions.assertThat(sudoku2.getGrid()).hasSize(13);
    }

    @Test
    public void addsANumberToCorrectCell() {
        sudoku.addNumberToCell(4, 1, 1, 2);
        //Assertions.assertThat(sudoku.getGrid().get(1).cellRowTwo.get(1)).isEqualTo(4);
        Assertions.assertThat(sudoku.getGrid().get(0).getCellRow(1).get(1)).isEqualTo(4);
        sudoku.addNumberToCell(6, 2, 2, 2);
//        System.out.println(sudoku.getGrid().get(1).getCellRow(2));
        Assertions.assertThat(sudoku.getGrid().get(1).getCellRow(2).get(1)).isEqualTo(6);

    }
}
