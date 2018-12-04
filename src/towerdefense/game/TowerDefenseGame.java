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
* Description: The "model" of the MVC structure that runs single-tick updates.
*
* ****************************************
 */
package towerdefense.game;

import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A class acting as the "model" of the MVC structure. This class runs
 * single-tick updates and handles a lot of the associations to allow the game's
 * state to be appropriately displayed by the
 * {@link towerdefense.mvc.TowerDefenseUIController}.
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
	private static final Image[] ENEMY_IMAGES = new Image[]{new Image(
		"towerdefense/images/enemies/enemy_mario.png"), new Image(
															"towerdefense/images/enemies/enemy_luigi.png"), new Image(
															"towerdefense/images/enemies/enemy_peach.png")};
	private static final Image[] TOWER_IMAGES = new Image[]{new Image(
		"towerdefense/images/towers/tower_drybones.png"), new Image(
															"towerdefense/images/towers/tower_pipe.png"), new Image(
															"towerdefense/images/towers/tower_kamek.png"
															), new Image(
															"towerdefense/images/towers/tower_thwomp.png")};
	private static final Image[] PROJECTILE_IMAGES = new Image[]{new Image(
		"towerdefense/images/projectiles/projectile_drybones.png"), new Image(
																 "towerdefense/images/projectiles/projectile_pipe.png"), new Image(
																 "towerdefense/images/projectiles/projectile_kamek.png"), null};
	private int numRows;
	private final int numTilesPerRow;
	private final Board gameBoard;
	private static final int STARTING_LIVES = 10;
	private Tower selectedTower = null;
	private final ArrayList<Tower> selectableTowers = new ArrayList();
	private final Enemy[] ENEMY_TYPES = new Enemy[3];
	private final MoneyHandler moneyHandler;
	private final SurvivalTimer survivalTimer = new SurvivalTimer();
	private final SimpleIntegerProperty lives = new SimpleIntegerProperty(
			STARTING_LIVES);
	private final EnemySpawner enemySpawner;

	/**
	 * Constructs a game with the given difficulty.
	 *
	 * @param difficulty the difficulty of the new game
	 * @param numRows the number of rows in the game
	 * @param numTilesPerRow the number of rows in the game
	 */
	public TowerDefenseGame(Difficulty difficulty, int numRows,
							int numTilesPerRow) {
		this.numRows = numRows;
		this.numTilesPerRow = numTilesPerRow;
		this.moneyHandler = new MoneyHandler(difficulty);
		selectableTowers.add(new Tower(new Projectile(10, 50,
													  () -> new ImageView(
															  PROJECTILE_IMAGES[0])
		),
									   60, 500, 100,
									   () -> new ImageView(TOWER_IMAGES[0])
		));
		selectableTowers.add(new Tower(new Projectile(20, 25,
													  () -> new ImageView(
															  PROJECTILE_IMAGES[1])
		),
									   120, 1000, 100,
									   () -> new ImageView(TOWER_IMAGES[1])
		));
		selectableTowers.add(new Tower(new Projectile(5, 100,
													  () -> new ImageView(
															  PROJECTILE_IMAGES[2])
		),
									   30, 250, 100,
									   () -> new ImageView(TOWER_IMAGES[2])
		));
		selectableTowers.add(new Tower(new Projectile(0, 100,
													  () -> null
		),
									   Integer.MAX_VALUE, 1000, 100,
									   () -> new ImageView(TOWER_IMAGES[3])));

		ENEMY_TYPES[0] = new Enemy(5, 10, 50, 10,
								   () -> new ImageView(
										   ENEMY_IMAGES[0])); // Mario
		ENEMY_TYPES[1] = new Enemy(5, 15, 40, 10,
								   () -> new ImageView(
										   ENEMY_IMAGES[1])); // Luigi
		ENEMY_TYPES[2] = new Enemy(3, 20, 20, 5,
								   () -> new ImageView(
										   ENEMY_IMAGES[2])); // Peach
		this.enemySpawner = new EnemySpawner(ENEMY_TYPES);
		gameBoard = new Board(numRows, numTilesPerRow);
	}

	/**
	 * Checks if the player has sufficient funds to buy the tower; then,
	 * assuming the player has sufficient funds, assigns the passed
	 * {@link Tower} object to the {@link Tile} object at the specified index in
	 * the specified {@link TileRow} object if it is not already associated with
	 * a {@link Tower} object.
	 *
	 * @param rowIndex the index of the {@link TileRow} object within which the
	 * {@link Tower} object should be added
	 * @param tileIndex the index of the {@link Tile} object to which the
	 * {@link Tower} object should be added
	 * @return true if the player has sufficient funds to buy the tower and the
	 * specified {@link Tile} object did not already have a tower on it (i.e.
	 * the tower was added); false otherwise
	 */
	public boolean tryBuyTower(int rowIndex, int tileIndex) {
		if (this.selectedTower != null) {
			Tower towerToBuy = new Tower(this.selectedTower);
			if (canBuyTower(towerToBuy) && gameBoard.tryAddTowerAt(
					towerToBuy,
					rowIndex,
					tileIndex)) {
				moneyHandler.purchaseTower(towerToBuy);
				return true;
			}
		}
		return false;
	}

	/**
	 * Runs one game tick over the {@link Board} object associated with the
	 * game.
	 */
	public void update() {
		Tile.clearKilledEnemies();
		lives.set(STARTING_LIVES - gameBoard.getLivesLost());
		gameBoard.update();
		updateMoney(Tile.getKilledEnemies(), null);
		updateTimer();
	}

	/**
	 * Spawns the given enemy at the given row.
	 *
	 * @param enemyToSpawn the {@link Enemy} object to be added to the game
	 * @param rowIndex the index of the {@link TileRow} object at which the
	 * enemy will be spawned
	 */
	public void spawnEnemyAt(Enemy enemyToSpawn, int rowIndex) {
		gameBoard.spawnEnemyAtRow(enemyToSpawn, rowIndex);
	}

	/**
	 * Returns a Node that will allow the entire game to be drawn in one step.
	 *
	 * @return a Node that is a parent of all UI elements of the game board
	 */
	public Node getDrawableNode() {
		VBox boardNode = (VBox) gameBoard.getDrawableNode();
		for (int i = 0; i < numRows; i++) {
			final int row = i;
			HBox rowNode = (HBox) boardNode.getChildren().get(i);
			for (int j = 0; j < numTilesPerRow; j++) {
				final int col = j;
				rowNode.getChildren().get(j).setOnMousePressed(
						(MouseEvent event) -> {
							tryBuyTower(row, col);
						});
			}
		}
		return boardNode;
	}

	/**
	 * Checks if tower can be bought and returns a Boolean if tower can be
	 * bought or not
	 *
	 * @param towerToBuy a tower that the user wants to buy
	 *
	 * @return true if the given tower can be purchased; false otherwise
	 */
	private boolean canBuyTower(Tower towerToBuy) {
		return moneyHandler.canBuyTower(towerToBuy);
	}

	/**
	 * Updates the {@link MoneyHandler} based off of enemies killed and towers
	 * purchased since the last update
	 *
	 * @param enemiesKilled a list of how many enemies have been killed
	 * @param towerPurchased tower the tower purchased
	 */
	public void updateMoney(ArrayList<Enemy> enemiesKilled, Tower towerPurchased) {
		this.moneyHandler.update(enemiesKilled, towerPurchased);
	}

	/**
	 * Updates the game's {@link SurvivalTimer}.
	 */
	public void updateTimer() {
		this.survivalTimer.update();
	}

	/**
	 * Returns the game's {@link MoneyHandler} (used for JavaFX bindings)
	 *
	 * @return the game's associated {@link MoneyHandler} object
	 */
	public MoneyHandler getMoneyHandler() {
		return this.moneyHandler;
	}

	/**
	 * Returns the game's {@link SurvivalTimer} (used for JavaFX bindings)
	 *
	 * @return the game's associated {@link SurvivalTimer} object
	 */
	public SurvivalTimer getSurvivalTimer() {
		return this.survivalTimer;
	}

	/**
	 * Returns the game's {@link Tower} objects (used for JavaFX bindings)
	 *
	 * @return the game's associated {@link Tower} objects
	 */
	public ArrayList<Tower> getSelectableTowers() {
		return selectableTowers;
	}

	/**
	 * Selects a tower such that the next click on a tile will place the
	 * selected tower, if possible.
	 *
	 * @param towerToSelect the desired tower to be selected
	 */
	public void selectTower(Tower towerToSelect) {
		if (this.selectableTowers.contains(towerToSelect)) {
			this.selectedTower = towerToSelect;
		}
	}

	/**
	 * Returns the Property object associated with the number of lives
	 * remaining.
	 *
	 * @return the Property object associated with the number of lives remaining
	 */
	public SimpleIntegerProperty getLivesProperty() {
		return lives;
	}

	/**
	 * Returns whether or not the player has any lives left.
	 *
	 * @return true if the player has a nonpositive number of lives left; false
	 * otherwise
	 */
	public boolean isOver() {
		return lives.get() <= 0;
	}

	/**
	 * Tries to spawn an enemy at the given row based on the number of "seconds"
	 * that have elapsed since the start of the program (in terms of game
	 * ticks).
	 *
	 * @param index the row at which the enemy will spawn, if at all
	 */
	public void trySpawn(int index) {
		if (this.enemySpawner.shouldSpawn(survivalTimer.getSecondsSurvived())) {
			this.spawnEnemyAt(this.enemySpawner.enemyToSpawn(), index);
		}
	}

}
