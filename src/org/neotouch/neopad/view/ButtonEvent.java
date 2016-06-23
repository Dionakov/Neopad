package org.neotouch.neopad.view;

import java.awt.Color;
import java.util.EventObject;

public class ButtonEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public static final String COLOR_CHANGED = "Color Changed";

	protected final ButtonPosition position;
	protected final String type;
	protected final Color color;

	public ButtonEvent(Object source, ButtonPosition position, String type,
			Color color)
	{
		super(source);
		this.position = position;
		this.type = type;
		this.color = color;
	}

	public ButtonPosition getPosition()
	{
		return this.position;
	}

	public String getType()
	{
		return this.type;
	}

	public Color getColor()
	{
		return this.color;
	}
}
