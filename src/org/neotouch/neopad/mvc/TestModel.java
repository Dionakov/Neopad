package org.neotouch.neopad.mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.EventListenerList;

public final class TestModel implements PropertyChangeCannoneer
{
	private int i = 0;

	private EventListenerList listeners = new EventListenerList();
	private TestModel innerModel = null;

	public TestModel()
	{
		this(0);
	}

	public TestModel(int instance)
	{
		System.out.println("TestModel instance n°" + instance);

		if (instance < 5) {
			innerModel = new TestModel(instance + 1);
		}
	}

	public TestModel getInnerModel()
	{
		return this.innerModel;
	}

	public int getI()
	{
		return this.i;
	}

	public void setI(int i)
	{
		firePropertyChange("i", this.i, i);
		this.i = i;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		listeners.add(PropertyChangeListener.class, listener);
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener)
	{
		listeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public PropertyChangeListener[] getPropertyChangeListeners()
	{
		return listeners.getListeners(PropertyChangeListener.class);
	}

	protected void firePropertyChange(String propertyName, Object oldValue,
			Object newValue)
	{
		PropertyChangeEvent event = new PropertyChangeEvent(this, propertyName,
				oldValue, newValue);

		for (PropertyChangeListener l : getPropertyChangeListeners()) {

			l.propertyChange(event);
		}
	}
}
