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
* Description: TODO fill in description for @{name}
*
* ****************************************
 */
package towerdefense.game;

import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author zachd
 */
public class MoneyHandlerTest {

	public MoneyHandlerTest() {
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
	 * Test of update method, of class MoneyHandler.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		ArrayList<Enemy> enemiesKilled = null;
		Tower towerPurchased = null;
		MoneyHandler instance = new MoneyHandler();
		instance.update(enemiesKilled, towerPurchased);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of updateMoneyString method, of class MoneyHandler.
	 */
	@Test
	public void testUpdateMoneyString() {
		System.out.println("updateMoneyString");
		MoneyHandler instance = new MoneyHandler();
		instance.updateMoneyString();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of naturalUpdateMoney method, of class MoneyHandler.
	 */
	@Test
	public void testNaturalUpdateMoney() {
		System.out.println("naturalUpdateMoney");
		MoneyHandler instance = new MoneyHandler();
		instance.naturalUpdateMoney();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of naturalUpdateMoneyRateIncrease method, of class MoneyHandler.
	 */
	@Test
	public void testNaturalUpdateMoneyRateIncrease() {
		System.out.println("naturalUpdateMoneyRateIncrease");
		MoneyHandler instance = new MoneyHandler();
		instance.naturalUpdateMoneyRateIncrease();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of enemyKillMoneyBonus method, of class MoneyHandler.
	 */
	@Test
	public void testEnemyKillMoneyBonus() {
		System.out.println("enemyKillMoneyBonus");
		ArrayList<Enemy> enemies = null;
		MoneyHandler instance = new MoneyHandler();
		instance.enemyKillMoneyBonus(enemies);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of purchaseTower method, of class MoneyHandler.
	 */
	@Test
	public void testPurchaseTower() {
		System.out.println("purchaseTower");
		Tower tower = null;
		MoneyHandler instance = new MoneyHandler();
		instance.purchaseTower(tower);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of canBuyTower method, of class MoneyHandler.
	 */
	@Test
	public void testCanBuyTower() {
		System.out.println("canBuyTower");
		Tower tower = null;
		MoneyHandler instance = new MoneyHandler();
		boolean expResult = false;
		boolean result = instance.canBuyTower(tower);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getMoneyAsStringProperty method, of class MoneyHandler.
	 */
	@Test
	public void testGetMoneyAsStringProperty() {
		System.out.println("getMoneyAsStringProperty");
		MoneyHandler instance = new MoneyHandler();
		StringProperty expResult = null;
		StringProperty result = instance.getMoneyAsStringProperty();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of updateStringProperty method, of class MoneyHandler.
	 */
	@Test
	public void testUpdateStringProperty() {
		System.out.println("updateStringProperty");
		MoneyHandler instance = new MoneyHandler();
		instance.updateStringProperty();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
