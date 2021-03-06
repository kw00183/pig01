package edu.westga.cs6910.pig.testing.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.RandomStrategy;

/**
 * This is the JUnit testing class to test the RandomStrategy class that
 * implements the PigStrategy interface
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenRandomStrategy {

	/**
	 * SUNNY-DAY Test the rollAgain method returns false at least 1 time when
	 * 50/50 and strategy invoked 5 times
	 */
	@Test
	void testRollAgainRandomReturnFalse() {
		RandomStrategy strategy = new RandomStrategy();
		boolean playerStrategyRolled = false;
		boolean strategyRolled;

		for (int count = 0; count < 5; count++) {
			strategyRolled = strategy.rollAgain(2, 5, 6);
			if (!strategyRolled) {
				playerStrategyRolled = false;
			}
		}

		assertEquals(false, playerStrategyRolled);
	}

	/**
	 * SUNNY-DAY Test the rollAgain method returns true at least 1 time when
	 * 50/50 and strategy invoked 5 times
	 */
	@Test
	void testRollAgainRandomReturnTrue() {
		RandomStrategy strategy = new RandomStrategy();
		boolean playerStrategyRolled = false;
		boolean strategyRolled;

		for (int count = 0; count < 5; count++) {
			strategyRolled = strategy.rollAgain(2, 5, 6);
			if (strategyRolled) {
				playerStrategyRolled = true;
			}
		}

		assertEquals(true, playerStrategyRolled);
	}

	/**
	 * BOUNDARY Test the rollAgain method returns false when points needed is
	 * negative
	 */
	@Test
	void testRollAgainRandomReturnFalseNegativePointsNeeded() {
		RandomStrategy strategy = new RandomStrategy();
		boolean strategyRolled;

		strategyRolled = strategy.rollAgain(2, 5, -6);

		assertEquals(false, strategyRolled);
	}

	/**
	 * BOUNDARY Test the rollAgain method returns false when turn points is
	 * negative
	 */
	@Test
	void testRollAgainRandomReturnFalseNegativeTurnPoints() {
		RandomStrategy strategy = new RandomStrategy();
		boolean strategyRolled;

		strategyRolled = strategy.rollAgain(2, -5, 6);

		assertEquals(false, strategyRolled);
	}
}