package sudoku;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SudokuTest {

	private Sudoku sudoku;

	@Before
	public void setUp() {
		sudoku = new Sudoku(4);
	}

@Test
	public void printsEmptyGrid(){
		String result = sudoku.showPuzzle();
		Assertions.assertThat(result).contains("____\n____\n____\n____");
	Assertions.assertThat(result.equals("____\n____\n____\n____")).isTrue();
	}
	@Test
	public void checksAgainstInvalidCell() {
		Cell cellToCheck = new Cell();
		cellToCheck.getCellRowTwo().add(9);
		boolean isValid = sudoku.checkCell(cellToCheck, 9);
		Assertions.assertThat(isValid).isFalse();
	}
		@Test
		public void checksAgainstValidCell(){
			Cell cellToCheck = new Cell();
			boolean isValid = sudoku.checkCell(cellToCheck, 8);
			Assertions.assertThat(isValid).isTrue();
		}
}
