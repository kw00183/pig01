package edu.westga.cs6910.pig.testing.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;

/**
 * This is the JUnit testing class to test the GreedyStrategy class that
 * implements the PigStrategy interface
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class TestWhenGreedyStrategy {

	/**
	 * SUNNY-DAY Test the rollAgain method returns true at least once if there
	 * are still rolls left (max 3)
	 */
	@Test
	void testRollAgainGreedyReturnTrue1RollLeft() {
		GreedyStrategy strategy = new GreedyStrategy();
		boolean playerStrategyRolledFalse = false;
		boolean strategyRolled;

		for (int count = 0; count < 5; count++) {
			strategyRolled = strategy.rollAgain(1, 5, 6);
			if (strategyRolled) {
				playerStrategyRolledFalse = true;
			}
		}

		assertEquals(true, playerStrategyRolledFalse);
	}

	/**
	 * SUNNY-DAY Test the rollAgain method returns true at least once if this is
	 * the third roll this turn (max 3)
	 */
	@Test
	void testRollAgainGreedyReturnTrue2RollsLeft() {
		GreedyStrategy strategy = new GreedyStrategy();
		boolean playerStrategyRolledFalse = false;
		boolean strategyRolled;

		for (int count = 0; count < 5; count++) {
			strategyRolled = strategy.rollAgain(2, 5, 6);
			if (strategyRolled) {
				playerStrategyRolledFalse = true;
			}
		}

		assertEquals(true, playerStrategyRolledFalse);
	}

	/**
	 * BOUNDARY Test the rollAgain method returns false if there are no more
	 * rolls left (max 3)
	 */
	@Test
	void testRollAgainGreedyReturnFalseRoll4() {
		GreedyStrategy strategy = new GreedyStrategy();
		boolean playerStrategyRolledFalse = false;
		boolean strategyRolled;

		for (int count = 0; count < 5; count++) {
			strategyRolled = strategy.rollAgain(0, 5, 6);
			if (!strategyRolled) {
				playerStrategyRolledFalse = true;
			}
		}

		assertEquals(true, playerStrategyRolledFalse);
	}
}