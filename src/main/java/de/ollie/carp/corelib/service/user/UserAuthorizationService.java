package de.ollie.carp.corelib.service.user;

import java.util.Optional;

/**
 * An interface for the user login and authentication.
 *
 * @author ollie (21.12.2020)
 */
public interface UserAuthorizationService {

	/**
	 * Returns an optional with the user authorization data for the passed password and user name.
	 * 
	 * @param userName The user name in the system.
	 * @param password The password to authenticate the user.
	 * @return An optional with the user authorization data.
	 */
	Optional<UserAuthorizationSO> authenticate(String userName, String password);

}