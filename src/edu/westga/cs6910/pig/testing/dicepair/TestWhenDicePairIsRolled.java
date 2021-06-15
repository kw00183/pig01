package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * This is the JUnit testing class to test the rollDice method in the DicePair
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenDicePairIsRolled {

	/**
	 * SUNNY-DAY Test the rollDice method after the dice pair is created and
	 * roll die 1 10000 times
	 */
	@Test
	public void testDie1Rolled10000() {
		DicePair testDicePair = new DicePair();
		for (int count = 0; count < 10000; count++) {
			testDicePair.rollDice();
			if (testDicePair.getDie1Value() < 1
					|| testDicePair.getDie1Value() > 6) {
				fail("Rolled a die with value: " + testDicePair.getDie1Value());
			}
		}
	}
	
	/**
	 * SUNNY-DAY Test the rollDice method after the dice pair is created and
	 * roll die 2 10000 times
	 */
	@Test
	public void testDie1Rolled20000() {
		DicePair testDicePair = new DicePair();
		for (int count = 0; count < 10000; count++) {
			testDicePair.rollDice();
			if (testDicePair.getDie2Value() < 1
					|| testDicePair.getDie2Value() > 6) {
				fail("Rolled a die with value: " + testDicePair.getDie2Value());
			}
		}
	}
	
	/**
	 * SUNNY-DAY Test the rollDice method after the dice pair is created and roll die 1
	 * 10000 times and get a 2 at least 1 time (just need it to roll something
	 * other than the start value of 1)
	 */
	@Test
	public void testDice1Rolled10000Rolls2() {
		boolean rolled2 = false;
		DicePair testDicePair = new DicePair();
		for (int count = 0; count < 10000; count++) {
			testDicePair.rollDice();
			if (testDicePair.getDie1Value() == 2) {
				rolled2 = true;
			}
		}
		assertEquals(true, rolled2);
	}
	
	/**
	 * SUNNY-DAY Test the rollDice method after the dice pair is created and roll die 2
	 * 10000 times and get a 2 at least 1 time (just need it to roll something
	 * other than the start value of 1)
	 */
	@Test
	public void testDice2Rolled10000Rolls2() {
		boolean rolled2 = false;
		DicePair testDicePair = new DicePair();
		for (int count = 0; count < 10000; count++) {
			testDicePair.rollDice();
			if (testDicePair.getDie2Value() == 2) {
				rolled2 = true;
			}
		}
		assertEquals(true, rolled2);
	}
}