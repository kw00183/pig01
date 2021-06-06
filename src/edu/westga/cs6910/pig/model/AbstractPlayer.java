package edu.westga.cs6910.pig.model;

/**
 * AbstractPlayer represents the shared code for the Human and Computer players
 * and defines methods
 * 
 * @author Kim Weible
 * @version Summer 2021
 */
public abstract class AbstractPlayer {
	private DicePair thePair;
	private boolean isMyTurn;
	private int total;
	private int turnTotal;

	/**
	 * Creates a new AbstractPlayer
	 * 
	 */
	AbstractPlayer() {
		this.thePair = new DicePair();
	}

	/**
	 * Method resets the turn total to 0 when a 1 is rolled by either dice
	 * 
	 * @see Player#resetTurnTotal()
	 */
	public void resetTurnTotal() {
		this.turnTotal = 0;
	}

	protected void processTurn(String name) {
		this.thePair.rollDice();

		int die1Value = this.thePair.getDie1Value();
		int die2Value = this.thePair.getDie2Value();
		if (die1Value == 1 || die2Value == 1) {
			this.total -= this.turnTotal;
			this.isMyTurn = false;
			return;
		} else if (name.equals("Simple computer")) {
			this.turnTotal += die1Value + die2Value;
			this.total += die1Value + die2Value;
		} else {
			this.turnTotal += die1Value + die2Value;
			this.total += die1Value + die2Value;
			this.isMyTurn = true;
		}
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
	 * Method used to return the 2 die values as a string
	 * 
	 * @see Player#getDiceValues()
	 * @return string value of 2 die
	 */
	public String getDiceValues() {
		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}
}