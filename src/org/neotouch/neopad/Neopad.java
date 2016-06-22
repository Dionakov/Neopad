package org.neotouch.neopad;

import java.io.IOException;

import org.neotouch.neopad.mvc.TestController;
import org.neotouch.neopad.mvc.TestModel;
import org.neotouch.neopad.mvc.TestView;

public class Neopad
{

	public static void main(String[] args) throws IOException
	{
		TestModel model = new TestModel();
		TestView view = new TestView();

		TestController controller = new TestController(model, view);

		model.setI(10);
		model.setI(20);
	}

}
