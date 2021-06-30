package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the resetTurnRollsList method
 * extended to the ComputerPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenComputerPlayerResetTurnRollsList {

	/**
	 * SUNNY-DAY Test resetTurnRollsList method for the computer player returns
	 * empty array list after set 1 dice pair
	 */
	@Test
	public void testResetTurnRollsListSet1DicePair() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer player = new ComputerPlayer(strategy);
		String dicePair = "4, 3";

		player.setTurnRollsList(dicePair);
		player.resetTurnRollsList();

		assertEquals("[]", player.getTurnRollsList().toString());
	}
}