package de.ollie.carp.corelib.service.user;

/**
 * An interface for session owners.
 *
 * @author ollie (21.12.2020)
 */
public interface SessionOwner {

	UserAuthorizationSO getUserAuthorization();

	void setUserAuthorization(UserAuthorizationSO userAuthorization);

}