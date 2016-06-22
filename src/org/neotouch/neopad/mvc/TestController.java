package org.neotouch.neopad.mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TestController
{
	TestModel model;
	TestView view;
	TestController innerController = null;

	public TestController(TestModel model, TestView view)
	{
		this(model, view, 0);
	}

	public TestController(TestModel model, TestView view, int instance)
	{
		System.out.println("TestController instance n°" + instance);
		if (instance < 5) {
			this.innerController = new TestController(model.getInnerModel(),
					view, instance + 1);
		}

		this.model = model;
		this.view = view;

		this.model.addPropertyChangeListener(new PropertyChangeListener()
		{
			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				int oldValue = (int) evt.getOldValue();
				int newValue = (int) evt.getNewValue();

				if (oldValue != newValue) {
					view.printIntValue(newValue);
					if (model.getInnerModel() != null) {
						model.getInnerModel().setI(newValue);
					}
				}
			}
		});

	}
}
