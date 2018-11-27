package towerdefense.game;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.DecimalFormat;
import java.util.ArrayList;

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
     * The time in seconds required to elapse before the rate of money gained per second
     * increases again
     */
    private static int timeBetweenRateIncreases = 10;

    /**
     * Amount of money the user currently has
     */
    private double currentMoney;

    private int ticksElapsed;

    private String moneyString;

    private StringProperty moneyStringProperty;

    private DecimalFormat df;

    /**
     * Sets up the default values for money and money generation
     */
    public MoneyHandler() {
        df = new DecimalFormat(".##");
        this.currentMoney = 500.0;
        this.ticksElapsed = 0;
        this.moneyString = "$0.00";
        this.moneyStringProperty = new SimpleStringProperty(this.moneyString);
    }

    /**
     * Updates the player's money using all of the different types of updates
     * necessary to check for
     *
     * @param towerPurchased The state of whether or not the user has bought a
     * tower since the last update
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

    public void updateMoneyString(){
        //TODO figure out why java hates me and will only print out 1 decimal place on the label
        this.moneyString = "$" + df.format(this.currentMoney);
    }

    /**
     * Updates the rate at which the user naturally generates money
     */
    public void naturalUpdateMoney() {

        if (this.ticksElapsed % 15 == 0) {
            this.currentMoney += moneyPerSecond * (1 + naturalMoneyRateIncrease);
            this.ticksElapsed = 0;
            //System.out.println(this.currentMoney);
        }
    }

    /**
     * Updates the rate value that determines how quickly the user naturally
     * generates money based on time survived
     *
     * @param secondsSurvived The number of seconds the user has survived for
     */
    public void naturalUpdateMoneyRateIncrease() {
        if (this.ticksElapsed >= 600){
            this.naturalMoneyRate += this.naturalMoneyRateIncrease;
            this.ticksElapsed = 0;
        }
    }

    /**
     * Gives the player a monetary bonus if they have killed an enemy since the
     * last update
     *
     * @param enemy The enemy killed since the last update, if any
     */
    public void enemyKillMoneyBonus(ArrayList<Enemy> enemies) {
        if (enemies.size() > 0) {
            for(Enemy enemy : enemies) {
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
            System.out.println(tower);
            this.currentMoney -= tower.getCost();
        }
    }

    /**
     * Determines if a tower can be bought
     *
     * @param tower The tower that the player is attempting to buy
     * @return
     */
    public boolean canBuyTower(Tower tower) {
        return this.currentMoney >= tower.getCost();
    }

    public StringProperty getMoneyAsStringProperty(){
        return this.moneyStringProperty;
    }

    public void updateStringProperty(){
        this.moneyStringProperty.setValue(this.moneyString);
    }
}
