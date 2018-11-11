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

	private int damageOnContact;
	private int movementPerTick;
	private int positionInTile;

	/**
	 *
	 */
	public Projectile(int damageOnContact, int movementPerTick, int positionInTile) {
		this.damageOnContact = damageOnContact;
		this.movementPerTick = movementPerTick;
		this.positionInTile = positionInTile;
	}

	/**
	 *
	 * @param templateProjectile
	 */
	public Projectile(Projectile templateProjectile) {

	}

	/**
	 *
	 */
	public void update() {

	}

	/**
	 *
	 * @param damagedEnemy
	 * @return
	 */
	public boolean damageEnemy(Enemy damagedEnemy) {
		damagedEnemy.takeDamage(this.damageOnContact);
		if (damagedEnemy.getHealth() <= 0){
		    return true;
        }
        return false;
	}

	/**
	 *
	 * @return
	 */
	public int getPositionInTile()
	{
		return positionInTile;
	}
}
