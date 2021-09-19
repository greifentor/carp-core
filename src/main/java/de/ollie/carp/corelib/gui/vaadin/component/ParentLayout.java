package de.ollie.carp.corelib.gui.vaadin.component;

import com.vaadin.flow.component.Component;

/**
 * An interface for parent layouts.
 *
 * @author ollie (17.08.2021)
 */
public interface ParentLayout {

	void back();

	void updateViewWith(Component component);

}