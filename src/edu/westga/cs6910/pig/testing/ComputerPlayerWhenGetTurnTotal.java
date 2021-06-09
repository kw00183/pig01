package edu.westga.cs6910.pig.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * This is the JUnit testing class to test the getTurnTotal method extended to
 * the ComputerPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class ComputerPlayerWhenGetTurnTotal {

	/**
	 * SUNNY-DAY Test getter for the turn total for the computer player
	 */
	@Test
	public void testGetTurnTotal() {
		ComputerPlayer player = new ComputerPlayer();

		assertEquals(0, player.getTurnTotal());
	}
}