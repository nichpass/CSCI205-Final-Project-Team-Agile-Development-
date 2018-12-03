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
* Description: TODO fill in description for @{name}
*
* ****************************************
 */
package towerdefense.game;

import javafx.scene.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author zachd
 */
public class EnemyTest {

	public EnemyTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of takeDamage method, of class Enemy.
	 */
	@Test
	public void testTakeDamage() {
		System.out.println("takeDamage");
		double damageToTake = 0.0;
		Enemy instance = null;
		boolean expResult = false;
		boolean result = instance.takeDamage(damageToTake);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of damageTower method, of class Enemy.
	 */
	@Test
	public void testDamageTower() {
		System.out.println("damageTower");
		Tower damagedTower = null;
		Enemy instance = null;
		boolean expResult = false;
		boolean result = instance.damageTower(damagedTower);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of update method, of class Enemy.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		Tower towerOnTile = null;
		Enemy instance = null;
		boolean expResult = false;
		boolean result = instance.update(towerOnTile);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPositionInTile method, of class Enemy.
	 */
	@Test
	public void testGetPositionInTile() {
		System.out.println("getPositionInTile");
		Enemy instance = null;
		int expResult = 0;
		int result = instance.getPositionInTile();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of fixPosition method, of class Enemy.
	 */
	@Test
	public void testFixPosition() {
		System.out.println("fixPosition");
		Enemy instance = null;
		boolean expResult = false;
		boolean result = instance.fixPosition();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDrawableNode method, of class Enemy.
	 */
	@Test
	public void testGetDrawableNode() {
		System.out.println("getDrawableNode");
		Enemy instance = null;
		Node expResult = null;
		Node result = instance.getDrawableNode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getKillBonus method, of class Enemy.
	 */
	@Test
	public void testGetKillBonus() {
		System.out.println("getKillBonus");
		Enemy instance = null;
		double expResult = 0.0;
		double result = instance.getKillBonus();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
