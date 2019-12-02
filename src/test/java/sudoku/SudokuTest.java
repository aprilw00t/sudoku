package sudoku;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SudokuTest {
//
    private Sudoku sudoku;

    @Before
    public void setUp() {
        sudoku = new Sudoku(4, 2);
    }

    @Test
    @Ignore
    public void printsEmptyGrid() {
        sudoku.addNumberToCell(4, 1, 1, 1, 1);
        sudoku.addNumberToCell(2, 1, 1, 2, 1);
        sudoku.addNumberToCell(3, 2, 1, 1, 1);
        sudoku.addNumberToCell(1, 2, 1, 2, 1);
        String result = sudoku.showPuzzle();


    }

    @Test
    public void checksAgainstInvalidCell() {

        sudoku.addNumberToCell(2, 1, 1, 1, 1);
        boolean isValid = sudoku.checkCellAndNumber(1, 1, 2);
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    public void checksAgainstValidCell() {

        boolean isValid = sudoku.checkCellAndNumber(1, 1, 3);
        Assertions.assertThat(isValid).isTrue();
    }

    @Test
    public void createsAGridOfAppropriateSize() {
        Sudoku sudoku2 = new Sudoku(13, 2);
        //System.out.println((sudoku2.getGrid().get(0).getCellRow(1)));
        Assertions.assertThat(sudoku2.getGrid()).hasSize(13);
        Assertions.assertThat(sudoku2.getGrid().get(0).getCellRowFromMap(1)).hasSize(2);

    }

    @Test
    public void addsANumberToCorrectCell() {

        sudoku.addNumberToCell(4, 1, 1, 1, 2);
        Assertions.assertThat(sudoku.getGrid().get(0).getCellRowFromMap(1).get(1)).isEqualTo(4);
        sudoku.addNumberToCell(6, 1, 2, 2, 2);

        Assertions.assertThat(sudoku.getGrid().get(1).getCellRowFromMap(2).get(1)).isEqualTo(6);
//sudoku.showPuzzle();

    }

    @Test
    public void checksAgainstValidRow() {
        sudoku.addNumberToCell(4, 1, 1, 1, 2);
        //Assertions.assertThat(sudoku.checkRow(2, 4,1)).isTrue();
        Assertions.assertThat(sudoku.checkRow(1, 2, 1)).isTrue();

    }

    @Test
    public void checksAgainstInvalidRow() {
        sudoku.addNumberToCell(4, 1, 1, 1, 2);
        //sudoku.showPuzzle();
        Assertions.assertThat(sudoku.checkRow(1, 1, 4)).isFalse();

    }

    @Test
    public void checksAgainstValidColumn() {
        sudoku.addNumberToCell(4, 1, 1, 1, 2);
        //sudoku.showPuzzle();
        Assertions.assertThat(sudoku.checkColumn(1, 1, 4)).isTrue();

    }

    @Test
    public void checksAgainstInvalidColumn() {
        sudoku.addNumberToCell(4, 1, 1, 1, 2);
        sudoku.addNumberToCell(3, 1, 1, 1, 1);
        //sudoku.showPuzzle();
        Assertions.assertThat(sudoku.checkColumn(1, 2, 4)).isFalse();
        Assertions.assertThat(sudoku.checkColumn(1, 2, 4)).isFalse();
    }

    @Test
    public void validatesNumberAndAdds() {
        sudoku.addNumberToCell(4, 1, 1, 1, 2);
        sudoku.addNumberToCell(3, 1, 1, 1, 1);
        //sudoku.showPuzzle();
        sudoku.validateMyNumber(4, 4, 2);
    }

    @Test
    public void validatesNumberAndRejects() {
        sudoku.addNumberToCell(2, 2, 2, 1, 1);

        Assertions.assertThat(sudoku.validateMyNumber(2, 3, 3)).isFalse();
    }

    @Test
    public void validatesNumberAndPlacesNumber() {
        sudoku.addNumberToCell(2, 2, 2, 1, 1);
        Assertions.assertThat(sudoku.validateMyNumber(4, 4, 3)).isTrue();
        Assertions.assertThat(sudoku.getGrid().get(3).getCellRowFromMap(1).get(1)).isEqualTo(4);
    }

    @Test
    public void checkForNumbersWhenOneIsAlreadyThere() {
        sudoku.addNumberToCell(2, 1, 1, 2, 1);
        Assertions.assertThat(sudoku.checkForEmptyCell(1, 1, 2, 1)).isFalse();
    }

    @Test
    public void checkForNumbersWhenCellIsEmpty() {
        sudoku.addNumberToCell(2, 2, 2, 1, 1);

        Assertions.assertThat(sudoku.checkForEmptyCell(1, 2, 1, 1)).isTrue();
    }


    @Test
    public void validatesNumberAndRejectsWhenCellIsAlreadyFull() {
        sudoku.addNumberToCell(2, 2, 2, 1, 1);

        Assertions.assertThat(sudoku.validateMyNumber(4, 3, 3)).isFalse();
    }

    @Test
    public void rejectsNumbersOverGridSize() {

        Assertions.assertThat(sudoku.validateMyNumber(5, 3, 3)).isFalse();
        Assertions.assertThat(sudoku.validateMyNumber(0, 3, 3)).isFalse();
        Assertions.assertThat(sudoku.validateMyNumber(4, 3, 3)).isTrue();

    }

    @Test
    public void canMakeGridsOfDifferentSizes() {
        Sudoku differentSizedSudoku = new Sudoku(9, 3);
        Assertions.assertThat(differentSizedSudoku.getGrid().size()).isEqualTo(9);


    }

    @Test
    public void checksInvalidAndValidCellsWithLargerSizedGrid() {
        Sudoku differentSizedSudoku = new Sudoku(9, 3);

        differentSizedSudoku.addNumberToCell(2, 1, 3, 1, 1);
        boolean isValid1 = differentSizedSudoku.checkCellAndNumber(1, 3, 2);
        Assertions.assertThat(isValid1).isFalse();
       // differentSizedSudoku.showPuzzle();
        boolean isValid = differentSizedSudoku.checkCellAndNumber(2, 3, 2);
        Assertions.assertThat(isValid).isTrue();

    }

    @Test
    public void checksInvalidAndValidRowsWithLargerSizedGrid() {
        Sudoku differentSizedSudoku = new Sudoku(9, 3);

        differentSizedSudoku.addNumberToCell(4, 3, 3, 2, 2);
        //Assertions.assertThat(sudoku.checkRow(2, 4,1)).isTrue();
        Assertions.assertThat(differentSizedSudoku.checkRow(3, 2, 5)).isTrue();
        differentSizedSudoku.addNumberToCell(4, 3, 3, 1, 2);
        //sudoku.showPuzzle();
        Assertions.assertThat(differentSizedSudoku.checkRow(3, 1, 4)).isFalse();

    }

    @Test
    public void checksInvalidAndValidColumnsWIthLargerSizedGrid() {
        Sudoku differentSizedSudoku = new Sudoku(9, 3);
        differentSizedSudoku.addNumberToCell(4, 1, 3, 1, 2);
        //sudoku.showPuzzle();
        Assertions.assertThat(differentSizedSudoku.checkColumn(3, 1, 4)).isTrue();


        differentSizedSudoku.addNumberToCell(4, 1, 1, 1, 2);
        differentSizedSudoku.addNumberToCell(3, 1, 1, 1, 1);
        //sudoku.showPuzzle();
        Assertions.assertThat(differentSizedSudoku.checkColumn(3, 2, 4)).isFalse();
        Assertions.assertThat(differentSizedSudoku.checkColumn(3, 2, 5)).isTrue();


    }
    @Test
    public void validatesNumberAndPlacesNumberInBiggerGrid() {
        Sudoku differentSizedSudoku = new Sudoku(9, 3);

        differentSizedSudoku.addNumberToCell(2, 2, 2, 1, 1);

      Assertions.assertThat(differentSizedSudoku.validateMyNumber(4, 9, 9)).isTrue();
      Assertions.assertThat(differentSizedSudoku.validateMyNumber(8,9,4)).isTrue();
       differentSizedSudoku.showPuzzle();
        Assertions.assertThat(differentSizedSudoku.getGrid().get(8).getCellRowFromMap(3).get(2)).isEqualTo(4);
    }

    //need to sout the puzzle properly


}
