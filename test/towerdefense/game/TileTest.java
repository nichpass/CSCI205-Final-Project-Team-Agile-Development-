/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Dec 3, 2018
* Time: 5:18:21 PM
*
* Project: csci205_final_project
* Package: towerdefense.game
* File: TileTest
* Description:
*
* ****************************************
 */
package towerdefense.game;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author zachd
 */
public class TileTest extends TestCase {

	Tile instance;

	@Before
	public void setUp() {
		instance = new Tile();
	}

	@After
	public void tearDown() {
		instance = null;
	}

	/**
	 * Test of update method, of class Tile.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		Enemy enemy = new Enemy(1, 1, 1, 1, null);
		ArrayList<Enemy> enemies = new ArrayList();
		enemies.add(enemy);
		Tower tower = new Tower(new Projectile(1, 1, null), 1, 1, 0, null);
		instance.tryAddTower(tower);
		instance.pushEnemies(enemies);
		for (int i = 0; i < 226; i++) { // after 226 updates, we expect the enemy to be in collision range
			assertFalse(enemy.takeDamage(0));
			instance.update();
		}
		assertTrue(enemy.takeDamage(0));
	}

	/*
	Implicitly tested:
	- Tower projectile spawning
	- Projectile movement
	- Enemy movement
	- Projectile dealing damage
	- Enemy taking damage
	 */
}
