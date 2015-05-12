package sudoku;

public class XY {
	public final int x;
	public final int y;

	public XY(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object object) {
		XY xy = (XY) object;
		return xy.x == x && xy.y == y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
