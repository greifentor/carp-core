package de.ollie.carp.corelib.gui.vaadin.component;

/**
 * An extended button for easy configuration.
 *
 * @author ollie (15.08.2021)
 */
public class Button extends com.vaadin.flow.component.button.Button {

	public Button(String text) {
		super(text);
	}

	private Button setStyle(String name, String value) {
		getStyle().set(name, value);
		return this;
	}

	public Button setBackgroundColor(String backgroundColor) {
		return setStyle("background-color", backgroundColor);
	}

	public Button setBackgroundImage(String imageFileName) {
		return setStyle("background-image", "url('" + imageFileName + "')");
	}

	public Button setBorder(String border) {
		return setStyle("border", border);
	}

	public Button setBorderColor(String borderColor) {
		return setStyle("border-color", borderColor);
	}

	public Button setColor(String color) {
		return setStyle("color", color);
	}

}