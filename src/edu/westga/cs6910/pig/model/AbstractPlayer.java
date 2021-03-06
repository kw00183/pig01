package edu.westga.cs6910.pig.model;

import java.util.ArrayList;

/**
 * AbstractPlayer represents the shared code for the Human and Computer players
 * and defines methods
 * 
 * @author Kim Weible
 * @version Summer 2021
 */
public abstract class AbstractPlayer implements Player {
	private DicePair thePair;
	private boolean isMyTurn;
	private int total;
	private int turnTotal;
	private ArrayList<String> turnRollsList;

	/**
	 * Creates a new AbstractPlayer
	 * 
	 */
	AbstractPlayer() {
		this.thePair = new DicePair();
		this.total = 0;
		this.turnRollsList = new ArrayList<String>();
	}

	/**
	 * Method resets the turn total to 0 when a 1 is rolled by either dice
	 * 
	 * @see Player#resetTurnTotal()
	 */
	public void resetTurnTotal() {
		this.turnTotal = 0;
	}

	protected void processTurn() {
		this.thePair.rollDice();

		int die1Value = this.thePair.getDie1Value();
		int die2Value = this.thePair.getDie2Value();
		
		this.setTurnRollsList(this.getDiceValues());

		if (die1Value == 1 || die2Value == 1) {
			this.invalidRoll();
		} else {
			this.validRoll(die1Value, die2Value);
		}
	}

	private void validRoll(int die1Value, int die2Value) {
		this.turnTotal += die1Value + die2Value;
		this.total += die1Value + die2Value;
		this.isMyTurn = true;
	}

	private void invalidRoll() {
		this.total -= this.turnTotal;
		this.resetTurnTotal();
		this.isMyTurn = false;
	}
	
	/**
	 * Method builds an array list of dice pair values for the current turn
	 * 
	 * @param dicePair
	 *            the dice pair last rolled
	 */
	public void setTurnRollsList(String dicePair) {
		this.turnRollsList.add(dicePair);
	}
	
	/**
	 * Method returns the current list of dice pairs rolled this turn
	 * 
	 * @return turnRollsList
	 *            the list of dice pairs rolled this turn
	 */
	public ArrayList<String> getTurnRollsList() {
		return this.turnRollsList;
	}
	
	/**
	 * Method allows the list of dice pairs rolled to clear
	 * 
	 */
	public void resetTurnRollsList() {
		this.turnRollsList = new ArrayList<String>();
	}

	/**
	 * Method accepts boolean for isMyTurn to set the value for theComputer
	 * player
	 * 
	 * @param isMyTurn
	 *            the boolean value indicating if the player's turn is available
	 */
	public void setIsMyTurn(Boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}

	/**
	 * Method used to return the boolean value indicating if turn is available
	 * 
	 * @see Player#getIsMyTurn()
	 * @return isMyTurn the boolean value indicating if the player's turn is
	 *         available
	 */
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	/**
	 * Method used to return the current turn's score total
	 * 
	 * @see Player#getTurnTotal()
	 * @return turnTotal the total score accumulated in the current turn
	 */
	public int getTurnTotal() {
		return this.turnTotal;
	}

	/**
	 * Method used to return the player's total score for the game
	 * 
	 * @see Player#getTotal()
	 * @return total the player's total score for the game
	 */
	public int getTotal() {
		return this.total;
	}

	/**
	 * Method used to return the points needed by the player to win the game
	 * 
	 * @see Player#getPointsNeededToWin()
	 * @return the number of points needed by the player to win (ie hit the
	 *         goal)
	 */
	public int getPointsNeededToWin() {
		return Game.GOAL_SCORE - this.total;
	}

	/**
	 * Method used to return the 2 die values as a string
	 * 
	 * @see Player#getDiceValues()
	 * @return string value of 2 die
	 */
	public String getDiceValues() {
		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}
}