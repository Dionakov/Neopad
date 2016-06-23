package org.neotouch.neopad.model;

import java.awt.Color;

import javax.swing.event.EventListenerList;

import org.neotouch.neopad.mvc.Model;
import org.neotouch.neopad.view.ButtonEvent;
import org.neotouch.neopad.view.ButtonListener;
import org.neotouch.neopad.view.ButtonPosition;

public class LaunchpadDeviceModel implements Model
{
	private EventListenerList listeners = new EventListenerList();

	public DeviceButton[][] buttons = new DeviceButton[ButtonPosition.LAST_ROW][ButtonPosition.LAST_COL];

	public LaunchpadDeviceModel()
	{
		for (int row = ButtonPosition.FIRST_ROW; row < ButtonPosition.LAST_ROW; row++) {
			for (int col = ButtonPosition.FIRST_COL; col < ButtonPosition.LAST_COL; col++) {
				if (row == 0 && col == 8) {
					continue;
				}

				buttons[row][col] = new DeviceButton();
			}
		}
	}

	public void setButtonPressed(ButtonPosition position, boolean isPressed)
	{
		buttons[position.row][position.col].isPressed = isPressed;
	}

	public void setButtonLedOn(ButtonPosition position, boolean isLedOn)
	{
		buttons[position.row][position.col].isLedOn = isLedOn;
	}

	public void setButtonColor(ButtonPosition position, Color color)
	{
		buttons[position.row][position.col].color = color;
		fireButtonColorChanged(position, color);
	}

	public boolean isButtonPressed(ButtonPosition position)
	{
		return buttons[position.row][position.col].isPressed;
	}

	public boolean isButtonLedOn(ButtonPosition position)
	{
		return buttons[position.row][position.col].isLedOn;
	}

	public Color getButtonColor(ButtonPosition position)
	{
		return buttons[position.row][position.col].color;
	}

	public void addButtonListener(ButtonListener l)
	{
		listeners.add(ButtonListener.class, l);
	}

	public void removeButtonListener(ButtonListener l)
	{
		listeners.remove(ButtonListener.class, l);
	}

	public ButtonListener[] getButtonListeners()
	{
		return listeners.getListeners(ButtonListener.class);
	}

	private void fireButtonColorChanged(ButtonPosition position, Color color)
	{
		ButtonEvent event = new ButtonEvent(this, position,
				ButtonEvent.COLOR_CHANGED, color);

		for (ButtonListener l : getButtonListeners()) {
			l.colorChanged(event);
		}
	}
}
