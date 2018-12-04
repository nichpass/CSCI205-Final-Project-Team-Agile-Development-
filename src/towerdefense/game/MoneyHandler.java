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
* Description: A helper class to manage the different ways in which the player
* gains and spends money.
* ****************************************
 */
package towerdefense.game;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A helper class to manage the different ways in which an associated
 * {@link TowerDefenseGame} object gains and spends money.
 *
 * @author zachd
 */
public class MoneyHandler {

	private double moneyPerSecond = 0.05;
	private final double passiveMoneyRateIncrease = 0.00025;
	private double currentMoney = 400.0;
	private int ticksElapsed = 0;
	private final StringProperty moneyStringProperty = new SimpleStringProperty(
			"$0.00");
	private final DecimalFormat df = new DecimalFormat(".00");
	private final Difficulty difficulty;

	/**
	 * Sets up the default values for money and money generation.
	 *
	 * @param difficulty the difficulty of the associated
	 * {@link TowerDefenseGame}
	 */
	public MoneyHandler(Difficulty difficulty) {
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
		passiveUpdateMoney();
		passiveMoneyRateIncrease();
		enemyKillMoneyBonus(enemiesKilled);
		purchaseTower(towerPurchased);
		updateMoneyString();
		this.ticksElapsed += 1;
	}

	private void updateMoneyString() {
		this.moneyStringProperty.set("$" + df.format(this.currentMoney));
	}

	private void passiveUpdateMoney() {

		if (this.ticksElapsed % 6 == 0) {
			this.currentMoney += moneyPerSecond;
			this.ticksElapsed = 0;
		}
	}

	private void passiveMoneyRateIncrease() {
		if (this.ticksElapsed == 0) {
			moneyPerSecond += passiveMoneyRateIncrease;
			this.ticksElapsed = 0;
		}
	}

	private void enemyKillMoneyBonus(ArrayList<Enemy> enemies) {
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
}
