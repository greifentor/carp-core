package de.ollie.carp.corelib.localization.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.ollie.carp.corelib.localization.LocalizationSO;
import de.ollie.carp.corelib.localization.ResourceManager;

/**
 * An implementation for a file based resource manager.
 *
 * @author ollie (31.12.2020)
 */
@Named
public class FileBasedResourceManagerImpl implements ResourceManager {

	private static final Logger logger = LogManager.getLogger(FileBasedResourceManagerImpl.class);

	private Map<LocalizationSO, Properties> resources = new HashMap<>();

	public FileBasedResourceManagerImpl() {
		for (LocalizationSO localization : LocalizationSO.values()) {
			String fileName = System.getProperty("localization.resource.file.name." + localization.name().toLowerCase(),
					"classpath:localization/carp-s1889_resources_" + localization.name().toLowerCase() + ".properties");
			Properties properties = new Properties();
			if (fileName.startsWith("classpath:")) {
				try {
					properties
							.load(getClass().getClassLoader().getResourceAsStream(fileName.replace("classpath:", "")));
				} catch (IOException ioe) {
					throw new IllegalStateException(
							"Resource not found '" + fileName + "' for localization: " + localization);
				}
			} else {
				if (!new File(fileName).exists()) {
					throw new IllegalStateException(
							"Resource file not found '" + fileName + "' for localization: " + localization);
				}
				try {
					properties.load(new FileReader(fileName));
				} catch (IOException ioe) {
					throw new IllegalStateException(
							"Resource file not readable '" + fileName + "' for localization: " + localization);
				}
			}
			resources.put(localization, properties);
		}
	}

	@Override
	public String getLocalizedString(String resourceId) {
		return getLocalizedString(resourceId, LocalizationSO.DE);
	}

	@Override
	public String getLocalizedString(String resourceId, LocalizationSO localization) {
		Properties properties = resources.get(localization);
		if (properties == null) {
			return resourceId;
		}
		return properties.getProperty(resourceId, resourceId);
	}

}