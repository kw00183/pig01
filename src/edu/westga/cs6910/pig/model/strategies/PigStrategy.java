package edu.westga.cs6910.pig.model.strategies;

/**
 * Interface for the pig strategy with rollAgain method that accepts three
 * parameters
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public interface PigStrategy {

	/**
	 * Method used for strategy to accept three parameters and return a boolean
	 * true or false if the player should roll again
	 * 
	 * @param numberOfTurnRolls	the number of rolls already taken this turn
	 * @param numberOfTurnPoints	the number of points rolled so far this turn
	 * @param differenceBetweenTurnAndGoalPoints	The difference between the total points so far and the goal score
	 * @return boolean if the player should roll again, false otherwise
	 */
	boolean rollAgain(int numberOfTurnRolls, int numberOfTurnPoints,
			int differenceBetweenTurnAndGoalPoints);
}