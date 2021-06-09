package edu.westga.cs6910.pig.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the toString method in the Game
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class GameWhenToString {

	/**
	 * SUNNY-DAY Test the toString method on game start
	 */
	@Test
	public void testToString() {
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer();
		Game theGame = new Game(theHuman, theComputer);

		theGame.startNewGame(theComputer);

		assertEquals("Goal Score: 20\r\n" + "Human: 0\r\n" + "Simple computer: 0", theGame.toString());
	}
}