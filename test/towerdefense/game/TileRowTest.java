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
public class TileRowTest {

	public TileRowTest() {
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
	 * Test of update method, of class TileRow.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		TileRow instance = null;
		instance.update();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of spawnEnemy method, of class TileRow.
	 */
	@Test
	public void testSpawnEnemy() {
		System.out.println("spawnEnemy");
		Enemy spawnedEnemy = null;
		TileRow instance = null;
		instance.spawnEnemy(spawnedEnemy);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDrawableNode method, of class TileRow.
	 */
	@Test
	public void testGetDrawableNode() {
		System.out.println("getDrawableNode");
		TileRow instance = null;
		Node expResult = null;
		Node result = instance.getDrawableNode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of tryAddTowerAt method, of class TileRow.
	 */
	@Test
	public void testTryAddTowerAt() {
		System.out.println("tryAddTowerAt");
		Tower towerToAdd = null;
		int tileIndex = 0;
		TileRow instance = null;
		boolean expResult = false;
		boolean result = instance.tryAddTowerAt(towerToAdd, tileIndex);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
