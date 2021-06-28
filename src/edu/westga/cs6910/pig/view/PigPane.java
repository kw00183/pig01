package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
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
 * Defines a GUI for the Pig game. This class was started by CS6910
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
	 * Creates a pane object to provide the view for the specified Game model
	 * object.
	 * 
	 * @param theGame
	 *            the domain model object representing the Pig game
	 * 
	 * @requires theGame != null
	 * @ensures the pane is displayed properly
	 */
	public PigPane(Game theGame) {
		this.theGame = theGame;

		this.pnContent = new BorderPane();

		this.addFirstPlayerChooserPane(this.theGame);

		HBox humanBox = this.buildHumanBox(this.theGame);
		this.pnContent.setLeft(humanBox);

		HBox statusBox = this.buildStatusBox(this.theGame);
		this.pnContent.setCenter(statusBox);

		HBox computerBox = this.buildComputerBox(this.theGame);
		this.pnContent.setRight(computerBox);

		VBox topBox = this.buildTopBox();
		this.pnContent.setTop(topBox);

		this.setCenter(this.pnContent);
	}
	
	private VBox buildTopBox() {
		VBox topBox = new VBox();
		HBox menuBox = this.addMenu(this.theGame);
		HBox playerBox = this.addFirstPlayerChooserPane(this.theGame);
		topBox.getChildren().addAll(menuBox, playerBox);
		return topBox;
	}

	private HBox buildHumanBox(Game theGame) {
		HBox humanBox = new HBox();
		humanBox.getStyleClass().add("pane-border");
		humanBox.setPrefWidth(150);
		this.pnHumanPlayer = new HumanPane(theGame);
		PigPane.this.pnHumanPlayer.setDisable(true);
		humanBox.getChildren().add(this.pnHumanPlayer);
		return humanBox;
	}

	private HBox buildStatusBox(Game theGame) {
		HBox statusBox = new HBox();
		statusBox.getStyleClass().add("pane-border");
		statusBox.setPrefWidth(375);
		this.pnGameInfo = new StatusPane(theGame);
		statusBox.getChildren().add(this.pnGameInfo);
		return statusBox;
	}

	private HBox buildComputerBox(Game theGame) {
		HBox computerBox = new HBox();
		computerBox.getStyleClass().add("pane-border");
		computerBox.setPrefWidth(175);
		this.pnComputerPlayer = new ComputerPane(this.theGame);
		PigPane.this.pnComputerPlayer.setDisable(true);
		computerBox.getChildren().add(this.pnComputerPlayer);
		return computerBox;
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
		Menu gameMenu = new Menu("_Game");
		gameMenu.setMnemonicParsing(true);

		MenuItem exitGameMenuItem = this.buildExitMenu();
		MenuItem newGameMenuItem = this.buildNewGameMenu();

		gameMenu.getItems().addAll(newGameMenuItem, exitGameMenuItem);
		return gameMenu;
	}

	private MenuItem buildExitMenu() {
		MenuItem exitGameMenuItem = new MenuItem();
		exitGameMenuItem.setText("E_xit");
		exitGameMenuItem.setMnemonicParsing(true);

		exitGameMenuItem.setAccelerator(
				new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));

		exitGameMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		return exitGameMenuItem;
	}

	private MenuItem buildNewGameMenu() {
		MenuItem newGameMenuItem = new MenuItem();
		newGameMenuItem.setText("_New Game");
		newGameMenuItem.setMnemonicParsing(true);

		newGameMenuItem.setAccelerator(
				new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

		newGameMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String firstPlayerLastGame = PigPane.this.theGame
						.getFirstPlayerLastGame();
				PigPane.this.theGame = new Game(new HumanPlayer("Human"),
						new ComputerPlayer(new CautiousStrategy()));

				PigPane.this.pnHumanPlayer = new HumanPane(
						PigPane.this.theGame);
				PigPane.this.pnComputerPlayer = new ComputerPane(
						PigPane.this.theGame);
				PigPane.this.pnGameInfo = new StatusPane(PigPane.this.theGame);

				if (firstPlayerLastGame.equals("")) {
					PigPane.this.resetPigPane();
				} else if (firstPlayerLastGame.equals("human")) {
					PigPane.this.resetHumanPlaysFirst(arg0);
				} else if (firstPlayerLastGame.equals("computer")) {
					PigPane.this.resetComputerPlaysFirst(arg0);
				}
			}
		});
		return newGameMenuItem;
	}
	
	private void resetComputerPlaysFirst(ActionEvent arg0) {
		HBox humanBox = PigPane.this.buildHumanBox(PigPane.this.theGame);
		PigPane.this.pnContent.setLeft(humanBox);
		
		HBox statusBox = PigPane.this.buildStatusBox(PigPane.this.theGame);
		PigPane.this.pnContent.setCenter(statusBox);
		
		HBox computerBox = PigPane.this.buildComputerBox(PigPane.this.theGame);
		PigPane.NewGamePane computerPlayer = new PigPane.NewGamePane(PigPane.this.theGame);
		computerPlayer.computerPlayerSelection(arg0);
		PigPane.this.pnContent.setRight(computerBox);
	}
	
	private void resetHumanPlaysFirst(ActionEvent arg0) {
		HBox humanBox = PigPane.this.buildHumanBox(PigPane.this.theGame);
		PigPane.NewGamePane humanPlayer = new PigPane.NewGamePane(PigPane.this.theGame);
		humanPlayer.humanPlayerSelection(arg0);
		PigPane.this.pnContent.setLeft(humanBox);
		
		HBox statusBox = PigPane.this.buildStatusBox(PigPane.this.theGame);
		PigPane.this.pnContent.setCenter(statusBox);
		
		HBox computerBox = PigPane.this.buildComputerBox(PigPane.this.theGame);
		PigPane.this.pnContent.setRight(computerBox);
	}
	
	private void resetPigPane() {
		HBox humanBox = this.buildHumanBox(this.theGame);
		this.pnContent.setLeft(humanBox);

		HBox statusBox = this.buildStatusBox(this.theGame);
		this.pnContent.setCenter(statusBox);

		HBox computerBox = this.buildComputerBox(this.theGame);
		this.pnContent.setRight(computerBox);

		VBox topBox = this.buildTopBox();
		this.pnContent.setTop(topBox);
	}

	private Menu buildStrategyMenu() {
		Menu strategyMenu = new Menu("_Strategy");
		strategyMenu.setMnemonicParsing(true);

		ToggleGroup strategyGroup = new ToggleGroup();
		RadioMenuItem cautiousStrategyMenuItem = this
				.buildCautiousStrategyRadio(strategyGroup);
		RadioMenuItem greedyStrategyMenuItem = this
				.buildGreedyStrategyRadio(strategyGroup);
		RadioMenuItem randomStrategyMenuItem = this
				.buildRandomStrategyRadio(strategyGroup);

		strategyMenu.getItems().addAll(cautiousStrategyMenuItem,
				greedyStrategyMenuItem, randomStrategyMenuItem);
		return strategyMenu;
	}

	private RadioMenuItem buildCautiousStrategyRadio(
			ToggleGroup strategyGroup) {
		RadioMenuItem cautiousStrategyMenuItem = new RadioMenuItem("_Cautious");
		cautiousStrategyMenuItem.setMnemonicParsing(true);

		cautiousStrategyMenuItem.setToggleGroup(strategyGroup);
		cautiousStrategyMenuItem.setSelected(true);
		cautiousStrategyMenuItem.setAccelerator(
				new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));

		cautiousStrategyMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				CautiousStrategy strategyCautious = new CautiousStrategy();
				PigPane.this.theGame.getComputerPlayer()
						.setStrategy(strategyCautious);
			}
		});
		return cautiousStrategyMenuItem;
	}

	private RadioMenuItem buildGreedyStrategyRadio(ToggleGroup strategyGroup) {
		RadioMenuItem greedyStrategyMenuItem = new RadioMenuItem("Gr_eedy");
		greedyStrategyMenuItem.setMnemonicParsing(true);

		greedyStrategyMenuItem.setToggleGroup(strategyGroup);
		greedyStrategyMenuItem.setAccelerator(
				new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));

		greedyStrategyMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				GreedyStrategy strategyGreedy = new GreedyStrategy();
				PigPane.this.theGame.getComputerPlayer()
						.setStrategy(strategyGreedy);
			}
		});
		return greedyStrategyMenuItem;
	}

	private RadioMenuItem buildRandomStrategyRadio(ToggleGroup strategyGroup) {
		RadioMenuItem randomStrategyMenuItem = new RadioMenuItem("_Random");
		randomStrategyMenuItem.setMnemonicParsing(true);

		randomStrategyMenuItem.setToggleGroup(strategyGroup);
		randomStrategyMenuItem.setAccelerator(
				new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));

		randomStrategyMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				RandomStrategy strategyRandom = new RandomStrategy();
				PigPane.this.theGame.getComputerPlayer()
						.setStrategy(strategyRandom);
			}
		});
		return randomStrategyMenuItem;
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
		private CheckBox checkRandomPlayer;

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

			this.radHumanPlayer = new RadioButton(
					this.theHuman.getName() + " first");
			this.radHumanPlayer.setOnAction(new HumanFirstListener());

			this.radComputerPlayer = new RadioButton(
					this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());

			this.checkRandomPlayer = new CheckBox("Select Random first");
			this.checkRandomPlayer.setOnAction(new RandomFirstListener());

			ToggleGroup radioGroup = new ToggleGroup();
			this.radHumanPlayer.setToggleGroup(radioGroup);
			this.radComputerPlayer.setToggleGroup(radioGroup);

			HBox radioBox = new HBox();
			radioBox.setSpacing(20);
			radioBox.getChildren().addAll(this.radHumanPlayer,
					this.radComputerPlayer, this.checkRandomPlayer);
			this.getChildren().add(radioBox);
		}

		private void randomPlayerSelection(ActionEvent arg0) {
			if (Math.random() < 0.5) {
				NewGamePane.ComputerFirstListener playComputer = new ComputerFirstListener();
				playComputer.handle(arg0);
			} else {
				NewGamePane.HumanFirstListener playHuman = new HumanFirstListener();
				playHuman.handle(arg0);
			}
		}

		private void computerPlayerSelection(ActionEvent arg0) {
			NewGamePane.this.radComputerPlayer.setSelected(true);
			PigPane.this.pnComputerPlayer.setDisable(false);
			PigPane.this.pnChooseFirstPlayer.setDisable(true);
			PigPane.this.theGame.setFirstPlayerLastGame("computer");
			PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
		}

		private void humanPlayerSelection(ActionEvent arg0) {
			NewGamePane.this.radHumanPlayer.setSelected(true);
			PigPane.this.pnChooseFirstPlayer.setDisable(true);
			PigPane.this.pnHumanPlayer.setDisable(false);
			PigPane.this.theGame.setFirstPlayerLastGame("human");
			PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
		}

		/**
		 * Defines the listener for random player first button.
		 */
		private class RandomFirstListener implements EventHandler<ActionEvent> {
			@Override
			/**
			 * Allows for random selection of human or computer, enables the
			 * correct PlayerPanel and starts a new game. Event handler for a
			 * click in the randomPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				NewGamePane.this.randomPlayerSelection(arg0);
			}
		}

		/**
		 * Defines the listener for computer player first button.
		 */
		private class ComputerFirstListener
				implements
					EventHandler<ActionEvent> {
			@Override
			/**
			 * Enables the ComputerPlayerPanel and starts a new game. Event
			 * handler for a click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				NewGamePane.this.computerPlayerSelection(arg0);
			}
		}

		/**
		 * Defines the listener for human player first button.
		 */
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/**
			 * Sets up user interface and starts a new game. Event handler for a
			 * click in the human player button.
			 */
			@Override
			public void handle(ActionEvent arg0) {
				NewGamePane.this.humanPlayerSelection(arg0);
			}
		}
	}
}
