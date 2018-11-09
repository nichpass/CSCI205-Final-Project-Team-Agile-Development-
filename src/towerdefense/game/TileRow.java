/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 11:26:58 AM
*
* Project: csci205_final_project
* Package: game
* File: TileRow
* Description: TODO fill in description for TileRow
*
* ****************************************
 */
package towerdefense.game;

import java.util.ArrayList;

/**
 *
 * @author rsf
 */
public class TileRow
{

	private ArrayList<Tile> tilesInRow = new ArrayList();
	private int livesLostInRow = 0;

	/**
	 *
	 * @param numTiles
	 */
	public TileRow(int numTiles)
	{

	}

	/**
	 *
	 */
	public void update()
	{

	}

	/**
	 *
	 * @param spawnedEnemy
	 */
	public void spawnEnemy(Enemy spawnedEnemy)
	{

	}

	// Checks the positions of enemies and returns the number of new lives that need to be lost.
	private int checkLivesLost()
	{

	}

	// Transitions any projectiles beyond the right of the tile at the given index to the start of tile at the next index.
	private ArrayList<Projectile> makeTransitionsBackward(int tileIndex)
	{

	}

	// Transitions any enemies beyond the left of the tile at the given index to the end of tile at the previous index
	private ArrayList<Enemy> makeTransitionsForward(int tileIndex)
	{

	}
}
