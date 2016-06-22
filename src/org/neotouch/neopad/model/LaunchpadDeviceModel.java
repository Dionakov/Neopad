package org.neotouch.neopad.model;

import java.awt.Color;

import org.neotouch.neopad.mvc.Model;

public class LaunchpadDeviceModel implements Model
{
	private static int SQUARE_SIDE = 9;
	public DeviceButton[][] buttons = new DeviceButton[SQUARE_SIDE][SQUARE_SIDE];

	public LaunchpadDeviceModel()
	{
		for (int row = 0; row < SQUARE_SIDE; row++) {
			for (int col = 0; col < SQUARE_SIDE; col++) {
				if (row == 0 && col == 8) {
					continue;
				}
				buttons[row][col] = new DeviceButton();
			}
		}
	}

	public void setButtonPressed(int row, int col, boolean isPressed)
	{
		buttons[row][col].isPressed = isPressed;
	}

	public void setButtonLedOn(int row, int col, boolean isLedOn)
	{
		buttons[row][col].isLedOn = isLedOn;
	}

	public void setButtonColor(int row, int col, Color color)
	{
		buttons[row][col].color = color;
	}

	public boolean isButtonPressed(int row, int col)
	{
		return buttons[row][col].isPressed;
	}

	public boolean isButtonLedOn(int row, int col)
	{
		return buttons[row][col].isLedOn;
	}

	public Color getButtonColor(int row, int col)
	{
		return buttons[row][col].color;
	}
}
