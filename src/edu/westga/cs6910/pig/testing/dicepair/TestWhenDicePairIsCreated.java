package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * This is the JUnit testing class to test the constructor in the DicePair
 * class.
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenDicePairIsCreated {

	/**
	 * SUNNY-DAY Test the constructor creates die 1 with pip value of 1
	 */
	@Test
	public void testDicePairCreatedDie1Equals1() {
		DicePair newDice = new DicePair();
		assertEquals(1, newDice.getDie1Value());
	}

	/**
	 * SUNNY-DAY Test the constructor creates die 2 with pip value of 1
	 */
	@Test
	public void testDicePairCreatedDie2Equals1() {
		DicePair newDice = new DicePair();
		assertEquals(1, newDice.getDie2Value());
	}
}