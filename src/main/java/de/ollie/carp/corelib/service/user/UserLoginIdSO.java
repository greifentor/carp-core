package de.ollie.carp.corelib.service.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * A container for user login id's.
 *
 * @author ollie (28.08.2020)
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class UserLoginIdSO {

	private String key;

}