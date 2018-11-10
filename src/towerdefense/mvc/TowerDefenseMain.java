/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 1:01:16 PM
*
* Project: csci205_final_project
* Package: mvc
* File: TowerDefenseMain
* Description: TODO fill in description for TowerDefenseMain
*
* ****************************************
 */
package towerdefense.mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author rsf
 */
public class TowerDefenseMain extends Application
{

	TowerDefenseUIController controller;

	@Override
	public void init()
	{
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(
				this.getClass().getClassLoader().getResource(
						"towerdefense/mvc/TowerDefenseUI.fxml"));

		Parent root = (Parent) loader.load();

		controller = loader.getController();
		Scene scene = new Scene(root);
		primaryStage.setOnShown((WindowEvent event) ->
		{
			controller.setStage(primaryStage);
		});
		primaryStage.setResizable(false);
		primaryStage.setTitle("Tower Defense");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

}
