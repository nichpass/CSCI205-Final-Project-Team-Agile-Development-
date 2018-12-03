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

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import towerdefense.game.Difficulty;
import towerdefense.game.Tower;
import towerdefense.game.TowerDefenseGame;

/**
 * FXML Controller class
 *
 * @author rsf
 */
public class TowerDefenseUIController extends AnimationTimer {

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
	@FXML
	private Pane centerGamePane;
	@FXML
	private Pane bottomPreviewPane;

	private Stage stage;

	private Difficulty selectedDifficulty = Difficulty.MEDIUM;

	private TowerDefenseGame game;
	private long lastFrameTime = System.nanoTime();
	private Background background;

	public TowerDefenseUIController() {
		Image image = new Image("towerdefense/images/environment/sky_sprite.jpg");
		BackgroundSize size = new BackgroundSize(100, 100, true, true, true,
												 false);
		background = new Background(new BackgroundImage(image,
														BackgroundRepeat.REPEAT,
														BackgroundRepeat.NO_REPEAT,
														BackgroundPosition.CENTER,
														size));

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
		this.currentMoneyLabel.textProperty().bind(
				this.game.getMoneyHandler().getMoneyAsStringProperty());
		this.survivalTimeLabel.textProperty().bind(
				game.getSurvivalTimer().getTimerAsStringProperty());

		menuScreen.setMouseTransparent(true);
		menuScreen.setVisible(false);
		gameScreen.setMouseTransparent(false);
		gameScreen.setVisible(true);
		for (Tower selectableTower : game.getSelectableTowers()) {
			HBox towerSelector = (HBox) selectableTower.getDrawableNode();
			towerSelector.setOnMouseClicked((MouseEvent e) -> {
				game.selectTower(selectableTower);
				deselectTowers();
				towerSelector.borderProperty().set(new Border(
						new BorderStroke(
								null, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
								BorderWidths.DEFAULT)));
			});
			((VBox) towerSelector.getChildren().get(0)).getChildren().remove(0);
			((VBox) towerSelector.getChildren().get(0)).setAlignment(Pos.CENTER);
			selectTowerBox.getChildren().add(towerSelector);
		}
		this.start();
	}

	private void deselectTowers() {
		for (Node towerNode : selectTowerBox.getChildren()) {
			((HBox) towerNode).borderProperty().set(Border.EMPTY);
		}
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

	/**
	 * Handles the constant calls from the AnimationTimer
	 *
	 * @param now the current system time, in nanoseconds
	 */
	@Override
	public void handle(long now) {
		if ((60 * (now - lastFrameTime)) / 1000000000 > 0) {
			if (new Random().nextInt(60) == 0) {
				game.spawnEnemyAt(new Random().nextInt(4),
								  new Random().nextDouble());
			}
			game.update();
			draw();
		}
		lastFrameTime += 1.0E-9 / 60;
	}

	private void draw() {
		centerGamePane.getChildren().clear();
		centerGamePane.setBackground(this.background);
		centerGamePane.getChildren().add(game.getDrawableNode());
		drawMoney();
		drawTimer();
	}

	private void drawMoney() {
		Platform.runLater(
				() -> game.getMoneyHandler().updateStringProperty());
	}

	private void drawTimer() {
		Platform.runLater(
				() -> game.getSurvivalTimer().updateStringProperty());
	}
}
