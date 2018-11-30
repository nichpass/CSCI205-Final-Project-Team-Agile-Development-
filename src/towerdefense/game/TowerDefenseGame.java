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

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
	private static final Image[] ENEMY_IMAGES = new Image[]{new Image(
		"towerdefense/images/enemies/enemy_mario.png"), new Image(
															"towerdefense/images/enemies/enemy_luigi.png"), new Image(
															"towerdefense/images/enemies/enemy_peach.png")};
	private static final Image[][] TOWER_PROJECTILE_IMAGES = new Image[][]{new Image[]{new Image(
		"towerdefense/images/projectiles/projectile_drybones.png"), new Image("towerdefense/images/towers/tower_drybones.png")}, new Image[]{new Image(
		"towerdefense/images/projectiles/projectile_pipe.png"), new Image("towerdefense/images/towers/tower_pipe.png")}, new Image[]{new Image(
		"towerdefense/images/projectiles/projectile_kamek.png"), new Image("towerdefense/images/towers/tower_kamek.png")}, new Image[]{
		null,
		new Image(
		"towerdefense/images/towers/tower_thwomp.png")
	}
	};
	private static final int NUM_ROWS = 4;
	private static final int NUM_TILES_PER_ROW = 8;
	private final Difficulty difficulty;
	private Tower selectedTower = null;
	private final ArrayList<Tower> selectableTowers = new ArrayList();
	private final Enemy[] enemyTypes = new Enemy[3];
	private final Board gameBoard = new Board(NUM_ROWS, NUM_TILES_PER_ROW);
	private MoneyHandler moneyHandler;
	private SurvivalTimer survivalTimer;
	private int playerScore = 0;
	private EnemySpawner enemySpawner;

	/**
	 * Constructs a game with the given difficulty.
	 *
	 * @param difficulty the difficulty of the new game
	 */
	public TowerDefenseGame(Difficulty difficulty) {
		this.difficulty = difficulty;
		this.moneyHandler = new MoneyHandler();
		this.survivalTimer = new SurvivalTimer();
		selectableTowers.add(new Tower(new Projectile(10, 50,
													  () -> new ImageView(
															  TOWER_PROJECTILE_IMAGES[0][0])
		),
									   60, 500, 100,
									   () -> new ImageView(
											   TOWER_PROJECTILE_IMAGES[0][1])
		));
		selectableTowers.add(new Tower(new Projectile(20, 25,
													  () -> new ImageView(
															  TOWER_PROJECTILE_IMAGES[1][0])
		),
									   120, 1000, 100,
									   () -> new ImageView(
											   TOWER_PROJECTILE_IMAGES[1][1])
		));
		selectableTowers.add(new Tower(new Projectile(5, 100,
													  () -> new ImageView(
															  TOWER_PROJECTILE_IMAGES[2][0])
		),
									   30, 250, 100,
									   () -> new ImageView(
											   TOWER_PROJECTILE_IMAGES[2][1])
		));
		selectableTowers.add(new Tower(new Projectile(0, 100,
													  () -> new ImageView()
		),
									   10000, 1000, 100,
									   () -> new ImageView(
											   TOWER_PROJECTILE_IMAGES[3][1])));

		enemyTypes[0] = new Enemy(1, 10, 30, 20,
								  () -> new ImageView());
		enemyTypes[1] = new Enemy(1, 10, 30, 20,
								  () -> new ImageView());
		enemyTypes[2] = new Enemy(1, 10, 30, 20,
								  () -> new ImageView());

		//his.enemySpawner = new EnemySpawner(enemyTypes, gameBoard);
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
		gameBoard.update();
		updateMoney(Tile.getKilledEnemies(), null);
		updateTimer();
	}

	public void spawnEnemyAt(int rowIndex, double enemyDeterminant) {
		//this.enemySpawner.update(this.survivalTimer.getTimeSurvived(), rowIndex);
		this.gameBoard.spawnEnemyAtRow(new Enemy(1, 10, 30, 20,
												 () -> new ImageView(
														 ENEMY_IMAGES[0])),
									   rowIndex);
		if (enemyDeterminant < 0.3) {
			gameBoard.spawnEnemyAtRow(new Enemy(1, 10, 30, 20,
												() -> new ImageView(
														ENEMY_IMAGES[0])),
									  rowIndex);
		}
		else if (0.3 <= enemyDeterminant && enemyDeterminant < 0.6) {
			gameBoard.spawnEnemyAtRow(new Enemy(1, 10, 30, 20,
												() -> new ImageView(
														ENEMY_IMAGES[1])),
									  rowIndex);
		}
		else {
			gameBoard.spawnEnemyAtRow(new Enemy(1, 10, 30, 20,
												() -> new ImageView(
														ENEMY_IMAGES[2])),
									  rowIndex);
		}

	}

	/**
	 * Returns a Node that will allow the entire game to be drawn in one step.
	 *
	 * @return a Node that is a parent of all UI elements of the game board
	 */
	public Node getDrawableNode() {
		VBox boardNode = (VBox) gameBoard.getDrawableNode();
		for (int i = 0; i < NUM_ROWS; i++) {
			final int row = i;
			HBox rowNode = (HBox) boardNode.getChildren().get(i);
			for (int j = 0; j < NUM_TILES_PER_ROW; j++) {
				final int col = j;
				rowNode.getChildren().get(j).setOnMousePressed(
						(MouseEvent event) -> {
							tryBuyTower(row, col);
						});
			}
		}
		return boardNode;
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

	public void updateTimer() {
		this.survivalTimer.update();
	}

	public MoneyHandler getMoneyHandler() {
		return this.moneyHandler;
	}

	public SurvivalTimer getSurvivalTimer() {
		return this.survivalTimer;
	}

	public ArrayList<Tower> getSelectableTowers() {
		return selectableTowers;
	}

	public void selectTower(Tower towerToSelect) {
		if (this.selectableTowers.contains(towerToSelect)) {
			this.selectedTower = towerToSelect;
		}
	}
}
