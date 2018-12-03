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
* File: ProjectileTest
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
public class ProjectileTest {

	public ProjectileTest() {
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
	 * Test of update method, of class Projectile.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		Projectile instance = null;
		instance.update();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of damageEnemy method, of class Projectile.
	 */
	@Test
	public void testDamageEnemy() {
		System.out.println("damageEnemy");
		Enemy damagedEnemy = null;
		Projectile instance = null;
		boolean expResult = false;
		boolean result = instance.damageEnemy(damagedEnemy);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPositionInTile method, of class Projectile.
	 */
	@Test
	public void testGetPositionInTile() {
		System.out.println("getPositionInTile");
		Projectile instance = null;
		int expResult = 0;
		int result = instance.getPositionInTile();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of fixPosition method, of class Projectile.
	 */
	@Test
	public void testFixPosition() {
		System.out.println("fixPosition");
		Projectile instance = null;
		boolean expResult = false;
		boolean result = instance.fixPosition();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDrawableNode method, of class Projectile.
	 */
	@Test
	public void testGetDrawableNode() {
		System.out.println("getDrawableNode");
		Projectile instance = null;
		Node expResult = null;
		Node result = instance.getDrawableNode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
