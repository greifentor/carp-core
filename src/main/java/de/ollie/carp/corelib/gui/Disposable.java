package de.ollie.carp.corelib.gui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasOrderedComponents;

/**
 * An interface for disposable objects.
 *
 * @author ollie (01.09.2020)
 */
public interface Disposable {

	void dispose();

	static void removeAll(HasOrderedComponents c) {
		for (int i = 0, leni = c.getComponentCount(); i < leni; i++) {
			Component component = c.getComponentAt(i);
			if (component instanceof Disposable) {
				((Disposable) component).dispose();
				component.getElement().removeFromTree();
				c.remove(component);
			}
		}
		c.removeAll();
	}

}