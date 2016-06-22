package org.neotouch.neopad;

import java.io.IOException;

import javax.sound.midi.MidiUnavailableException;

import org.neotouch.neopad.controller.TestController;
import org.neotouch.neopad.model.GuiLaunchpadModel;
import org.neotouch.neopad.model.LaunchpadDeviceModel;
import org.neotouch.neopad.model.SequenceModel;
import org.neotouch.neopad.view.LaunchpadDevice;
import org.neotouch.neopad.view.NeopadGui;

public class Neopad
{

	public static void main(String[] args) throws IOException
	{
		LaunchpadDeviceModel deviceModel = new LaunchpadDeviceModel();
		LaunchpadDevice deviceView = new LaunchpadDevice();

		TestController testController = new TestController(deviceView,
				deviceModel);

		try {
			deviceView.makeUserChooseDevices();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}

		GuiLaunchpadModel guiModel = new GuiLaunchpadModel();
		SequenceModel seqModel = new SequenceModel();
		NeopadGui guiView = new NeopadGui();

		deviceView.close(); // probably useless, but you never know.
	}

}
