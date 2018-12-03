/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Dec 3, 2018
* Time: 5:18:04 PM
*
* Project: csci205_final_project
* Package: towerdefense.game
* File: EnemySpawnerTest
* Description: TODO fill in description for @{name}
*
* ****************************************
 */
package towerdefense.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author zachd
 */
public class EnemySpawnerTest {

	public EnemySpawnerTest() {
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
	 * Test of update method, of class EnemySpawner.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		double secondsSurvived = 0.0;
		EnemySpawner instance = null;
		instance.update(secondsSurvived);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of trySpawn method, of class EnemySpawner.
	 */
	@Test
	public void testTrySpawn() {
		System.out.println("trySpawn");
		double secondsSurvived = 0.0;
		EnemySpawner instance = null;
		Enemy expResult = null;
		Enemy result = instance.trySpawn(secondsSurvived);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of shouldSpawn method, of class EnemySpawner.
	 */
	@Test
	public void testShouldSpawn() {
		System.out.println("shouldSpawn");
		EnemySpawner instance = null;
		boolean expResult = false;
		boolean result = instance.shouldSpawn();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of updateUpdateRate method, of class EnemySpawner.
	 */
	@Test
	public void testUpdateUpdateRate() {
		System.out.println("updateUpdateRate");
		double secondsSurvived = 0.0;
		EnemySpawner instance = null;
		instance.updateUpdateRate(secondsSurvived);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of enemyToSpawn method, of class EnemySpawner.
	 */
	@Test
	public void testEnemyToSpawn() {
		System.out.println("enemyToSpawn");
		EnemySpawner instance = null;
		Enemy expResult = null;
		Enemy result = instance.enemyToSpawn();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
