package sudoku;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SudokuTest {

    private Sudoku sudoku;

    @Before
    public void setUp() {
        sudoku = new Sudoku(4, 2);
    }

    @Test
    @Ignore
    public void printsEmptyGrid() {
        String result = sudoku.showPuzzle();
        Assertions.assertThat(result).contains("____\n____\n____\n____");
        Assertions.assertThat(result.equals("____\n____\n____\n____")).isTrue();
    }

    @Test
    public void checksAgainstInvalidCell() {
        Cell cellToCheck = new Cell(4,1, 1);
        cellToCheck.getCellRow(2).add(9);
        boolean isValid = sudoku.checkCell(cellToCheck, 9);
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    public void checksAgainstValidCell() {
        Cell cellToCheck = new Cell(4, 1, 1);
        boolean isValid = sudoku.checkCell(cellToCheck, 8);
        Assertions.assertThat(isValid).isTrue();
    }

    @Test
    public void createsAGridOfAppropriateSize() {
        Sudoku sudoku2 = new Sudoku(13, 2);
        System.out.println((sudoku2.getGrid().get(0).getCellRow(1)));
        Assertions.assertThat(sudoku2.getGrid()).hasSize(13);
        Assertions.assertThat(sudoku2.getGrid().get(0).getCellRow(1)).hasSize(2);

    }

    @Test
    public void addsANumberToCorrectCell() {

        sudoku.addNumberToCell(4, 1,1,1, 2);
        Assertions.assertThat(sudoku.getGrid().get(0).getCellRow(1).get(1)).isEqualTo(4);
        sudoku.addNumberToCell(6, 1,2, 2, 2);

        Assertions.assertThat(sudoku.getGrid().get(1).getCellRow(2).get(1)).isEqualTo(6);
sudoku.showPuzzle();

    }

    @Test
    public void checksAgainstValidRow(){
        sudoku.addNumberToCell(4, 1,1, 1, 2);
        Assertions.assertThat(sudoku.checkRow(2, 4,1)).isTrue();
        Assertions.assertThat(sudoku.checkRow(1, 9,1)).isTrue();


    }

    @Test
    public void checksAgainstInvalidRow(){
        sudoku.addNumberToCell(4, 1,1, 1, 2);
        sudoku.showPuzzle();
        Assertions.assertThat(sudoku.checkRow(1, 1,4)).isFalse();

    }

    @Test
    public void checksAgainstValidColumn(){
        sudoku.addNumberToCell(4, 1, 1,1, 2);
        sudoku.showPuzzle();
        Assertions.assertThat(sudoku.checkColumn(1, 1,4)).isTrue();

    }

    @Test
    public void checksAgainstInvalidColumn(){
        sudoku.addNumberToCell(4, 1,1, 1, 2);
        sudoku.addNumberToCell(3, 1,1, 1, 1);
        sudoku.showPuzzle();
        Assertions.assertThat(sudoku.checkColumn(1, 2,4)).isFalse();
        Assertions.assertThat(sudoku.checkColumn(1, 2,4)).isFalse();
    }
    @Test
    public void validatesNumberAndAdds(){
        sudoku.addNumberToCell(4, 1,1, 1, 2);
        sudoku.addNumberToCell(3, 1,1, 1, 1);
        sudoku.showPuzzle();
        sudoku.validateMyNumber(4,4, 2);
    }
    @Test
    public void validatesNumberAndRejects(){

    }
}
