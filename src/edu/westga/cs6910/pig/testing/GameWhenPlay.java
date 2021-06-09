package edu.westga.cs6910.pig.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This is the JUnit testing class to test the play method in the Game class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class GameWhenPlay {

	/**
	 * SUNNY-DAY Test the play method with theComputer player, because they only
	 * get one turn, and it should reflect current player as human after play
	 */
	@Test
	public void testPlayHuman() {
		HumanPlayer theHuman = new HumanPlayer("Human");
		ComputerPlayer theComputer = new ComputerPlayer();
		Game theGame = new Game(theHuman, theComputer);

		theGame.startNewGame(theComputer);
		theGame.play();

		assertEquals("Human", theGame.getCurrentPlayer().getName());
	}
}