package de.ollie.carp.corelib.service;

/**
 * An interface for a service which provides some information about the application configuration.
 *
 * @author ollie (21.12.2020)
 */
public interface AppConfiguration {

	/**
	 * Returns the name of the application.
	 * 
	 * @return The name of the application.
	 */
	String getName();

	/**
	 * Returns the version of the application.
	 * 
	 * @return The version of the application.
	 */
	String getVersion();

}