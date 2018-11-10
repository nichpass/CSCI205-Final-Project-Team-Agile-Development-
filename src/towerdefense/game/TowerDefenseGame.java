/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 11:10:02 AM
*
* Project: csci205_final_project
* Package: game
* File: TowerDefenseGame
* Description: TODO fill in description for TowerDefenseGame
*
* ****************************************
 */
package towerdefense.game;

import javafx.animation.AnimationTimer;

/**
 *
 * @author rsf
 */
public class TowerDefenseGame extends AnimationTimer
{

	/**
	 *
	 */
	public static final int TILE_WIDTH = 100;
	private Difficulty difficulty;
	private Tower selectedTower = null;
	private Board gameBoard;
	private int playerMoney = 0;
	private int playerScore = 0;

	/**
	 *
	 * @param difficulty
	 */
	public TowerDefenseGame(Difficulty difficulty)
	{
		this.difficulty = difficulty;
	}

	/**
	 *
	 * @param now
	 */
	@Override
	public void handle(long now)
	{
	}

	/**
	 *
	 * @param towerToBuy
	 * @return
	 */
	private boolean canBuyTower(Tower towerToBuy)
	{
		return true;
	}

	/**
	 *
	 */
	private void spawnEnemies()
	{

	}
}
