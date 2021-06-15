package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * This is the JUnit testing class to test the constructor in the Die class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenDieIsCreated {

	/**
	 * SUNNY-DAY Test the constructor creates a die with 1 pip
	 */
	@Test
	public void testShouldProduceDieWith1Pip() {
		Die newDie = new Die();
		assertEquals("pips: 1", newDie.toString());
	}
}