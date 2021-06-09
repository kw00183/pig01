package edu.westga.cs6910.pig.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the hold method in the Game class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class GameWhenHold {

	/**
	 * SUNNY-DAY Test the hold method with theHuman player, because they are the
	 * only player able to hold, and it should reflect current player as
	 * computer after hold
	 */
	@Test
	public void testHoldHuman() {
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer();
		Game theGame = new Game(theHuman, theComputer);

		theGame.startNewGame(theHuman);
		theGame.play();
		
		if (theGame.getCurrentPlayer().getName().equals("Human")) {
			theGame.hold();
		}

		assertEquals("Simple computer", theGame.getCurrentPlayer().getName());
	}
}