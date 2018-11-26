/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 12:10:08 PM
*
* Project: csci205_final_project
* Package: game
* File: Enemy
* Description: TODO fill in description for Enemy
*
* ****************************************
 */
package towerdefense.game;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author rsf
 */
public class Enemy {

	private final int damagePerTick;
	private final int movementPerTick;
	private int health;
	private final int maxHealth;
	private int positionInTile = TowerDefenseGame.TILE_SIZE;
	private final Node drawableItem = new Rectangle(10, 30, Color.RED);

	/**
	 * Constructs a new enemy with the given parameters.
	 *
	 * @param damagePerTick the amount of damage that the enemy will deal each
	 * tick to a {@link Tower} object that it is adjacent to
	 * @param movementPerTick the increment of movement based on which the enemy
	 * will move each tick
	 * @param maxHealth the maximum health of the enemy
	 */
	public Enemy(int damagePerTick, int movementPerTick, int maxHealth) {
		this.damagePerTick = damagePerTick;
		this.movementPerTick = movementPerTick;
		this.maxHealth = maxHealth;
		this.health = maxHealth;

	}

	/**
	 * Constructs a new enemy copied from the template enemy provided.
	 *
	 * @param templateEnemy the enemy to copy
	 */
	public Enemy(Enemy templateEnemy) {
		this.damagePerTick = templateEnemy.damagePerTick;
		this.movementPerTick = templateEnemy.damagePerTick;
		this.maxHealth = templateEnemy.maxHealth;
		this.health = templateEnemy.health;
	}

	/**
	 * Decreases the enemy's health by the specified amount and returns whether
	 * or not the enemy is dead and should be removed from the tile.
	 *
	 * @param damageToTake the amount of damage dealt to the enemy
	 * @return true if the enemy dies as a result of the damage; false otherwise
	 */
	public boolean takeDamage(double damageToTake) {
		this.health -= damageToTake;
		return this.health <= 0;
	}

	/**
	 * Damages the {@link Tower} parameter based on the enemy's
	 * {@code damagePerTick} attribute.
	 *
	 * @param damagedTower the tower damaged by the enemy
	 * @return true if the tower dies as a result of the damage; false otherwise
	 */
	public boolean damageTower(Tower damagedTower) {
		return damagedTower.takeDamage(this.damagePerTick);
	}

	/**
	 * Moves the enemy based on its {@code movementPerTick} attribute.
	 */
	public void update() {
		this.positionInTile -= movementPerTick;
	}

	/**
	 * Returns the enemy's current local position.
	 *
	 * @return the current position of the enemy within its parent {@link Tile}
	 * object
	 */
	public int getPositionInTile() {
		return positionInTile;
	}

	/**
	 * Adjusts the enemy's position (to be called when it leaves the current
	 * {@link Tile} object).
	 *
	 * @return true if the position required modification; false otherwise
	 */
	public boolean fixPosition() {
		int oldPosition = this.positionInTile;
		this.positionInTile = (this.positionInTile % TowerDefenseGame.TILE_SIZE);
		return this.positionInTile != oldPosition;
	}

	/**
	 * Returns a Node that will allow the enemy to be drawn in one step.
	 *
	 * @return a Node that is a parent of all UI elements of the enemy
	 */
	public Node getDrawableNode() {
		VBox enemyBox = new VBox();
		Pane healthBarPane = new Pane();
		// The dimensions of the border element
		int healthBarHeight = TowerDefenseGame.TILE_PIXEL_SIZE / 10;
		int healthBarWidth = TowerDefenseGame.TILE_PIXEL_SIZE / 5;
		Rectangle healthBarBorder = new Rectangle(healthBarWidth,
												  healthBarHeight, Color.WHITE);
		healthBarBorder.setStroke(Color.BLACK);
		// Determining color of the fill component of health bar
		Paint healthBarColor = Color.GREEN;
		if (health < 0.7 * maxHealth) {
			healthBarColor = Color.DARKGOLDENROD;
		}
		if (health < 0.3 * maxHealth) {
			healthBarColor = Color.RED;
		}
		// Creating health bar element based on previous setup
		Rectangle healthBarFill = new Rectangle();
		healthBarFill.setLayoutX(1);
		healthBarFill.setLayoutY(1);
		healthBarFill.setWidth((healthBarWidth - 2) * (health * 1.0 / maxHealth));
		healthBarFill.setHeight(healthBarHeight - 2);
		healthBarFill.setFill(healthBarColor);
		healthBarPane.getChildren().add(healthBarBorder);
		healthBarPane.getChildren().add(healthBarFill);
		enemyBox.getChildren().add(healthBarPane);
		enemyBox.getChildren().add(this.drawableItem);
		enemyBox.setLayoutX(
				this.positionInTile * 1.0 / TowerDefenseGame.TILE_SIZE * TowerDefenseGame.TILE_PIXEL_SIZE);
		enemyBox.setLayoutY(0);
		enemyBox.setAlignment(Pos.CENTER);
		enemyBox.setSpacing(20);
		enemyBox.setPrefHeight(TowerDefenseGame.TILE_PIXEL_SIZE);
		return enemyBox;
	}
}
