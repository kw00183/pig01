package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the getComputerPlayer method in the
 * Game class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class GameWhenGetComputerPlayer {

	/**
	 * SUNNY-DAY Test the getComputerPlayer method with theComputer
	 */
	@Test
	public void testGetComputerPlayer() {
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer();
		Game theGame = new Game(theHuman, theComputer);

		theGame.startNewGame(theComputer);
		
		assertEquals("Simple computer", theGame.getComputerPlayer().getName());
	}
}