package edu.westga.cs6910.pig.testing;

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
public class HumanPlayerWhenTakeTurn {

	/**
	 * SUNNY-DAY Test the takeTurn method is performing multiple rolls resulting
	 * in values other than 1 for the human player
	 */
	@Test
	public void testTakeTurn() {
		HumanPlayer player = new HumanPlayer("Human");
		boolean multipleRolls = false;

		player.takeTurn();
		String roll1 = player.getDiceValues();
		player.takeTurn();
		String roll2 = player.getDiceValues();
		player.takeTurn();
		String roll3 = player.getDiceValues();
		player.takeTurn();
		String roll4 = player.getDiceValues();
		player.takeTurn();
		String roll5 = player.getDiceValues();

		String allRolls = (roll1 + roll2 + roll3 + roll4 + roll5)
				.replace("1", "").replace(", ", "");
		int rollsGreaterThanOne = allRolls.length();

		if (rollsGreaterThanOne > 0) {
			multipleRolls = true;
		}

		assertEquals(true, multipleRolls);
	}
}