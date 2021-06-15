package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the getDiceValues method extended to
 * the HumanPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenHumanPlayerGetDiceValues {

	/**
	 * SUNNY-DAY Test the getDiceValues return a string containing the default
	 * "1, 1" characters.
	 */
	@Test
	public void testGetDiceValues() {
		HumanPlayer player = new HumanPlayer("Human");

		assertEquals("1, 1", player.getDiceValues());
	}
}