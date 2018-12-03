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
* Description: TODO fill in description for @{name}
*
* ****************************************
 */
package towerdefense.game;

import java.util.ArrayList;
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
public class TileTest {

	public TileTest() {
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
	 * Test of update method, of class Tile.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		Tile instance = new Tile();
		instance.update();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of popEnemies method, of class Tile.
	 */
	@Test
	public void testPopEnemies() {
		System.out.println("popEnemies");
		Tile instance = new Tile();
		ArrayList<Enemy> expResult = null;
		ArrayList<Enemy> result = instance.popEnemies();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of popProjectiles method, of class Tile.
	 */
	@Test
	public void testPopProjectiles() {
		System.out.println("popProjectiles");
		Tile instance = new Tile();
		ArrayList<Projectile> expResult = null;
		ArrayList<Projectile> result = instance.popProjectiles();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of pushEnemies method, of class Tile.
	 */
	@Test
	public void testPushEnemies() {
		System.out.println("pushEnemies");
		ArrayList<Enemy> enemies = null;
		Tile instance = new Tile();
		instance.pushEnemies(enemies);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of pushProjectiles method, of class Tile.
	 */
	@Test
	public void testPushProjectiles() {
		System.out.println("pushProjectiles");
		ArrayList<Projectile> projectiles = null;
		Tile instance = new Tile();
		instance.pushProjectiles(projectiles);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of tryAddTower method, of class Tile.
	 */
	@Test
	public void testTryAddTower() {
		System.out.println("tryAddTower");
		Tower towerToAdd = null;
		Tile instance = new Tile();
		boolean expResult = false;
		boolean result = instance.tryAddTower(towerToAdd);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDrawableNode method, of class Tile.
	 */
	@Test
	public void testGetDrawableNode() {
		System.out.println("getDrawableNode");
		Tile instance = new Tile();
		Node expResult = null;
		Node result = instance.getDrawableNode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getKilledEnemies method, of class Tile.
	 */
	@Test
	public void testGetKilledEnemies() {
		System.out.println("getKilledEnemies");
		ArrayList<Enemy> expResult = null;
		ArrayList<Enemy> result = Tile.getKilledEnemies();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of clearKilledEnemies method, of class Tile.
	 */
	@Test
	public void testClearKilledEnemies() {
		System.out.println("clearKilledEnemies");
		Tile.clearKilledEnemies();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
