package sudoku;

public class Sudoku {
	private int baseSize = 2;
	private int[][] grid;

	public Sudoku(int baseSize) {
		this.baseSize = baseSize;
		grid = new int[baseSize * baseSize][baseSize * baseSize];
	}

	public String toString() {
		String s = "";
		for (int[] row : grid) {
			for (int cell : row) {
				if (cell == 0) {
					s += "_ ";
				} else {
					s += cell + " ";
				}
			}
			s += "\n";
		}
		return s;
	}


	public boolean setValue(int x, int y, int value) {
		for (int cell : grid[y]) {
				if (cell == value) {
					return false;
				}
		}

		for (int[] row : grid) {
			if (row[x] == value) {
				return false;
			}
		}

		int xQuadrantIndex = x / baseSize;
		int yQuadrantIndex = y / baseSize;
		for (int checkY = yQuadrantIndex * baseSize; checkY < (yQuadrantIndex + 1) * baseSize; checkY++) {
			for (int checkX = xQuadrantIndex * baseSize; checkX < (xQuadrantIndex + 1) * baseSize; checkX++) {
				if (grid[checkY][checkX] == value) {
					return false;
				}
			}
		}

		grid[y][x] = value;
		return true;
	}

}
