package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the getIsMyTurn method extended to
 * the HumanPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class HumanPlayerWhenGetIsMyTurn {

	/**
	 * SUNNY-DAY Test getter for the getIsMyTurn method for the human player
	 */
	@Test
	public void testGetIsMyTurn() {
		HumanPlayer player = new HumanPlayer("Human");

		assertEquals(false, player.getIsMyTurn());
	}
}