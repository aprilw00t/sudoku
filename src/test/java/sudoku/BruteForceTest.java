package sudoku;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class BruteForceTest {

	private Sudoku sudoku;
	private BruteForce bruteForce;

	@Before
	public void setUp() {
		sudoku = new Sudoku(5);
		bruteForce = new BruteForce(sudoku);
	}

	@Test
	public void shouldGetNextCoordinate() {
		XY coordinate = new XY(3, 0);
		XY expectedNextCoordinate = new XY(0, 1);

		assertThat(bruteForce.nextCoordinate(coordinate), equalTo(expectedNextCoordinate));
	}

	@Test
	public void shouldGetLastCoordinate() {
		XY coordinate = new XY(0, 1);
		XY expectedLastCoordinate = new XY(3, 0);

		assertThat(bruteForce.lastCoordinate(coordinate), equalTo(expectedLastCoordinate));
	}

	@Test
	public void testBruteForce() {
		bruteForce.bruteForce();

		System.out.println(sudoku.toString());
	}
}
