package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * This is the JUnit testing class to test the getNumberOfPips method in the Die
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenGetPips {

	/**
	 * SUNNY-DAY Test the getNumberOfPips method when the die is created
	 */
	@Test
	public void testWithNewDieShouldHave1Pip() {
		Die newDie = new Die();
		assertEquals(1, newDie.getNumberOfPips());
	}
}