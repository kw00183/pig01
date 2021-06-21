package edu.westga.cs6910.pig.testing.cautiousstrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This is the JUnit testing class to test the CautiousStrategy class that
 * implements the PigStrategy interface
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenCautiousStrategy {
	
	/**
	 * SUNNY-DAY Test the rollAgain method returns false using positive values for parameters
	 */
	@Test
	void testRollAgainPositiveReturnFalse() {
		CautiousStrategy strategy = new CautiousStrategy();

		assertEquals(false, strategy.rollAgain(4, 5, 6));
	}
	
	/**
	 * SUNNY-DAY Test the rollAgain method returns false using negative values for parameters
	 */
	@Test
	void testRollAgainNegativeReturnFalse() {
		CautiousStrategy strategy = new CautiousStrategy();

		assertEquals(false, strategy.rollAgain(-4, -5, -6));
	}
}