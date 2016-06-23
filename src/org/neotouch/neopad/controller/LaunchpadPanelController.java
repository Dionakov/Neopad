package org.neotouch.neopad.controller;

import org.neotouch.neopad.model.GuiLaunchpadModel;
import org.neotouch.neopad.mvc.Controller;
import org.neotouch.neopad.mvc.Model;
import org.neotouch.neopad.mvc.View;
import org.neotouch.neopad.view.LaunchpadPanel;

public class LaunchpadPanelController extends Controller
{
	LaunchpadPanel panel;
	GuiLaunchpadModel guiModel;

	public LaunchpadPanelController(View view, Model model)
	{
		super(view, model);

		if (!(view instanceof LaunchpadPanel)
				|| !(model instanceof GuiLaunchpadModel)) {
			throw new IllegalArgumentException(
					"invalid class for view or model");
		}

		panel = (LaunchpadPanel) view;
		guiModel = (GuiLaunchpadModel) model;
	}
}
