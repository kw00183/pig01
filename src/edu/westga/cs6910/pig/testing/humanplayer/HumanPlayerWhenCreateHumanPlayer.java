package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the constructor in the HumanPlayer
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class HumanPlayerWhenCreateHumanPlayer {

	/**
	 * SUNNY-DAY Test the constructor accepts the name and initializes the
	 * HumanPlayer object
	 */
	@Test
	public void testCreateHumanPlayer() {
		HumanPlayer player = new HumanPlayer("Human");

		assertEquals("Human", player.getName());
	}
}