/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 12:10:08 PM
*
* Project: csci205_final_project
* Package: game
* File: MoneyHandler
* Description: TODO fill in description for Enemy
*
* ****************************************
 */
package towerdefense.game;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MoneyHandler {

	/**
	 * Amount of money gained per second
	 */
	private static int moneyPerSecond = 1;

	/**
	 * Increment by which the rate of money generation increases over the time
	 * interval <code>timeBetweenRateIncreases</code>
	 */
	private static double naturalMoneyRateIncrease = 0.1;

	private static double naturalMoneyRate = 0.1;

	/**
	 * The time in seconds required to elapse before the rate of money gained
	 * per second increases again
	 */
	private static int timeBetweenRateIncreases = 10;

	/**
	 * Amount of money the user currently has
	 */
	private double currentMoney;

	private int ticksElapsed;

	private String moneyString;

	private final StringProperty moneyStringProperty;

	private final DecimalFormat df;

	private Difficulty difficulty;

	/**
	 * Sets up the default values for money and money generation
	 *
	 * @param difficulty
	 */
	public MoneyHandler(Difficulty difficulty) {
		df = new DecimalFormat(".00");
		this.currentMoney = 500.0;
		this.ticksElapsed = 0;
		this.moneyString = "$0.00";
		this.moneyStringProperty = new SimpleStringProperty(this.moneyString);
		this.difficulty = difficulty;
	}

	/**
	 * Updates the player's money using all of the different types of updates
	 * necessary to check for.
	 *
	 * @param enemiesKilled the list of enemies that have been killed since the
	 * last update
	 * @param towerPurchased the tower that the user has bought, if any, since
	 * the last update
	 */
	public void update(ArrayList<Enemy> enemiesKilled,
					   Tower towerPurchased) {
		naturalUpdateMoney();
		naturalUpdateMoneyRateIncrease();
		enemyKillMoneyBonus(enemiesKilled);
		purchaseTower(towerPurchased);

		updateMoneyString();
		this.ticksElapsed += 1;
	}

	public void updateMoneyString() {
		this.moneyString = "$" + df.format(this.currentMoney);
	}

	/**
	 * Updates the rate at which the user naturally generates money
	 */
	public void naturalUpdateMoney() {

		if (this.ticksElapsed % 15 == 0) {
			this.currentMoney += moneyPerSecond * (0.5 + naturalMoneyRateIncrease);
			this.ticksElapsed = 0;
		}
	}

	/**
	 * Updates the rate value that determines how quickly the user naturally
	 * generates money based on time survived
	 *
	 */
	public void naturalUpdateMoneyRateIncrease() {
		if (this.ticksElapsed >= 600) {
			naturalMoneyRate += naturalMoneyRateIncrease;
			this.ticksElapsed = 0;
		}
	}

	/**
	 * Gives the player a monetary bonus if they have killed an enemy since the
	 * last update
	 *
	 * @param enemies the list of enemies that died since the last update
	 */
	public void enemyKillMoneyBonus(ArrayList<Enemy> enemies) {
		if (enemies.size() > 0) {
			for (Enemy enemy : enemies) {
				this.currentMoney += enemy.getKillBonus();
			}
		}
	}

	/**
	 * Subtracts the cost of a tower from the player's money if they have bought
	 * a tower since the last update
	 *
	 * @param tower The tower attempted to purchase, if any
	 */
	public void purchaseTower(Tower tower) {
		if (tower != null && this.canBuyTower(tower)) {
			this.currentMoney -= tower.getCost() * difficulty.getCostMultiplier();
		}
	}

	/**
	 * Determines if a tower can be bought
	 *
	 * @param tower The tower that the player is attempting to buy
	 * @return true if the user can buy the tower; false otherwise
	 */
	public boolean canBuyTower(Tower tower) {
		return this.currentMoney >= tower.getCost() * difficulty.getCostMultiplier();
	}

	/**
	 * Returns the current money amount as a formatted string.
	 *
	 * @return the current money amount in a traditional money format
	 */
	public StringProperty getMoneyAsStringProperty() {
		return this.moneyStringProperty;
	}

	/**
	 * Updates the money string property to the current value of the money
	 * string.
	 */
	public void updateStringProperty() {
		this.moneyStringProperty.setValue(this.moneyString);
	}
}
