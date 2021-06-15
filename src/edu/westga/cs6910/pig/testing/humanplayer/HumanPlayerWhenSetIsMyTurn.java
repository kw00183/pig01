package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the setIsMyTurn method extended to
 * the HumanPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class HumanPlayerWhenSetIsMyTurn {

	/**
	 * SUNNY-DAY Test passing true to the setIsMyTurn method for the human
	 * player
	 */
	@Test
	public void testSetIsMyTurnPassTrue() {
		HumanPlayer player = new HumanPlayer("Human");

		player.setIsMyTurn(true);

		assertEquals(true, player.getIsMyTurn());
	}

	/**
	 * SUNNY-DAY Test passing false to the setIsMyTurn method for the human
	 * player
	 */
	@Test
	public void testSetIsMyTurnPassFalse() {
		HumanPlayer player = new HumanPlayer("Human");

		player.setIsMyTurn(false);

		assertEquals(false, player.getIsMyTurn());
	}
}