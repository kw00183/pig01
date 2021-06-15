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
	 * SUNNY-DAY Test the getDie1Value method when the die pair is created
	 */
	@Test
	public void testWithNewDiceDie1Equals1() {
		DicePair newDice = new DicePair();
		assertEquals(1, newDice.getDie1Value());
	}

	/**
	 * SUNNY-DAY Test the getDie2Value method when the die pair is created
	 */
	@Test
	public void testWithNewDiceDie2Equals1() {
		DicePair newDice = new DicePair();
		assertEquals(1, newDice.getDie2Value());
	}
}