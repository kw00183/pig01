package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the getHumanPlayer method in the Game
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenGameGetHumanPlayer {

	/**
	 * SUNNY-DAY Test the getHumanPlayer method with theHuman
	 */
	@Test
	public void testGetHumanPlayer() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		theGame.startNewGame(theHuman);
		
		assertEquals("Human", theGame.getHumanPlayer().getName());
	}
}