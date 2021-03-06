package edu.westga.cs6910.pig.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Pig game.
 * 
 * @author CS6910, Kim Weible
 * @version Summer 2021
 */
public class Game implements Observable {
	/**
	 * The goal score for the game
	 */
	public static final int GOAL_SCORE = 20;
	private String firstPlayer;
	private String currentStrategy;

	private ObjectProperty<Player> currentPlayerObject;
	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;

	private DicePair thePair;

	/**
	 * Creates a Pig Game with the specified Players and a pair of dice.
	 * 
	 * @param theComputer
	 *            the automated player
	 * @param theHuman
	 *            the human player
	 * 
	 * @require theHuman != null && theComputer != null
	 * 
	 * @ensure humanPlayer().equals(theHuman) &&
	 *         computerPlayer.equals(theComputer)
	 */
	public Game(HumanPlayer theHuman, ComputerPlayer theComputer) {
		this.theHuman = theHuman;
		this.theComputer = theComputer;

		this.firstPlayer = "";
		this.currentStrategy = "";

		this.currentPlayerObject = new SimpleObjectProperty<Player>();

		this.thePair = new DicePair();
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer
	 *            the Player who takes the first turn
	 * 
	 * @require firstPlayer != null && !firstPlayer.equals(secondPlayer)
	 * 
	 * @ensures whoseTurn().equals(firstPlayer) && firstPlayer.getTotal() == 0
	 */
	public void startNewGame(Player firstPlayer) {
		this.currentPlayerObject.setValue(firstPlayer);

		this.thePair = new DicePair();
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to take a
	 * turn. Has no effect if the game is over.
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures !whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play() {
		Player currentPlayer = this.currentPlayerObject.getValue();
		this.currentPlayerObject.getValue().takeTurn();

		this.currentPlayerObject.setValue(null);
		this.currentPlayerObject.setValue(currentPlayer);

		if (!this.currentPlayerObject.getValue().getIsMyTurn()) {
			this.hold();
			this.currentPlayerObject.getValue().resetTurnTotal();
		}
	}

	/**
	 * Notifies the game that the player is holding
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures !whoseTurn().equals(whoseTurn()@prev)
	 */
	public void hold() {
		if (!this.isGameOver()) {
			this.swapWhoseTurn();
		}

		this.isGameOver();
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}

	/**
	 * Sets a string of "human" or "computer" based on who was selected to roll
	 * first.
	 * 
	 * @param firstPlayer
	 *            track whether human or computer player started the game
	 */
	public void setFirstPlayer(String firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	/**
	 * Getter for string that tracks if the human or computer player was
	 * selected to roll first when the game started.
	 * 
	 * @return firstPlayer did the human or computer player start the game
	 */
	public String getFirstPlayer() {
		return this.firstPlayer;
	}

	/**
	 * Sets a string of "cautious", "greedy" or "random" based the current
	 * strategy selected in the menu.
	 * 
	 * @param currentStrategy
	 *            track the current strategy chosen in the menu
	 */
	public void setCurrentStrategy(String currentStrategy) {
		this.currentStrategy = currentStrategy;
	}

	/**
	 * Getter for string that tracks the current strategy chosen in the menu.
	 * 
	 * @return currentStrategy string of the the current strategy selected in
	 *         the menu
	 */
	public String getCurrentStrategy() {
		return this.currentStrategy;
	}

	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}

	/**
	 * Return whether the game is over.
	 * 
	 * @return true iff currentPlayer.getTotal() >= GOAL_SCORE
	 */
	public boolean isGameOver() {
		if (this.currentPlayerObject.getValue() == null) {
			return true;
		}

		if (this.theHuman.getTotal() >= GOAL_SCORE
				|| this.theComputer.getTotal() >= GOAL_SCORE) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the pair of dice being used in the game
	 * 
	 * @return the pair of dice
	 */
	public DicePair getDicePair() {
		return this.thePair;
	}

	/**
	 * Returns a String showing the goal score, or, if the game is over, the
	 * name of the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {
		String result = "Goal Score: " + GOAL_SCORE;
		result += System.getProperty("line.separator") + this.theHuman.getName()
				+ ": " + this.theHuman.getTotal();
		result += System.getProperty("line.separator")
				+ this.theComputer.getName() + ": "
				+ this.theComputer.getTotal();

		if (this.theHuman.getTotal() >= GOAL_SCORE) {
			return result + System.getProperty("line.separator")
					+ "Game over! Winner: " + this.theHuman.getName();
		} else if (this.theComputer.getTotal() >= GOAL_SCORE) {
			return result + System.getProperty("line.separator")
					+ "Game over! Winner: " + this.theComputer.getName();
		} else {
			return result;
		}
	}

	private void swapWhoseTurn() {
		Player currentPlayer = this.currentPlayerObject.getValue();
		if (currentPlayer.equals(this.theComputer)) {
			currentPlayer = this.theHuman;
			this.currentPlayerObject.setValue(this.getHumanPlayer());
		} else {
			currentPlayer = this.theComputer;
			this.currentPlayerObject.setValue(this.getComputerPlayer());
		}
		this.currentPlayerObject.getValue().resetTurnTotal();
	}

	@Override
	public void addListener(InvalidationListener theListener) {
		this.currentPlayerObject.addListener(theListener);
	}

	@Override
	public void removeListener(InvalidationListener theListener) {
		this.currentPlayerObject.removeListener(theListener);
	}
}