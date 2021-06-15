package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the resetTurnTotal method in the
 * HumanPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenHumanPlayerResetTurnTotal {

	/**
	 * SUNNY-DAY Test reseting the turn total for the human player
	 */
	@Test
	public void testResetTurnTotal() {
		HumanPlayer player = new HumanPlayer("Human");

		player.resetTurnTotal();

		assertEquals(0, player.getTurnTotal());
	}
}