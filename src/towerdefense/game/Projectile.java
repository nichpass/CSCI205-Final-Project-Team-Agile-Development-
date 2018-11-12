/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 11:43:26 AM
*
* Project: csci205_final_project
* Package: game
* File: Projectile
* Description: TODO fill in description for Projectile
*
* ****************************************
 */
package towerdefense.game;

/**
 *
 * @author rsf
 */
public class Projectile {

	private final int damageOnContact;
	private final int movementPerTick;
	private int positionInTile = TowerDefenseGame.TILE_WIDTH / 2;

	/**
	 * Constructs a new projectile with the given parameters.
	 *
	 * @param damageOnContact the health taken away from an {@link Enemy} object
	 * on contact
	 * @param movementPerTick the increment of movement based on which the
	 * projectile will move each tick
	 */
	public Projectile(int damageOnContact, int movementPerTick) {
		this.damageOnContact = damageOnContact;
		this.movementPerTick = movementPerTick;
	}

	/**
	 * Constructs a new projectile copied from the template projectile provided.
	 *
	 * @param templateProjectile the projectile to copy
	 */
	public Projectile(Projectile templateProjectile) {
		this.damageOnContact = templateProjectile.damageOnContact;
		this.movementPerTick = templateProjectile.movementPerTick;
	}

	/**
	 * Moves the projectile right based on its {@code movementPerTick}
	 * attribute.
	 */
	public void update() {
		this.positionInTile += movementPerTick;
	}

	/**
	 * Damages the {@link Enemy} parameter based on the projectile's
	 * {@code damageOnContact} attribute.
	 *
	 * @param damagedEnemy the enemy damaged by the projectile
	 * @return true if the enemy dies as a result of the damage; false otherwise
	 */
	public boolean damageEnemy(Enemy damagedEnemy) {
		return damagedEnemy.takeDamage(this.damageOnContact);
	}

	/**
	 * Returns the projectile's current local position.
	 *
	 * @return the current position of the projectile within its parent
	 * {@link Tile} object
	 */
	public int getPositionInTile() {
		return positionInTile;
	}

	/**
	 * Adjusts the projectile's position (to be called when it leaves the
	 * current {@link Tile} object).
	 *
	 * @return true if the position required modification; false otherwise
	 */
	public boolean fixPosition() {
		int oldPosition = this.positionInTile;
		this.positionInTile = (this.positionInTile % TowerDefenseGame.TILE_WIDTH);
		return this.positionInTile != oldPosition;
	}
}
