package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the getFirstPlayer method in the Game
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenGameGetFirstPlayer {

	/**
	 * SUNNY-DAY Test the getFirstPlayer method returns a string of "human" when
	 * "human" set as first player
	 */
	@Test
	public void testGetFirstPlayerHuman() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		theGame.setFirstPlayer("human");

		assertEquals("human", theGame.getFirstPlayer());
	}

	/**
	 * SUNNY-DAY Test the getFirstPlayer method returns a string of "computer"
	 * when "computer" set as first player
	 */
	@Test
	public void testGetFirstPlayerComputer() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		theGame.setFirstPlayer("computer");

		assertEquals("computer", theGame.getFirstPlayer());
	}

	/**
	 * SUNNY-DAY Test the getFirstPlayer method returns a string of "" when
	 * nothing set as first player (ie first starts before player selected)
	 */
	@Test
	public void testGetFirstPlayerNone() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		assertEquals("", theGame.getFirstPlayer());
	}
}