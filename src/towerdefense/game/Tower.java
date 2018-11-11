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

/**
 *
 * @author rsf
 */
public class Tower
{

	private Projectile projectileShot;
	private int maxTimeToShot;
	private int currentTimeToShot;
	private int health;
	private int maxHealth;

	/**
	 *
	 */
	public Tower(Projectile projectileShot, int maxTimeToShot, int currentTimeToShot, int health, int maxHealth) {
		this.projectileShot = projectileShot;
		this.maxTimeToShot = maxTimeToShot;
		this.currentTimeToShot = currentTimeToShot;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
	}

	/**
	 *
	 * @param templateTower
	 */
	public Tower(Tower templateTower) {
		this = templateTower;
	}

	/**
	 *
	 */
	public void update() {

	}

	/**
	 *
	 * @param damageToTake
	 * @return true if the tower dies as a result of the damage; false otherwise
	 */
	public boolean takeDamage(double damageToTake) {
		this.health -= damageToTake;
		if (this.health <= 0){
			return true;
		}
		return false;
	}

	/**
	 *
	 * @return
	 */
	public Projectile spawnProjectile() {

	}

	/**
	 *
	 * @return
	 */
	public boolean canShoot() {

	}

	public int getHealth(){ return health; }
}
