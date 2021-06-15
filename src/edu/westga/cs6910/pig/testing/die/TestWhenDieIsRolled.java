package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * This is the JUnit testing class to test the roll method in the Die class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenDieIsRolled {

	/**
	 * SUNNY-DAY Test the roll method after the die is created and roll die
	 * 10000 times
	 */
	@Test
	public void testDieRolled10000() {
		Die testDie = new Die();
		for (int count = 0; count < 10000; count++) {
			testDie.roll();
			if (testDie.getNumberOfPips() < 1
					|| testDie.getNumberOfPips() > 6) {
				fail("Rolled a die with value: " + testDie.getNumberOfPips());
			}
		}
	}

	/**
	 * SUNNY-DAY Test the roll method after the die is created and roll die
	 * 10000 times and get a 2 at least 1 time (just need it to roll something
	 * other than the start value of 1)
	 */
	@Test
	public void testDieRolled10000Rolls2() {
		boolean rolled2 = false;
		Die testDie = new Die();
		for (int count = 0; count < 10000; count++) {
			testDie.roll();
			if (testDie.getNumberOfPips() == 2) {
				rolled2 = true;
			}
		}
		assertEquals(true, rolled2);
	}
}