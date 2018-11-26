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

/**
 *
 * @author rsf
 */
public class Enemy {

	private final int damagePerTick;
	private final int movementPerTick;
	private int health;
	private final int maxHealth;
	private int positionInTile = TowerDefenseGame.TILE_WIDTH;
	private double killBonus;

	/**
	 * Constructs a new enemy with the given parameters.
	 *
	 * @param damagePerTick the amount of damage that the enemy will deal each
	 * tick to a {@link Tower} object that it is adjacent to
	 * @param movementPerTick the increment of movement based on which the enemy
	 * will move each tick
	 * @param maxHealth the maximum health of the enemy
	 */
	public Enemy(int damagePerTick, int movementPerTick, int maxHealth, double killBonus) {
		this.damagePerTick = damagePerTick;
		this.movementPerTick = movementPerTick;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.killBonus = killBonus;
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
	public void updatePosition() {
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
		this.positionInTile = (this.positionInTile % TowerDefenseGame.TILE_WIDTH);
		return this.positionInTile != oldPosition;
	}

	public double getKillBonus(){
		return this.killBonus;
	}
}
