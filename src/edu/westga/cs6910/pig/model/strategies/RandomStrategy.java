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
	public boolean rollAgain(int numberOfTurnRolls, int numberOfTurnPoints,
			int numberOfPointsNeededForWin) {
		boolean shouldPlayerRoll = false;
		
		if (Math.random() < 0.5 && numberOfPointsNeededForWin > 0 && numberOfTurnPoints > 0) {
			shouldPlayerRoll = true;
		}
		return shouldPlayerRoll;
	}
}