package edu.westga.cs6910.pig.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the getName method in the HumanPlayer
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class HumanPlayerWhenGetName {

	/**
	 * SUNNY-DAY Test returning the correct name passed to class
	 */
	@Test
	public void testGetName() {
		HumanPlayer player = new HumanPlayer("Human");

		assertEquals("Human", player.getName());
	}

	/**
	 * BOUNDARY Test returning null as name when null passed to class
	 */
	@Test
	public void testGetNameEmptyName() {
		HumanPlayer player = new HumanPlayer(null);

		assertEquals(null, player.getName());
	}
}