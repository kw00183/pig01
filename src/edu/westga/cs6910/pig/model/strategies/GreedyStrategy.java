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
	public boolean rollAgain(int numberOfTurnRolls, int numberOfTurnPoints,
			int numberOfPointsNeededForWin) {
		boolean shouldPlayerRoll = false;
		
		for (int count = 0; count < 3; count++) {
			if (numberOfTurnPoints > 0 && numberOfPointsNeededForWin > 0) {
				shouldPlayerRoll = true;
			}
		}
		return shouldPlayerRoll;
	}
}