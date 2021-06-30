package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the getTurnRollsList method extended
 * to the ComputerPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenComputerPlayerGetTurnRollsList {

	/**
	 * SUNNY-DAY Test getTurnRollsList method for the computer player with no
	 * dice rolls yet
	 */
	@Test
	public void testGetTurnRollsList0DicePair() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer player = new ComputerPlayer(strategy);

		assertEquals("[]", player.getTurnRollsList().toString());
	}

	/**
	 * SUNNY-DAY Test passing 1 dice pair to the setTurnRollsList method for the
	 * computer player to validate the getTurnRollsList
	 */
	@Test
	public void testGetTurnRollsList1DicePair() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer player = new ComputerPlayer(strategy);
		String dicePair = "4, 3";

		player.setTurnRollsList(dicePair);

		assertEquals("[4, 3]", player.getTurnRollsList().toString());
	}
}