package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.strategies.RandomStrategy;

/**
 * Defines a GUI for the Pig game.
 * This class was started by CS6910
 *
 * @author CS6910, Kim Weible
 * @version Summer 2021
 */
public class PigPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	
	/**
	 * Creates a pane object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param theGame	the domain model object representing the Pig game
	 * 
	 * @requires theGame != null
	 * @ensures	 the pane is displayed properly
	 */
	public PigPane(Game theGame) {
		this.theGame = theGame;
		
		this.pnContent = new BorderPane();
		
		this.addFirstPlayerChooserPane(theGame);
		
		HBox humanBox = new HBox();
		humanBox.getStyleClass().add("pane-border");
		humanBox.setPrefWidth(150);
		this.pnHumanPlayer = new HumanPane(theGame);
		PigPane.this.pnHumanPlayer.setDisable(true);
		humanBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(humanBox);
		
		HBox statusBox = new HBox();
		statusBox.getStyleClass().add("pane-border");
		statusBox.setPrefWidth(375);
		this.pnGameInfo = new StatusPane(theGame);
		statusBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(statusBox);

		HBox computerBox = new HBox();
		computerBox.getStyleClass().add("pane-border");
		computerBox.setPrefWidth(175);
		this.pnComputerPlayer = new ComputerPane(theGame);
		PigPane.this.pnComputerPlayer.setDisable(true);
		computerBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.setRight(computerBox);
		
		VBox topBox = new VBox();
		HBox menuBox = this.addMenu(theGame);
		HBox playerBox = this.addFirstPlayerChooserPane(theGame);
		topBox.getChildren().addAll(menuBox, playerBox);
		this.pnContent.setTop(topBox);

		this.setCenter(this.pnContent);
	}
	
	private HBox addMenu(Game theGame) {
		Menu gameMenu = this.buildGameMenu();
		Menu strategyMenu = this.buildStrategyMenu();
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(gameMenu, strategyMenu);
		HBox menuBox = new HBox(menuBar);
		return menuBox;
	}
	
	private Menu buildGameMenu() {
		Menu gameMenu = new Menu("Game");
		MenuItem exitGameMenuItem = new MenuItem();
		exitGameMenuItem.setText("Exit");
		exitGameMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		
		exitGameMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	System.exit(0);
            }
        });
		
		gameMenu.getItems().add(exitGameMenuItem);
		return gameMenu;
	}
	
	private Menu buildStrategyMenu() {
		Menu strategyMenu = new Menu("Strategy");
		
		MenuItem cautiousStrategyMenuItem = new MenuItem();
		cautiousStrategyMenuItem.setText("Cautious");
		cautiousStrategyMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
		
		cautiousStrategyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	CautiousStrategy strategyCautious = new CautiousStrategy();
            	PigPane.this.theGame.getComputerPlayer().setStrategy(strategyCautious);
            }
        });
		
		MenuItem greedyStrategyMenuItem = new MenuItem();
		greedyStrategyMenuItem.setText("Greedy");
		greedyStrategyMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
		
		greedyStrategyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	GreedyStrategy strategyGreedy = new GreedyStrategy();
            	PigPane.this.theGame.getComputerPlayer().setStrategy(strategyGreedy);
            }
        });
		
		MenuItem randomStrategyMenuItem = new MenuItem();
		randomStrategyMenuItem.setText("Random");
		randomStrategyMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
		
		randomStrategyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	RandomStrategy strategyRandom = new RandomStrategy();
            	PigPane.this.theGame.getComputerPlayer().setStrategy(strategyRandom);
            }
        });
		
		strategyMenu.getItems().addAll(cautiousStrategyMenuItem, greedyStrategyMenuItem, randomStrategyMenuItem);
		return strategyMenu;
	}

	private HBox addFirstPlayerChooserPane(Game theGame) {
		HBox playerBox = new HBox();
		playerBox.getStyleClass().add("pane-border");	
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		playerBox.getChildren().add(this.pnChooseFirstPlayer);
		return playerBox; 
	}

	/**
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;
			
			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
		}
		
		private void buildPane() {
			this.setHgap(20);
			
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");	
			this.radHumanPlayer.setOnAction(new HumanFirstListener());

			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");	
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());
			
			ToggleGroup radioGroup = new ToggleGroup();
			this.radHumanPlayer.setToggleGroup(radioGroup);
			this.radComputerPlayer.setToggleGroup(radioGroup);
			
			HBox radioBox = new HBox();
			radioBox.setSpacing(20);
			radioBox.getChildren().addAll(this.radHumanPlayer, this.radComputerPlayer);
			this.getChildren().add(radioBox);
		}
		
		/** 
		 * Defines the listener for computer player first button.
		 */		
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/** 
			 * Enables the ComputerPlayerPanel and starts a new game. 
			 * Event handler for a click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				PigPane.this.pnComputerPlayer.setDisable(false);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		/** 
		 * Defines the listener for human player first button.
		 */	
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/** 
			 * Sets up user interface and starts a new game. 
			 * Event handler for a click in the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.pnHumanPlayer.setDisable(false);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
			}
		}
	}
}
