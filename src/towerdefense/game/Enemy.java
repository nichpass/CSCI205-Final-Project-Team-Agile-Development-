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

	private int damagePerTick;
	private int movementPerTick;
	private int health;
	private int maxHealth;
	private int positionInTile;

	/**
	 *
	 */
	public Enemy(int damagePerTick, int movementPerTick, int maxHealth, int positionInTile) {
		this.damagePerTick = damagePerTick;
		this.movementPerTick = movementPerTick;
		this.positionInTile = positionInTile;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

	/**
	 *
	 * @param templateEnemy
	 */
	public Enemy(Enemy templateEnemy) {

    }

	/**
	 *
	 * @param damageToTake
	 * @return
	 */
	public boolean takeDamage(double damageToTake) {
        this.health -= damageToTake;
	}

	/**
	 *
	 * @param damagedTower
	 * @return
	 */
	public boolean damageTower(Tower damagedTower) {
        damagedTower.takeDamage(this.damagePerTick);
        if(damagedTower.getHealth() <= 0){
            return true;
        }
        return false;
	}

	/**
	 *
	 */
	public void update() {

	}

	/**
	 *
	 * @return
	 */
	public int getPositionInTile()
	{
		return positionInTile;
	}

	public int getHealth(){ return health; }
}
