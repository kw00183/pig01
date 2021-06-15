package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the takeTurn method in the
 * HumanPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenHumanPlayerTakeTurn {

	/**
	 * SUNNY-DAY Test the takeTurn method is performing multiple rolls resulting
	 * in values other than 1 for the human player
	 */
	@Test
	public void testTakeTurn() {
		HumanPlayer player = new HumanPlayer("Human");
		boolean differentRolls = false;

		for (int count = 0; count < 5; count++) {
			player.takeTurn();
			String roll = player.getDiceValues();
			player.setIsMyTurn(true);
			if (roll.replace("1", "").replace(", ", "").length() > 0) {
				differentRolls = true;
			}
		}
		assertEquals(true, differentRolls);
	}
}