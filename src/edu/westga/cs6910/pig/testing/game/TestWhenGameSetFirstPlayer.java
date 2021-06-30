package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the setFirstPlayer method in the Game
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenGameSetFirstPlayer {

	/**
	 * SUNNY-DAY Test the setFirstPlayer method accepts a string of the first
	 * player is human
	 */
	@Test
	public void testSetFirstPlayerHuman() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);
		
		theGame.setFirstPlayer("human");

		assertEquals("human", theGame.getFirstPlayer());
	}
	
	/**
	 * SUNNY-DAY Test the setFirstPlayer method accepts a string of the first
	 * player is computer
	 */
	@Test
	public void testSetFirstPlayerComputer() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);
		
		theGame.setFirstPlayer("computer");

		assertEquals("computer", theGame.getFirstPlayer());
	}
}