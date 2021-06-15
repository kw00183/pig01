package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the getDicePair method in the Game
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenGameGetDicePair {

	/**
	 * SUNNY-DAY Test the getDicePair method on die 1
	 */
	@Test
	public void testGetDicePairDie1() {
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer();
		Game theGame = new Game(theHuman, theComputer);
		boolean isRolled = false;

		theGame.startNewGame(theComputer);
		theGame.play();
		
		if (theGame.getDicePair().getDie1Value() > 0) {
			isRolled = true;
		}

		assertEquals(true, isRolled);
	}
	
	/**
	 * SUNNY-DAY Test the getDicePair method on die 2
	 */
	@Test
	public void testGetDicePairDie2() {
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer();
		Game theGame = new Game(theHuman, theComputer);
		boolean isRolled = false;

		theGame.startNewGame(theComputer);
		theGame.play();
		
		if (theGame.getDicePair().getDie2Value() > 0) {
			isRolled = true;
		}

		assertEquals(true, isRolled);
	}
}