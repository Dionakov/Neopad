package org.neotouch.neopad.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.neotouch.neopad.model.GuiLaunchpadModel;
import org.neotouch.neopad.model.SequenceModel;
import org.neotouch.neopad.mvc.View;

import javafx.geometry.Point2D;

// TODO
public final class SequencePanel extends JPanel implements View
{
	private static final long serialVersionUID = 1L;

	JScrollPane pane = new JScrollPane();
	JPanel innerPane = new JPanel();
	JPanel controlBar = new JPanel();
	SequenceModel sequenceModel = null;
	GuiLaunchpadModel launchpadModel = null;

	public SequencePanel()
	{
		pane.setViewportView(innerPane);
		innerPane.setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		add(pane, BorderLayout.CENTER);
		add(controlBar, BorderLayout.NORTH);

		controlBar.setLayout(new FlowLayout());
	}

	private void refresh()
	{
		Point2D selected = launchpadModel.getSelectedButton();
		if (selected == null) {
			return;
		}

		innerPane.removeAll();

		for (int i = 0; i < sequenceModel.getSequenceLength(
				(int) selected.getX(), (int) selected.getY(), 0); i++) {
			innerPane.add(new JButton("" + i));
		}

		repaint();
		revalidate();
	}
}
