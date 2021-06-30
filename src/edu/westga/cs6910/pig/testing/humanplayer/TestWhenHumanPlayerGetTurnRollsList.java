package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the getTurnRollsList method extended
 * to the HumanPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenHumanPlayerGetTurnRollsList {

	/**
	 * SUNNY-DAY Test getTurnRollsList method for the human player with no dice
	 * rolls yet
	 */
	@Test
	public void testGetTurnRollsList0DicePair() {
		HumanPlayer player = new HumanPlayer("Human");

		assertEquals("[]", player.getTurnRollsList().toString());
	}

	/**
	 * SUNNY-DAY Test passing 1 dice pair to the setTurnRollsList method for the
	 * human player to validate the getTurnRollsList
	 */
	@Test
	public void testGetTurnRollsList1DicePair() {
		HumanPlayer player = new HumanPlayer("Human");
		String dicePair = "4, 3";

		player.setTurnRollsList(dicePair);

		assertEquals("[4, 3]", player.getTurnRollsList().toString());
	}
}