package org.neotouch.neopad.view;

import java.util.EventObject;

import javax.sound.midi.MidiMessage;

public class MidiMessageEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	private final MidiMessage msg;
	private final long timeStamp;

	public MidiMessageEvent(Object source, MidiMessage msg, long timeStamp)
	{
		super(source);
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	public MidiMessage getMessage()
	{
		return this.msg;
	}

	public long getTimeStamp()
	{
		return this.timeStamp;
	}
}
