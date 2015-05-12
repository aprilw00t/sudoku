package sudoku;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SudokuTest {

	private Sudoku sudoku;

	@Before
	public void setUp() {
		sudoku = new Sudoku(3);
	}

	@After
	public void after() {
		System.out.println(sudoku.toString());
	}

	@Test
	public void printEmptySudokuGrid() {
		sudoku = new Sudoku(2);
		assertThat(sudoku.toString(), equalTo("_ _ _ _ \n_ _ _ _ \n_ _ _ _ \n_ _ _ _ \n"));
	}

	@Test
	public void printValueOnFirstCell() {
		sudoku = new Sudoku(2);
		sudoku.setValue(0, 1, 1);
		assertThat(sudoku.toString(), equalTo("_ _ _ _ \n1 _ _ _ \n_ _ _ _ \n_ _ _ _ \n"));
	}

	@Test
	public void rowsShouldDisallowDuplicatesOnSameRow() {
		assertTrue(sudoku.setValue(0, 0, 1));
		assertFalse(sudoku.setValue(1, 0, 1));
	}

	@Test
	public void rowsShouldDisallowDuplicatesOnSameColumn() {
		assertTrue(sudoku.setValue(0, 0, 1));
		assertFalse(sudoku.setValue(0, 1, 1));
	}

	@Test
	public void rowsShouldDisallowDuplicatesInSameQuadrant() {
		assertTrue(sudoku.setValue(1, 0, 1));
		assertFalse(sudoku.setValue(0, 1, 1));

		assertTrue(sudoku.setValue(6, 6, 2));
		assertFalse(sudoku.setValue(8, 8, 2));

	}

}
