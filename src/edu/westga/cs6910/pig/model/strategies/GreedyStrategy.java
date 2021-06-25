package edu.westga.cs6910.pig.model.strategies;

/**
 * Class for the greedy pig strategy that implements the PigStrategy interface
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class GreedyStrategy implements PigStrategy {

	@Override
	public boolean rollAgain(int numberOfRollsTakenThisTurn, int numberOfPointsEarnedThisTurn,
			int numberOfPointsNeededToWin) {
		boolean shouldPlayerRoll = false;
		
		if (numberOfRollsTakenThisTurn < 3 && numberOfPointsNeededToWin > 0 && numberOfPointsEarnedThisTurn > 0) {
			shouldPlayerRoll = true;
		}
		return shouldPlayerRoll;
	}
}