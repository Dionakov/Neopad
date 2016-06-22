package org.neotouch.neopad.controller;

import org.neotouch.neopad.model.LaunchpadDeviceModel;
import org.neotouch.neopad.mvc.Controller;
import org.neotouch.neopad.mvc.Model;
import org.neotouch.neopad.mvc.View;
import org.neotouch.neopad.view.LaunchpadDevice;
import org.neotouch.neopad.view.MidiMessageEvent;
import org.neotouch.neopad.view.MidiMessageListener;

public class TestController extends Controller
{
	private LaunchpadDeviceModel deviceModel;
	private LaunchpadDevice deviceView;

	private MidiMessageListener midiMessageListener = new MidiMessageListener()
	{
		@Override
		public void midiMessageReceived(MidiMessageEvent event)
		{
			deviceView.sendMessage(event.getMessage(), event.getTimeStamp());
		}
	};

	public TestController(View view, Model model)
	{
		super(view, model);

		if (!(view instanceof LaunchpadDevice)
				|| !(model instanceof LaunchpadDeviceModel)) {
			throw new IllegalArgumentException(
					"view and model are not of correct class.");
		}

		this.deviceView = (LaunchpadDevice) view;
		this.deviceModel = (LaunchpadDeviceModel) model;

		this.deviceView.addMidiMessageListener(midiMessageListener);
	}
}
