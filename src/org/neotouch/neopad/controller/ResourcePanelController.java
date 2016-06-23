package org.neotouch.neopad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.neotouch.neopad.model.GuiLaunchpadModel;
import org.neotouch.neopad.mvc.Controller;
import org.neotouch.neopad.mvc.Model;
import org.neotouch.neopad.mvc.View;
import org.neotouch.neopad.resource.PatternFile;
import org.neotouch.neopad.view.ResourcePanel;

public class ResourcePanelController extends Controller
{
	private ResourcePanel resourcePanel;
	private GuiLaunchpadModel guiLaunchpadModel;

	public ResourcePanelController(View view, Model model)
	{
		super(view, model);

		if (!(view instanceof ResourcePanel)
				|| !(model instanceof GuiLaunchpadModel)) {
			throw new IllegalArgumentException(
					"Incorrect class for view or model");
		}

		this.resourcePanel = (ResourcePanel) view;
		this.guiLaunchpadModel = (GuiLaunchpadModel) model;

		resourcePanel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (e.getActionCommand() == "ApproveSelection") {
					try {
						guiLaunchpadModel.importPattern(
								new PatternFile(resourcePanel.getSelectedFile())
										.loadPattern());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

}
