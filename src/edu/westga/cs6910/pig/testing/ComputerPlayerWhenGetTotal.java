package edu.westga.cs6910.pig.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * This is the JUnit testing class to test the getTotal method extended to the
 * ComputerPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class ComputerPlayerWhenGetTotal {

	/**
	 * SUNNY-DAY Test the getTotal method returns 0 when computer player
	 * initialized
	 */
	@Test
	public void testGetTotal() {
		ComputerPlayer player = new ComputerPlayer();

		assertEquals(0, player.getTotal());
	}
}