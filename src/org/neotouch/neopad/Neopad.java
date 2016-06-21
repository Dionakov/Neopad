package org.neotouch.neopad;

import java.io.IOException;

import javax.sound.midi.MidiUnavailableException;

import org.neotouch.neopad.model.GuiLaunchpadModel;
import org.neotouch.neopad.model.LaunchpadDeviceModel;
import org.neotouch.neopad.model.SequenceModel;
import org.neotouch.neopad.view.LaunchpadDevice;
import org.neotouch.neopad.view.NeopadGui;

public class Neopad
{

	public static void main(String[] args) throws IOException
	{
		// test
		LaunchpadDeviceModel deviceModel = new LaunchpadDeviceModel();
		@SuppressWarnings("resource")
		LaunchpadDevice deviceView = new LaunchpadDevice();
		deviceView.addModel(deviceModel);
		try {
			deviceView.makeUserChooseDevices();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}

		GuiLaunchpadModel guiModel = new GuiLaunchpadModel();
		SequenceModel seqModel = new SequenceModel();
		seqModel.addFrame(0, 0, 0);
		seqModel.addFrame(0, 0, 0);
		NeopadGui guiView = new NeopadGui();
		guiView.addModel(guiModel);
		guiView.addModel(deviceModel);
		guiView.addModel(seqModel);
	}

}
