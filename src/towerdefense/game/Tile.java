/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 11:31:39 AM
*
* Project: csci205_final_project
* Package: game
* File: Tile
* Description: TODO fill in description for Tile
*
* ****************************************
 */
package towerdefense.game;

import java.util.ArrayList;

/**
 *
 * @author rsf
 */
public class Tile {

	private Tower tower;
	private ArrayList<Projectile> projectiles = new ArrayList();
	private ArrayList<Enemy> enemies = new ArrayList();

	/**
	 *
	 */
	public Tile() {
		this.tower = null;
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
	public ArrayList<Enemy> popEnemies() {
        ArrayList<Enemy> temp = this.enemies;
        this.enemies.clear();
        return temp;
    }

	/**
	 *
	 * @return
	 */
	public ArrayList<Projectile> popProjectiles() {
	    ArrayList<Projectile> temp = this.projectiles;
	    this.projectiles.clear();
		return temp;
		//TODO: I'm assuming that this method is supposed to pop off all the proctiles based on the name and method type
        // TODO: I'm also assuming that the projectile object isn't passed by reference but idk if that's true
	}

	/**
	 *
	 * @param enemies
	 */
	public void pushEnemies(ArrayList<Enemy> enemies)
	{
	    this.enemies.addAll(enemies);
	}

	/**
	 *
	 * @param projectiles
	 */
	public void pushProjectiles(ArrayList<Projectile> projectiles)
	{
        this.projectiles.addAll(projectiles);
	}

	private void handleCollisions()
	{

	}

	private void trySpawnProjectile()
	{

	}
}
