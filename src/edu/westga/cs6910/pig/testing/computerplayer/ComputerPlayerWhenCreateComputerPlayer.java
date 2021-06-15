package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * This is the JUnit testing class to test the constructor in the ComputerPlayer
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class ComputerPlayerWhenCreateComputerPlayer {

	/**
	 * SUNNY-DAY Test the constructor accepts the name and initializes the
	 * ComputerPlayer object
	 */
	@Test
	public void testCreateComputerPlayer() {
		ComputerPlayer player = new ComputerPlayer();

		assertEquals("Simple computer", player.getName());
	}
}