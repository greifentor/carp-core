package de.ollie.carp.corelib.gui.vaadin.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * A grid of buttons.
 *
 * @author ollie (15.08.2021)
 */
public class ButtonGrid extends VerticalLayout {

	public ButtonGrid(int buttonsPerRow, Button... buttons) {
		List<Button> buttonList = new ArrayList<>(Arrays.asList(buttons));
		while (!buttonList.isEmpty()) {
			add(createRow(buttonsPerRow, buttonList));
		}
	}

	private HorizontalLayout createRow(int buttonsPerRow, List<Button> buttonList) {
		HorizontalLayout row = new HorizontalLayout();
		row.setMargin(false);
		row.setWidthFull();
		while (buttonsPerRow > 0 && !buttonList.isEmpty()) {
			Button button = buttonList.get(0);
			row.add(button);
			buttonList.remove(button);
			buttonsPerRow--;
		}
		while (buttonsPerRow > 0) {
			Button button = new Button("").setBackgroundColor("transparent").setBorder("none");
			button.setWidthFull();
			button.setEnabled(false);
			row.add(button);
			buttonsPerRow--;
		}
		return row;
	}

}