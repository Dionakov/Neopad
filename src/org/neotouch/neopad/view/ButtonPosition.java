package org.neotouch.neopad.view;

public final class ButtonPosition
{
	public static final int FIRST_ROW = 0;
	public static final int LAST_ROW = 9;
	public static final int FIRST_COL = 0;
	public static final int LAST_COL = 0;

	public final int row;
	public final int col;

	public ButtonPosition(int row, int col)
	{
		if (row < FIRST_ROW || row > LAST_ROW || col < FIRST_COL
				|| col > LAST_COL) {
			throw new IllegalArgumentException(
					"Button position outside of bounds");
		}

		this.row = row;
		this.col = col;
	}
}
