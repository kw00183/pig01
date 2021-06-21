package edu.westga.cs6910.pig.model.strategies;

/**
 * Class for the cautious pig strategy that implements the PigStrategy interface
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class CautiousStrategy implements PigStrategy {

	@Override
	public boolean rollAgain(int numberOfTurnRolls, int numberOfTurnPoints,
			int numberOfPointsNeededForWin) {
		return false;
	}
}