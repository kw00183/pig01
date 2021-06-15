package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * This is the JUnit testing class to test the getIsMyTurn method extended to
 * the ComputerPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenComputerPlayerGetIsMyTurn {

	/**
	 * SUNNY-DAY Test getter for the getIsMyTurn method for the computer player
	 */
	@Test
	public void testGetIsMyTurn() {
		ComputerPlayer player = new ComputerPlayer();

		assertEquals(false, player.getIsMyTurn());
	}
}