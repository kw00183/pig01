package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the setCurrentStrategy method in the Game
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenGameSetCurrentStrategy {

	/**
	 * SUNNY-DAY Test the setCurrentStrategy method accepts a string of cautious
	 */
	@Test
	public void testSetCurrentStrategyCautious() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		theGame.setCurrentStrategy("cautious");

		assertEquals("cautious", theGame.getCurrentStrategy());
	}

	/**
	 * SUNNY-DAY Test the setCurrentStrategy method accepts a string of greedy
	 */
	@Test
	public void testSetCurrentStrategyGreedy() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		theGame.setCurrentStrategy("greedy");

		assertEquals("greedy", theGame.getCurrentStrategy());
	}

	/**
	 * SUNNY-DAY Test the setCurrentStrategy method accepts a string of random
	 */
	@Test
	public void testSetCurrentStrategyRandom() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		theGame.setCurrentStrategy("random");

		assertEquals("random", theGame.getCurrentStrategy());
	}
}