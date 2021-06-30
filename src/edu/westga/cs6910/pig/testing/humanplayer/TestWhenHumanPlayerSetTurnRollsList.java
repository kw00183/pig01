package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the setTurnRollsList method extended
 * to the HumanPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenHumanPlayerSetTurnRollsList {

	/**
	 * SUNNY-DAY Test passing 1 dice pair to the setTurnRollsList method for the
	 * human player
	 */
	@Test
	public void testSetTurnRollsList1DicePair() {
		HumanPlayer player = new HumanPlayer("Human");
		String dicePair = "4, 3";

		player.setTurnRollsList(dicePair);

		assertEquals("[4, 3]", player.getTurnRollsList().toString());
	}

	/**
	 * SUNNY-DAY Test passing 2 dice pairs to the setTurnRollsList method for
	 * the human player
	 */
	@Test
	public void testSetTurnRollsList2DicePair() {
		HumanPlayer player = new HumanPlayer("Human");
		String dicePair1 = "4, 3";
		player.setTurnRollsList(dicePair1);

		String dicePair2 = "1, 3";
		player.setTurnRollsList(dicePair2);

		assertEquals("[4, 3, 1, 3]", player.getTurnRollsList().toString());
	}
}