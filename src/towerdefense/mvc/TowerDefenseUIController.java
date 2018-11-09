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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rsf
 */
public class TowerDefenseUIController
{

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

	private Stage stage;

	@FXML
	private void onEasyDifficultyLabelClick(MouseEvent event)
	{
	}

	@FXML
	private void onMediumDifficultyLabelClick(MouseEvent event)
	{
	}

	@FXML
	private void onHardDifficultyLabelClick(MouseEvent event)
	{
	}

	@FXML
	private void onMediumLabelClick(MouseEvent event)
	{
	}

	@FXML
	private void menuPlayButtonClick(ActionEvent event)
	{
	}

	@FXML
	private void menuOptionsButtonClick(ActionEvent event)
	{
	}

	@FXML
	private void menuExitButtonClick(ActionEvent event)
	{
	}

	public void setStage(Stage stage)
	{
		this.stage = stage;
	}
}
