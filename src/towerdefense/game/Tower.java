/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 11:39:26 AM
*
* Project: csci205_final_project
* Package: game
* File: Tower
* Description: Tower class
*
* ****************************************
 */
package towerdefense.game;

import java.util.Objects;
import java.util.function.Supplier;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author rsf
 */
public class Tower {

	private final Projectile projectileShot;
	private final int ticksBetweenShots;
	private int ticksToNextShot;
	int health;
	private final int maxHealth;
	private Supplier<Node> drawableItemGenerator;
	private final int cost;

	/**
	 * Constructs a new tower with the given parameters.
	 *
	 * @param projectileShot the {@link Projectile} object created by the tower
	 * @param ticksBetweenShots the number of game ticks between
	 * {@link Projectile} spawns
	 * @param maxHealth the maximum health of the tower
	 * @param cost the amount of money that the tower costs
	 * @param drawableItemGenerator a function to generate a copy of the visual
	 * object representing the tower
	 */
	public Tower(Projectile projectileShot, int ticksBetweenShots, int maxHealth,
				 int cost,
				 Supplier<Node> drawableItemGenerator) {
		this.projectileShot = projectileShot;
		this.ticksBetweenShots = ticksBetweenShots;
		this.ticksToNextShot = ticksBetweenShots;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.cost = cost;
		this.drawableItemGenerator = drawableItemGenerator;
	}

	/**
	 * Constructs a new tower copied from the template tower provided
	 *
	 * @param templateTower the tower to copy
	 */
	public Tower(Tower templateTower) {
		this.projectileShot = new Projectile(templateTower.projectileShot);
		this.ticksBetweenShots = templateTower.ticksBetweenShots;
		this.ticksToNextShot = templateTower.ticksToNextShot;
		this.maxHealth = templateTower.maxHealth;
		this.health = templateTower.health;
		this.drawableItemGenerator = templateTower.drawableItemGenerator;
		this.cost = templateTower.cost;
	}

	/**
	 * Decrements the tower's {@code ticksToNextShot} attribute and returns a
	 * {@link Projectile} object if it should shoot (resetting its
	 * {@code ticksToNextShot} attribute in the process.
	 *
	 * @return null if the tower does not shoot; else the {@link Projectile}
	 * object created by the shot.
	 */
	public Projectile update() {
		this.ticksToNextShot--;
		if (this.ticksToNextShot <= 0) {
			this.ticksToNextShot = this.ticksBetweenShots;
			return new Projectile(projectileShot);
		}
		return null;
	}

	/**
	 * Decreases the tower's health by the specified amount and returns whether
	 * or not the tower is dead and should be removed from the tile.
	 *
	 * @param damageToTake the amount of damage dealt to the tower
	 * @return true if the tower dies as a result of the damage; false otherwise
	 */
	public boolean takeDamage(double damageToTake) {
		this.health -= damageToTake;
		return this.health <= 0;
	}

	/**
	 * Returns a Node that will allow the tower to be drawn in one step.
	 *
	 * @return a Node that is a parent of all UI elements of the tower
	 */
	public Node getDrawableNode() {
		HBox towerBox = new HBox();
		VBox verticalBox = new VBox();
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
		if (health < 0.4 * maxHealth) {
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
		verticalBox.getChildren().add(healthBarPane);
		verticalBox.getChildren().add(this.drawableItemGenerator.get());
		verticalBox.setLayoutX(TowerDefenseGame.TILE_PIXEL_SIZE / 2);
		verticalBox.setLayoutY(0);
		verticalBox.setAlignment(Pos.TOP_CENTER);
		verticalBox.setSpacing(TowerDefenseGame.TILE_PIXEL_SIZE / 5);
		verticalBox.setPrefHeight(TowerDefenseGame.TILE_PIXEL_SIZE);
		towerBox.setPrefWidth(TowerDefenseGame.TILE_PIXEL_SIZE);
		towerBox.getChildren().add(verticalBox);
		towerBox.setAlignment(Pos.CENTER);
		return towerBox;
	}

	public int getCost() {
		return this.cost;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Tower other = (Tower) obj;
		if (this.ticksBetweenShots != other.ticksBetweenShots) {
			return false;
		}
		if (this.ticksToNextShot != other.ticksToNextShot) {
			return false;
		}
		if (this.health != other.health) {
			return false;
		}
		if (this.maxHealth != other.maxHealth) {
			return false;
		}
		if (!Objects.equals(this.projectileShot, other.projectileShot)) {
			return false;
		}
		return true;
	}

}
