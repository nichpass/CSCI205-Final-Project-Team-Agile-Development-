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

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 *
 * @author rsf
 */
public class TowerDefenseGame {

	/**
	 * The internal calculation-oriented width of each {@link Tile} object.
	 */
	public static final int TILE_SIZE = 1000;
	/**
	 * The number of pixels in the visual representation of each {@link Tile}
	 * object.
	 */
	public static final int TILE_PIXEL_SIZE = 100;
	/**
	 * The maximum number of movement increments at which a collision is
	 * detected.
	 */
	public static final int COLLISION_THRESHOLD = 50;
	private static final int NUM_ROWS = 3;
	private static final int NUM_TILES_PER_ROW = 6;
	private final Difficulty difficulty;
	private Tower selectedTower = null;
	private final Board gameBoard = new Board(NUM_ROWS, NUM_TILES_PER_ROW);
	private MoneyHandler moneyHandler;
	private SurvivalTimer survivalTimer;
	private int playerScore = 0;

	/**
	 * Constructs a game with the given difficulty.
	 *
	 * @param difficulty the difficulty of the new game
	 */
	public TowerDefenseGame(Difficulty difficulty) {
		this.difficulty = difficulty;
		this.moneyHandler = new MoneyHandler();
		this.survivalTimer = new SurvivalTimer();
	}

	/**
	 * Checks if the player has sufficient funds to buy the tower; then,
	 * assuming the player has sufficient funds, assigns the passed
	 * {@link Tower} object to the {@link Tile} object at the specified index in
	 * the specified {@link TileRow} object if it is not already associated with
	 * a {@link Tower} object.
	 *
	 * @param towerToBuy the {@link Tower} to be associated with the tile
	 * @param rowIndex   the index of the {@link TileRow} object within which the
	 *                   {@link Tower} object should be added
	 * @param tileIndex  the index of the {@link Tile} object to which the
	 *                   {@link Tower} object should be added
	 * @return true if the player has sufficient funds to buy the tower and the
	 * specified {@link Tile} object did not already have a tower on it (i.e.
	 * the tower was added); false otherwise
	 */
	public boolean tryBuyTower(Tower towerToBuy, int rowIndex, int tileIndex) {
		return canBuyTower(towerToBuy) && gameBoard.tryAddTowerAt(towerToBuy,
				rowIndex,
				tileIndex);
	}

	/**
	 * Runs one game tick over the {@link Board} object associated with the
	 * game.
	 */
	public void update() {
		Tile.clearKilledEnemies();
		gameBoard.update();
		updateMoney(Tile.getKilledEnemies(), null);
		updateTimer();
	}

	public void spawnEnemyAt(int rowIndex) {
		gameBoard.spawnEnemyAtRow(new Enemy(1, 10, 30, 10,
						() -> new Rectangle(10, 30,
								Color.RED)),
				rowIndex
		);
	}

	/**
	 * Returns a Node that will allow the entire game to be drawn in one step.
	 *
	 * @return a Node that is a parent of all UI elements of the game board
	 */
	public Node getDrawableNode() {
		return gameBoard.getDrawableNode();
	}

	private boolean canBuyTower(Tower towerToBuy) {
		return moneyHandler.canBuyTower(towerToBuy);
	}

	/**
	 * Spawns enemies based on the current state of the game.
	 */
	private void spawnEnemies() {
		//if enemy has reached end or a certain amount of time has passed spawn another enenemy
		//certain enemies depending on certain levels?
		//time??
		// TODO create and implement algorithm for spawning enemies based on list of enemies provided (add spawning frequency as attribute? relate to difficulty? need to think about before implementation
	}

	public void updateMoney(ArrayList<Enemy> enemiesKilled, Tower towerPurchased) {
		this.moneyHandler.update(enemiesKilled, towerPurchased);
	}

	public void updateTimer(){
		this.survivalTimer.update();
	}

	public MoneyHandler getMoneyHandler() {
		return this.moneyHandler;
	}

	public SurvivalTimer getSurvivalTimer() {
		return this.survivalTimer;
	}
}

