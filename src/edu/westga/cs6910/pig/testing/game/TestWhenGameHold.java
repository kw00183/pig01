package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the hold method in the Game class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenGameHold {

	/**
	 * SUNNY-DAY Test the hold method with theHuman player, because they are the
	 * only player able to hold, and it should reflect current player as
	 * computer after hold
	 */
	@Test
	public void testHoldHuman() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer(strategy);
		Game theGame = new Game(theHuman, theComputer);

		theGame.startNewGame(theHuman);
		theGame.play();
		
		if (theGame.getCurrentPlayer().getName().equals("Human")) {
			theGame.hold();
		}

		assertEquals("Simple computer", theGame.getCurrentPlayer().getName());
	}
}