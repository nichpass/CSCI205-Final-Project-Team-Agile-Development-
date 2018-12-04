/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Dec 3, 2018
* Time: 5:18:22 PM
*
* Project: csci205_final_project
* Package: towerdefense.game
* File: TileRowTest
* Description: 
*
* ****************************************
 */
package towerdefense.game;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author zachd
 */
public class TileRowTest extends TestCase {

	TileRow instance;

	@Before
	public void setUp() {
		instance = new TileRow();
	}

	@After
	public void tearDown() {
		instance = null;
	}

	/**
	 * Test of update method, of class TileRow.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		Enemy enemy = new Enemy(1, 1, 1, 0, null);
		instance.spawnEnemy(enemy);
		Tower tower = new Tower(new Projectile(1, 1, null), 1, 1, 1,
								null);
		instance.tryAddTowerAt(tower, 0);
		for (int i = 0; i < 726; i++) { // after 726 updates, we expect the enemy to be in collision range
			assertFalse(enemy.takeDamage(0));
			instance.update();
		}
		assertTrue(enemy.takeDamage(0));
	}
	/*
	Implicitly tested (beyond Tile update):
	- TileRow transitions
	 */

}
