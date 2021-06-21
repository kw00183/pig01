package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the setIsMyTurn method extended to
 * the ComputerPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenComputerPlayerSetIsMyTurn {

	/**
	 * SUNNY-DAY Test passing true to the setIsMyTurn method for the computer
	 * player
	 */
	@Test
	public void testSetIsMyTurnPassTrue() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer player = new ComputerPlayer(strategy);

		player.setIsMyTurn(true);

		assertEquals(true, player.getIsMyTurn());
	}

	/**
	 * SUNNY-DAY Test passing false to the setIsMyTurn method for the computer
	 * player
	 */
	@Test
	public void testSetIsMyTurnPassFalse() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer player = new ComputerPlayer(strategy);

		player.setIsMyTurn(false);

		assertEquals(false, player.getIsMyTurn());
	}
}