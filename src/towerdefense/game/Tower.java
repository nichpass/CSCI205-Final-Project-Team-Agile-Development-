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
* Description: TODO fill in description for Tower
*
* ****************************************
 */
package towerdefense.game;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author rsf
 */
public class Tower {

	private final Projectile projectileShot;
	private final int ticksBetweenShots;
	private int ticksToNextShot;
	private int health;
	private final int maxHealth;
	private Node drawableItem = new Rectangle(10, 10, Color.BLACK);

	/**
	 * Constructs a new tower with the given parameters.
	 *
	 * @param projectileShot the {@link Projectile} object created by the tower
	 * @param ticksBetweenShots the number of game ticks between
	 * {@link Projectile} spawns
	 * @param maxHealth the maximum health of the tower
	 */
	public Tower(Projectile projectileShot, int ticksBetweenShots, int maxHealth) {
		this.projectileShot = projectileShot;
		this.ticksBetweenShots = ticksBetweenShots;
		this.ticksToNextShot = ticksBetweenShots;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
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
		this.drawableItem = templateTower.drawableItem;
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
		return this.drawableItem;
	}
}
