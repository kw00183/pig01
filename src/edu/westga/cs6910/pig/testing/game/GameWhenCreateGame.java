package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the constructor in the Game class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class GameWhenCreateGame {

	/**
	 * SUNNY-DAY Test the constructor accepts the players, initializes them and
	 * returns the player names with getter
	 */
	@Test
	public void testCreateGame() {
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer();
		Game theGame = new Game(theHuman, theComputer);

		assertEquals("Human", theGame.getHumanPlayer().getName());
		assertEquals("Simple computer", theGame.getComputerPlayer().getName());
	}
}