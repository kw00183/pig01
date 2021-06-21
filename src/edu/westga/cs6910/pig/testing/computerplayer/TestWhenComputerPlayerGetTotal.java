package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the getTotal method extended to the
 * ComputerPlayer class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenComputerPlayerGetTotal {

	/**
	 * SUNNY-DAY Test the getTotal method returns 0 when computer player
	 * initialized
	 */
	@Test
	public void testGetTotal() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer player = new ComputerPlayer(strategy);

		assertEquals(0, player.getTotal());
	}
}