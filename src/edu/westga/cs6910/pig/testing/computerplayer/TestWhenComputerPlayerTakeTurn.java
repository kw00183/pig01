package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

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
		ComputerPlayer player = new ComputerPlayer();
		boolean multipleRolls = false;

		player.setMaximumRolls(5);
		player.takeTurn();
		String roll1 = player.getDiceValues();
		player.setIsMyTurn(true);
		
		player.setMaximumRolls(5);
		player.takeTurn();
		String roll2 = player.getDiceValues();
		player.setIsMyTurn(true);
		
		player.setMaximumRolls(5);
		player.takeTurn();
		String roll3 = player.getDiceValues();
		player.setIsMyTurn(true);
		
		player.setMaximumRolls(5);
		player.takeTurn();
		String roll4 = player.getDiceValues();
		player.setIsMyTurn(true);
		
		player.setMaximumRolls(5);
		player.takeTurn();
		String roll5 = player.getDiceValues();
		player.setIsMyTurn(true);

		String allRolls = (roll1 + roll2 + roll3 + roll4 + roll5)
				.replace("1", "").replace(", ", "");
		int rollsGreaterThanOne = allRolls.length();
		System.out.print(rollsGreaterThanOne);

		if (rollsGreaterThanOne > 0) {
			multipleRolls = true;
		}

		assertEquals(true, multipleRolls);
	}
}