package org.neotouch.neopad.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import org.neotouch.neopad.mvc.View;

public final class ResourcePanel extends JPanel implements View
{
	private static final long serialVersionUID = 1L;

	private JFileChooser fileChooser = new JFileChooser(
			new File("resources/patterns"));

	public ResourcePanel()
	{
		setLayout(new BorderLayout());

		fileChooser.setMinimumSize(new Dimension(100, 300));
		fileChooser.setPreferredSize(new Dimension(100, 300));
		fileChooser.addChoosableFileFilter(new FileFilter()
		{

			@Override
			public boolean accept(File f)
			{
				String ext = "";
				int lastDotPos = f.getName().lastIndexOf('.');
				if (lastDotPos > 0) {
					ext = f.getName().substring(lastDotPos + 1);
				}
				System.out.println(ext);
				return ext.equals("npat");
			}

			@Override
			public String getDescription()
			{
				return "Neopad pattern files";
			}

		});
		fileChooser.setAcceptAllFileFilterUsed(false);
		add(fileChooser, BorderLayout.CENTER);

		/*
		 * fileChooser.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) { if
		 * (arg0.getActionCommand() == "ApproveSelection" && grid != null) { try
		 * { grid.importPattern( new PatternFile(fileChooser.getSelectedFile())
		 * .loadPattern()); } catch (IOException e) { e.printStackTrace(); } } }
		 * 
		 * });
		 */
	}
}
