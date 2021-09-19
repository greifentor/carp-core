package de.ollie.carp.corelib.localization.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import de.ollie.carp.corelib.localization.LocalizationSO;
import lombok.Getter;

/**
 * A Configuration for the file based resource manager,
 *
 * @author ollie (20.08.2021)
 */
@Configuration
@Getter
public class FileBasedResourceManagerConfiguration {

	@Value("${localization.resource.file.name.prefix:carp-s1889}")
	private String fileNamePrefix;

	@Value("${localization.resource.file.name.de:}")
	private String resourceFileNameDE;

	public String getResourceFileName(LocalizationSO localization) {
		switch (localization) {
		case DE:
			return resourceFileNameDE;
		default:
			return "";
		}
	}

}