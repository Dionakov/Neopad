package org.neotouch.neopad;

import java.io.IOException;

import javax.sound.midi.MidiUnavailableException;

import org.neotouch.neopad.controller.LaunchpadDeviceController;
import org.neotouch.neopad.controller.ResourcePanelController;
import org.neotouch.neopad.model.GuiLaunchpadModel;
import org.neotouch.neopad.model.LaunchpadDeviceModel;
import org.neotouch.neopad.model.SequenceModel;
import org.neotouch.neopad.view.LaunchpadDevice;
import org.neotouch.neopad.view.NeopadGui;

public class Neopad
{

	public static void main(String[] args) throws IOException
	{
		// models
		LaunchpadDeviceModel deviceModel = new LaunchpadDeviceModel();
		GuiLaunchpadModel guiModel = new GuiLaunchpadModel();
		SequenceModel seqModel = new SequenceModel();

		// views
		NeopadGui guiView = new NeopadGui();
		LaunchpadDevice deviceView = new LaunchpadDevice();

		try {
			deviceView.makeUserChooseDevices();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}

		// controllers
		ResourcePanelController resourcePanelController = new ResourcePanelController(
				guiView.getResourcePanel(), guiModel);
		LaunchpadDeviceController deviceController = new LaunchpadDeviceController(
				deviceView, deviceModel);

		deviceView.close(); // probably useless, but you never know.
	}

}
