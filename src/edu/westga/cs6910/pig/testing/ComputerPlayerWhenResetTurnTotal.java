package edu.westga.cs6910.pig.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * This is the JUnit testing class to test the resetTurnTotal method in the
 * ComputerPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class ComputerPlayerWhenResetTurnTotal {

	/**
	 * SUNNY-DAY Test reseting the turn total for the computer player
	 */
	@Test
	public void testResetTurnTotal() {
		ComputerPlayer player = new ComputerPlayer();

		player.resetTurnTotal();

		assertEquals(0, player.getTurnTotal());
	}
}