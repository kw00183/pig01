package edu.westga.cs6910.pig.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the getTotal method extended to the
 * HumanPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class HumanPlayerWhenGetTotal {

	/**
	 * SUNNY-DAY Test the getTotal method returns 0 when human player
	 * initialized
	 */
	@Test
	public void testGetTotal() {
		HumanPlayer player = new HumanPlayer("Human");

		assertEquals(0, player.getTotal());
	}
}