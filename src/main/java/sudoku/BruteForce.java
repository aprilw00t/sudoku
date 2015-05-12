package sudoku;

public class BruteForce {

	private final Sudoku sudoku;
	private XY currentPosition;
	private final int max;

	public BruteForce(final Sudoku sudoku) {
		this.sudoku = sudoku;
		this.currentPosition = new XY(0, 0);
		this.max = sudoku.size();
	}

	public XY nextCoordinate(XY currentCoordinate) {
		if (currentCoordinate.x + 1 == sudoku.size()) {
			if (currentCoordinate.y + 1 == sudoku.size()) {
				return null;
			}
			return new XY(0, currentCoordinate.y + 1);
		} else {
			return new XY(currentCoordinate.x + 1, currentCoordinate.y);
		}
	}

	public XY lastCoordinate(XY currentCoordinate) {
		if (currentCoordinate.x == 0) {
			if (currentCoordinate.y == 0) {
				return null;
			}
			return new XY(sudoku.size() - 1, currentCoordinate.y - 1);
		} else {
			return new XY(currentCoordinate.x - 1, currentCoordinate.y);
		}
	}

	private boolean isValidXY(XY currentCoordinate) {
		if (currentCoordinate != null &&
				(!(currentCoordinate.x < 0) && (currentCoordinate.x < max))
				&&
				(!(currentCoordinate.y < 0) && (currentCoordinate.y < max))) {
			return true;
		}
		return false;
	}

	public void bruteForce() {
		while (isValidXY(currentPosition)) {
			if (sudoku.isEmpty(currentPosition.x, currentPosition.y)) {
				while (!bruteForceElement()) {
					sudoku.setValue(currentPosition.x, currentPosition.y, 0);
					currentPosition = lastCoordinate(currentPosition);
				}
			}
			currentPosition = nextCoordinate(currentPosition);
		}

	}

	public boolean bruteForceElement() {
		int value = sudoku.getValue(currentPosition.x, currentPosition.y) + 1;
		if (value > max) {
			return false;
		}

		while (!sudoku.setValue(currentPosition.x, currentPosition.y, value)) {
			if (value == max) {
				return false;
			}
			value++;
		}
		return true;
	}
}
