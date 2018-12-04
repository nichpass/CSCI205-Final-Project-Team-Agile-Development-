/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Dec 3, 2018
* Time: 5:17:58 PM
*
* Project: csci205_final_project
* Package: towerdefense.game
* File: EnemyTest
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
public class EnemyTest extends TestCase {

	Enemy instance;

	@Before
	public void setUp() {
		instance = new Enemy(1, 1, 1, 100, () -> null);
	}

	@After
	public void tearDown() {
		instance = null;
	}

	/**
	 * Test of damageTower method, of class Enemy.
	 */
	@Test
	public void testDamageTower() {
		System.out.println("damageTower");
		Tower damagedTower = new Tower(null, Integer.MAX_VALUE, 2, 0,
									   null);
		assertFalse(damagedTower.takeDamage(0));
		assertFalse(instance.damageTower(damagedTower));
		assertTrue(instance.damageTower(damagedTower));
	}
	/*
	Implicitly tested:
	- Tower taking damage
	 */
}
