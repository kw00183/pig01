package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the resetTurnRollsList method
 * extended to the HumanPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenHumanPlayerResetTurnRollsList {

	/**
	 * SUNNY-DAY Test resetTurnRollsList method for the human player returns
	 * empty array list after set 1 dice pair
	 */
	@Test
	public void testResetTurnRollsListSet1DicePair() {
		HumanPlayer player = new HumanPlayer("Human");
		String dicePair = "4, 3";

		player.setTurnRollsList(dicePair);
		player.resetTurnRollsList();

		assertEquals("[]", player.getTurnRollsList().toString());
	}
}