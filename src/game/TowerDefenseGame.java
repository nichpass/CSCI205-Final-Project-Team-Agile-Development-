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
package game;

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
	private double EASY_DIFFICULTY = 0.75;
	private double MEDIUM_DIFFICULTY = 1;
	private double HARD_DIFFICULTY = 1.5;
	private double activeDifficulty = MEDIUM_DIFFICULTY;
	private Tower selectedTower = null;
	private Board gameBoard;
	private int playerMoney = 0;
	private int playerScore = 0;

	/**
	 *
	 */
	public TowerDefenseGame()
	{

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

	}

	/**
	 *
	 */
	private void spawnEnemies()
	{

	}
}
