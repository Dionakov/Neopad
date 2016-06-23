package org.neotouch.neopad.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import org.neotouch.neopad.mvc.View;

public final class NeopadGui implements View
{
	private JFrame frame = new JFrame("Neopad");
	private LaunchpadPanel launchpadPanel = new LaunchpadPanel();
	private ResourcePanel resourcePanel = new ResourcePanel();
	private SequencePanel sequencePanel = new SequencePanel();

	public NeopadGui()
	{
		JSplitPane mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		JSplitPane secondarySplitPane = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT);

		secondarySplitPane.setLeftComponent(resourcePanel);
		secondarySplitPane.setRightComponent(launchpadPanel);
		secondarySplitPane.setOneTouchExpandable(true);
		secondarySplitPane.setDividerLocation(0.2d);
		secondarySplitPane.setResizeWeight(0.15d);

		mainSplitPane.setTopComponent(secondarySplitPane);
		mainSplitPane.setBottomComponent(sequencePanel);
		mainSplitPane.setOneTouchExpandable(true);
		mainSplitPane.setDividerLocation(0.75d);
		mainSplitPane.setResizeWeight(0.75d);

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(mainSplitPane, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(new Dimension(600, 450));
		frame.setVisible(true);
	}

	public ResourcePanel getResourcePanel()
	{
		return this.resourcePanel;
	}
}
