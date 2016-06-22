package org.neotouch.neopad.mvc;

public abstract class Controller
{
	private View view;
	private Model model;

	public Controller(View view, Model model)
	{
		this.view = view;
		this.model = model;
	}

	public View getView()
	{
		return this.view;
	}

	public Model getModel()
	{
		return this.model;
	}
}
