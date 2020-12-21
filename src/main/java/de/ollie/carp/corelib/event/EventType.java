package de.ollie.carp.corelib.event;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Identifiers for event types.
 *
 * @author ollie (21.12.2020)
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class EventType {

	public static final EventType LOGGED_IN = new EventType("LOGGED_IN");

	private String name;

}