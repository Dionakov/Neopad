package org.neotouch.neopad.controller;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;

import org.neotouch.neopad.model.LaunchpadDeviceModel;
import org.neotouch.neopad.mvc.Controller;
import org.neotouch.neopad.mvc.Model;
import org.neotouch.neopad.mvc.View;
import org.neotouch.neopad.view.ButtonEvent;
import org.neotouch.neopad.view.ButtonListener;
import org.neotouch.neopad.view.ButtonPosition;
import org.neotouch.neopad.view.LaunchpadDevice;
import org.neotouch.neopad.view.MidiMessageEvent;
import org.neotouch.neopad.view.MidiMessageListener;

public class LaunchpadDeviceController extends Controller
{
	private LaunchpadDevice deviceView;
	private LaunchpadDeviceModel deviceModel;

	private MidiMessageListener onMidiMessageReceived = new MidiMessageListener()
	{

		@Override
		public void midiMessageReceived(MidiMessageEvent event)
		{
			MidiMessage msg = event.getMessage();

			if (!(msg instanceof ShortMessage)) {
				return;
			}

			int nativeButtonPos = ((ShortMessage) msg).getData1();
			int row = 9 - (nativeButtonPos / 10);
			int col = (nativeButtonPos % 10) - 1;
			int velocity = ((ShortMessage) msg).getData2();
			boolean isNoteOn = msg.getStatus() == ShortMessage.NOTE_ON;
			boolean isNoteOff = msg.getStatus() == ShortMessage.NOTE_OFF;

			if (isNoteOn || isNoteOff) {

				boolean isPressed = (isNoteOn && velocity != 0);
				deviceModel.setButtonPressed(new ButtonPosition(row, col),
						isPressed);
			}
		}
	};

	private ButtonListener buttonListener = new ButtonListener()
	{
		@Override
		public void colorChanged(ButtonEvent event)
		{
			ButtonPosition p = event.getPosition();
			try {
				deviceView.updateButton(p.row, p.col, event.getColor());
			} catch (InvalidMidiDataException e) {
				e.printStackTrace();
			}
		}
	};

	public LaunchpadDeviceController(View view, Model model)
	{
		super(view, model);

		if (!(view instanceof LaunchpadDevice)
				|| !(model instanceof LaunchpadDeviceModel)) {
			throw new IllegalArgumentException(
					"Invalid class for view or model");
		}

		this.deviceView = (LaunchpadDevice) view;
		this.deviceModel = (LaunchpadDeviceModel) model;

		this.deviceView.addMidiMessageListener(onMidiMessageReceived);
		this.deviceModel.addButtonListener(buttonListener);
	}
}
