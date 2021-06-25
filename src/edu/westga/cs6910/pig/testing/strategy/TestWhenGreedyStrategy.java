package edu.westga.cs6910.pig.testing.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.strategies.RandomStrategy;

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
	 * SUNNY-DAY Test the rollAgain method returns true at least once on second
	 * roll (max 3 per turn)
	 */
	@Test
	void testRollAgainGreedyReturnTrueRoll2() {
		GreedyStrategy strategy = new GreedyStrategy();
		boolean playerStrategyRolled = false;
		boolean strategyRolled;

		for (int count = 0; count < 5; count++) {
			strategyRolled = strategy.rollAgain(1, 5, 6);
			if (strategyRolled) {
				playerStrategyRolled = true;
			}
		}

		assertEquals(true, playerStrategyRolled);
	}

	/**
	 * SUNNY-DAY Test the rollAgain method returns true at least once if this is
	 * the third roll this turn (max 3 per turn)
	 */
	@Test
	void testRollAgainGreedyReturnTrueRoll3() {
		GreedyStrategy strategy = new GreedyStrategy();
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
	 * BOUNDARY Test the rollAgain method returns false if there are no more
	 * rolls left (max 3 per turn)
	 */
	@Test
	void testRollAgainGreedyReturnFalseRoll4() {
		GreedyStrategy strategy = new GreedyStrategy();
		boolean playerStrategyRolled = true;
		boolean strategyRolled;

		for (int count = 0; count < 5; count++) {
			strategyRolled = strategy.rollAgain(3, 5, 6);
			if (!strategyRolled) {
				playerStrategyRolled = false;
			}
		}

		assertEquals(false, playerStrategyRolled);
	}

	/**
	 * BOUNDARY Test the rollAgain method returns false when points needed is
	 * negative
	 */
	@Test
	void testRollAgainGreedyReturnFalseNegativePointsNeeded() {
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
	void testRollAgainGreedyReturnFalseNegativeTurnPoints() {
		RandomStrategy strategy = new RandomStrategy();
		boolean strategyRolled;

		strategyRolled = strategy.rollAgain(2, -5, 6);

		assertEquals(false, strategyRolled);
	}
}