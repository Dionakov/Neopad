package org.neotouch.neopad.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import org.neotouch.neopad.mvc.View;

public final class LaunchpadPanel extends JPanel implements View
{
	private static final long serialVersionUID = 1L;

	LaunchpadControlBar controlBar = new LaunchpadControlBar();

	public LaunchpadPanel()
	{
		super();

		controlBar.setLayout(new FlowLayout());

		setLayout(new BorderLayout());
		add(controlBar, BorderLayout.NORTH);
		setBackground(Color.WHITE);
		setMinimumSize(new Dimension(300, 300));

		/*
		 * addMouseMotionListener(new MouseMotionAdapter() {
		 * 
		 * @Override public void mouseDragged(MouseEvent e) {
		 * onMousePressedOrDragged(e); }
		 * 
		 * });
		 * 
		 * addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mousePressed(MouseEvent e) {
		 * onMousePressedOrDragged(e); } });
		 */
	}

	/*
	 * private void onMousePressedOrDragged(MouseEvent e) { Point2D buttonPos =
	 * buttonGrid .coordsToButtonPos(new Point2D(e.getX(), e.getY()));
	 * 
	 * if (buttonPos != null) { int row = (int) buttonPos.getX(); int col =
	 * (int) buttonPos.getY();
	 * 
	 * buttonGrid.setButtonColor(row, col, controlBar.getCurrentColor()); }
	 * 
	 * buttonGrid.setSelectedButton(buttonPos); }
	 */

	/*
	 * @Override public void paintComponent(Graphics g) {
	 * super.paintComponent(g); Graphics2D g2 = (Graphics2D) g;
	 * g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	 * RenderingHints.VALUE_ANTIALIAS_ON);
	 * 
	 * buttonGrid.rebuild(new Dimension2D(getWidth(), getHeight()), new
	 * Point2D(0, controlBar.getHeight())); buttonGrid.draw(g2); }
	 */
}
