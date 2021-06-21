package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the takeTurn method in the
 * ComputerPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenComputerPlayerTakeTurn {

	/**
	 * SUNNY-DAY Test the takeTurn method is performing multiple rolls resulting
	 * in values other than 1 for the computer player
	 */
	@Test
	public void testTakeTurn() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer player = new ComputerPlayer(strategy);
		boolean differentRolls = false;

		for (int count = 0; count < 5; count++) {
			player.setMaximumRolls(5);
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