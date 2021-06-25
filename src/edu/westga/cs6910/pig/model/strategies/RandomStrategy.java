package edu.westga.cs6910.pig.model.strategies;

/**
 * Class for the random pig strategy that implements the PigStrategy interface
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class RandomStrategy implements PigStrategy {

	@Override
	public boolean rollAgain(int numberOfRollsTakenThisTurn, int numberOfPointsEarnedThisTurn,
			int numberOfPointsNeededToWin) {
		boolean shouldPlayerRoll = false;
		
		if (Math.random() < 0.5 && numberOfPointsNeededToWin > 0 && numberOfPointsEarnedThisTurn > 0) {
			shouldPlayerRoll = true;
		}
		return shouldPlayerRoll;
	}
}