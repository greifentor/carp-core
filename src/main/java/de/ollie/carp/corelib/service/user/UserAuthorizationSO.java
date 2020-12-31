package de.ollie.carp.corelib.service.user;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Data for a users authorization.
 *
 * @author ollie (21.12.2020)
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class UserAuthorizationSO {

	private UserLoginIdSO userLoginId;
	private String password;
	private Set<UserRoleSO> roles;

}