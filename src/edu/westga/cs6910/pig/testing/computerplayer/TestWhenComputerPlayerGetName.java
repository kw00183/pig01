package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * This is the JUnit testing class to test the getName method in the ComputerPlayer
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenComputerPlayerGetName {

	/**
	 * SUNNY-DAY Test returning the correct name passed to class
	 */
	@Test
	public void testGetName() {
		ComputerPlayer player = new ComputerPlayer();

		assertEquals("Simple computer", player.getName());
	}
}