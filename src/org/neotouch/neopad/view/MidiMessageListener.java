package org.neotouch.neopad.view;

import java.util.EventListener;

public interface MidiMessageListener extends EventListener
{
	void midiMessageReceived(MidiMessageEvent event);
}
