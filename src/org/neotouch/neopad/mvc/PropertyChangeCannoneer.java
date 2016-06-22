package org.neotouch.neopad.mvc;

import java.beans.PropertyChangeListener;

public interface PropertyChangeCannoneer
{
	void addPropertyChangeListener(PropertyChangeListener listener);

	void removePropertyChangeListener(PropertyChangeListener listener);

	PropertyChangeListener[] getPropertyChangeListeners();
}
