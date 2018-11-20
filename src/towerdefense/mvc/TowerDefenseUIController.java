/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 1:25:23 PM
*
* Project: csci205_final_project
* Package: mvc
* File: TowerDefenseUIController
* Description: TODO fill in description for TowerDefenseUIController
*
* ****************************************
 */
package towerdefense.mvc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import towerdefense.game.Difficulty;
import towerdefense.game.SurvivalTimer;
import towerdefense.game.TowerDefenseGame;

/**
 * FXML Controller class
 *
 * @author rsf
 */
public class TowerDefenseUIController {

	@FXML
	private BorderPane gameScreen;
	@FXML
	private Label survivalTimeLabel;
	@FXML
	private Label currentMoneyLabel;
	@FXML
	private HBox selectTowerBox;
	@FXML
	private VBox optionsScreen;
	@FXML
	private Label easyDifficultyLabel;
	@FXML
	private Label mediumDifficultyLabel;
	@FXML
	private Label hardDifficultyLabel;
	@FXML
	private VBox menuScreen;
	@FXML
	private Button menuPlayButton;
	@FXML
	private Button menuOptionsButton;
	@FXML
	private Button menuExitButton;
	@FXML
	private Button optionsBackButton;

	private Stage stage;

	private Difficulty selectedDifficulty;

	private TowerDefenseGame game;

	private SurvivalTimer survivalTimer;

	public TowerDefenseUIController(){
		this.survivalTimer = new SurvivalTimer();
		//TODO Put the update method from the SurvivalTimer object inside of the game loop
		this.survivalTimeLabel.textProperty().bind(this.survivalTimer.getTimerStringProperty());

	}

	@FXML
	private void onEasyDifficultyLabelClick(MouseEvent event) {
		this.selectedDifficulty = Difficulty.EASY;
		selectDifficultyLabel(easyDifficultyLabel);
	}

	@FXML
	private void onMediumDifficultyLabelClick(MouseEvent event) {
		this.selectedDifficulty = Difficulty.MEDIUM;
		selectDifficultyLabel(mediumDifficultyLabel);
	}

	@FXML
	private void onHardDifficultyLabelClick(MouseEvent event) {
		this.selectedDifficulty = Difficulty.HARD;
		selectDifficultyLabel(hardDifficultyLabel);
	}

	private void selectDifficultyLabel(Label selectedLabel) {
		for (Label label : new Label[]{
			easyDifficultyLabel, mediumDifficultyLabel, hardDifficultyLabel
		}) {
			if (selectedLabel.equals(label)) {
				label.borderProperty().set(new Border(new BorderStroke(
						null, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
						BorderWidths.DEFAULT)));
			}
			else {
				label.borderProperty().set(new Border(new BorderStroke(
						null, BorderStrokeStyle.NONE, CornerRadii.EMPTY,
						BorderWidths.DEFAULT)));
			}
		}
	}

	@FXML
	private void onMenuPlayButtonClick(ActionEvent event) {
		game = new TowerDefenseGame(selectedDifficulty);
		menuScreen.setMouseTransparent(true);
		menuScreen.setVisible(false);
		gameScreen.setMouseTransparent(false);
		gameScreen.setVisible(true);
	}

	@FXML
	private void onMenuOptionsButtonClick(ActionEvent event) {
		menuScreen.setMouseTransparent(true);
		menuScreen.setVisible(false);
		optionsScreen.setMouseTransparent(false);
		optionsScreen.setVisible(true);
	}

	@FXML
	private void onMenuExitButtonClick(ActionEvent event) {
		stage.close();
	}

	@FXML
	private void onOptionsBackButtonClick(ActionEvent event) {
		optionsScreen.setMouseTransparent(true);
		optionsScreen.setVisible(false);
		menuScreen.setMouseTransparent(false);
		menuScreen.setVisible(true);
	}

	/**
	 * Sets the stage of the controller for exiting purposes.
	 *
	 * @param stage the stage managed by the controller
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
