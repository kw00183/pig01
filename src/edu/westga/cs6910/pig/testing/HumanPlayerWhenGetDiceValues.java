package edu.westga.cs6910.pig.testing;

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
public class HumanPlayerWhenGetDiceValues {

	/**
	 * SUNNY-DAY Test the getDiceValues return a string containing more than the
	 * ", " characters.
	 */
	@Test
	public void testGetDiceValues() {
		HumanPlayer player = new HumanPlayer("Human");
		boolean dicePopulated = false;

		String testDiceValues = player.getDiceValues();
		int testDiceValueLength = testDiceValues.length();

		if (testDiceValueLength > 2) {
			dicePopulated = true;
		}

		assertEquals(true, dicePopulated);
	}
}