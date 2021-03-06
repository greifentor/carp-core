package de.ollie.carp.corelib.gui;

import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

/**
 * Some useful routines for GUI purposes.
 *
 * @author ollie (06.01.2021)
 */
public class GUIUtil {

	public static HorizontalLayout createBar(Component... components) {
		HorizontalLayout bar = new HorizontalLayout();
		bar.setWidthFull();
		for (Component component : components) {
			bar.add(component);
		}
		return bar;
	}

	public static Button createButton(String text, ComponentEventListener<ClickEvent<Button>> clickEventListener) {
		Button button = new Button(text);
		button.addClickListener(clickEventListener);
		button.setWidthFull();
		return button;
	}

	public static Label createLabel(String text) {
		Label label = new Label(text);
		label.setWidthFull();
		return label;
	}

	public static NumberField createNumberField(String text, int initialValue,
			HasValue.ValueChangeListener<? super ComponentValueChangeEvent<NumberField, Double>> listener,
			boolean enabled, int min, int max) {
		NumberField numberField = new NumberField(text);
		numberField.setValue((double) initialValue);
		numberField.setWidthFull();
		numberField.setEnabled(enabled);
		numberField.setHasControls(true);
		numberField.setMax(max);
		numberField.setMin(min);
		if (listener != null) { // OLI Adding listener at last is vital to avoid unexpected updates.
			numberField.addValueChangeListener(listener);
		}
		return numberField;
	}

	public static TextField createTextField(String text, String initialValue, boolean enabled) {
		return createTextField(text, initialValue, null, enabled);
	}

	public static TextField createTextField(String text, String initialValue,
			HasValue.ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener,
			boolean enabled) {
		TextField textField = new TextField(text);
		textField.setValue(initialValue);
		textField.setWidthFull();
		textField.setEnabled(enabled);
		if (listener != null) { // OLI Adding listener at last is vital to avoid unexpected updates.
			textField.addValueChangeListener(listener);
		}
		return textField;
	}

}