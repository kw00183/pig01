package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the getCurrentPlayer method in the
 * Game class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class GameWhenGetCurrentPlayer {

	/**
	 * SUNNY-DAY Test the getCurrentPlayer method with theComputer
	 */
	@Test
	public void testGetCurrentPlayerComputer() {
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer();
		Game theGame = new Game(theHuman, theComputer);

		theGame.startNewGame(theComputer);

		assertEquals("Simple computer", theGame.getCurrentPlayer().getName());
	}

	/**
	 * SUNNY-DAY Test the getCurrentPlayer method with theHuman
	 */
	@Test
	public void testGetCurrentPlayerHuman() {
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer();
		Game theGame = new Game(theHuman, theComputer);

		theGame.startNewGame(theHuman);

		assertEquals("Human", theGame.getCurrentPlayer().getName());
	}
}