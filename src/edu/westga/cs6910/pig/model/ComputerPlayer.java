package edu.westga.cs6910.pig.model;

import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Pig. It
 * rolls exactly 1 time and then holds.
 * 
 * @author CS6910, Kim Weible
 * @version Summer 2021
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";
	private String name;
	private int maximumRolls;
	private PigStrategy strategy;

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param strategy
	 *            the strategy selected to play
	 */
	public ComputerPlayer(PigStrategy strategy) {
		this.name = NAME;
		if (strategy == null) {
			throw new IllegalArgumentException("Strategy value cannot be null");
		}
		this.strategy = strategy;
	}

	/**
	 * Method to set the strategy chosen for the computer player
	 * 
	 * @param strategy
	 *            the strategy selected to play
	 * @precondition strategy != null
	 * @postcondition strategy specified will determine how the player will play
	 */
	public void setStrategy(PigStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException(
					"Set strategy value cannot be null");
		}
		this.strategy = strategy;
	}

	/**
	 * Implements Player's setMaximumRolls, but is not normally called by client
	 * objects. Instead, clients usually call the 0-parameter version
	 * 
	 * @param maximumRolls
	 *            The maximum number of times the computer will roll before
	 *            holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		this.maximumRolls = maximumRolls;
	}

	/**
	 * Implements Player's setMaximumRolls() to set the maximum number of rolls
	 * to 1
	 * 
	 */
	public void setMaximumRolls() {
		this.maximumRolls = 1;
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public void takeTurn() {
		this.setMaximumRolls();
		boolean shouldRollAgain = false;
		int numberOfRollsTakenThisTurn = 0;

		this.processTurn();
		numberOfRollsTakenThisTurn = this.maximumRolls;

		do {
			shouldRollAgain = this.strategy.rollAgain(
					numberOfRollsTakenThisTurn, this.getTurnTotal(),
					this.getPointsNeededToWin());

			if (shouldRollAgain) {
				this.processTurn();
				numberOfRollsTakenThisTurn++;
			} else {
				this.setIsMyTurn(shouldRollAgain);
			}

		} while (shouldRollAgain && this.getIsMyTurn());
	}

	@Override
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}
}