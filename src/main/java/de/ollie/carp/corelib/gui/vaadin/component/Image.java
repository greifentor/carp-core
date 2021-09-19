package de.ollie.carp.corelib.gui.vaadin.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.vaadin.flow.server.StreamResource;

/**
 * A component for a file based image.
 *
 * @author ollie (15.08.2021)
 */
public class Image extends com.vaadin.flow.component.html.Image {

	public Image(File file) {
		this(file, "alt text");
	}

	public Image(File file, String altText) {
		super(new StreamResource(file.getName(), () -> {
			try {
				return new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}), altText);
	}

}