package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the constructor in the Game class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenCreateGame {

	/**
	 * SUNNY-DAY Test the constructor accepts the players, initializes them and
	 * returns the human player name with getter
	 */
	@Test
	public void testCreateGameHuman() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		assertEquals("Human", theGame.getHumanPlayer().getName());
	}

	/**
	 * SUNNY-DAY Test the constructor accepts the players, initializes them and
	 * returns the computer player name with getter
	 */
	@Test
	public void testCreateGameComputer() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		assertEquals("Simple computer", theGame.getComputerPlayer().getName());
	}
}