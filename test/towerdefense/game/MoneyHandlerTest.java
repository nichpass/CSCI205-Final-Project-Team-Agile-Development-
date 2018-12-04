/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Dec 3, 2018
* Time: 5:18:11 PM
*
* Project: csci205_final_project
* Package: towerdefense.game
* File: MoneyHandlerTest
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
public class MoneyHandlerTest extends TestCase {

	MoneyHandler instance;

	@Before
	public void setUp() {
		instance = new MoneyHandler(Difficulty.MEDIUM);
	}

	@After
	public void tearDown() {
		instance = null;
	}

	/**
	 * Test of enemyKillMoneyBonus method, of class MoneyHandler.
	 */
	@Test
	public void testEnemyKillMoneyBonus() {
		System.out.println("enemyKillMoneyBonus");
		ArrayList<Enemy> enemies = new ArrayList();
		enemies.add(new Enemy(1, 1, 1, 1, null));
		Tower towerToBuy = new Tower(null, 0, 1, 401, null);
		assertFalse(instance.canBuyTower(towerToBuy));
		instance.update(enemies, null);
		assertTrue(instance.canBuyTower(towerToBuy));
	}
	/*
	Implicitly tested:
	- MoneyHandler buying towers
	- MoneyHandler balance initilization
	 */
}
