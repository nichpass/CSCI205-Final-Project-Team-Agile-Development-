package towerdefense.game;

public class Money {

    /** Amount of money gained per second */
    private static int moneyPerSecond = 1;

    /** Increment by which the rate of money generation increases over the time interval
     *  <code>timeBetweenRateIncreases</code> */
    private static double naturalMoneyRateIncrease = 0.0;

    /** The time required to elapse before the rate of money gained per second increases again */
    private static int timeBetweenRateIncreases = 10;

    /** The amount of money that a user gains for killing an enemy */
    private static int enemyMonetaryValue = 50;

    private static int towerMonetaryValue = 150;

    /** Amount of money the user currently has */
    private double currentMoney;

    /** The time at which the user last naturally generated money */
    private double lastMoneyGenerationTime;

    /** The amount of time since the user last naturally generated money */
    private double timeSinceLastMoneyGeneration;

    /**
     * Sets up the default values for money and money generation
     */
    public Money(){
        this.currentMoney = 0.0;
        this.lastMoneyGenerationTime = System.nanoTime() * 1e9;
        this.timeSinceLastMoneyGeneration = 0;
    }

    /**
     * Updates the player's money using all of the different types of updates necessary to check for
     * @param secondsSurvived The number of seconds that the player has survived the game
     * @param hasKilledEnemy The state of whether or not the user has killed an enemy since the last update
     * @param hasBoughtTower The state of whether or not the user has bought a tower since the last update
     */
    public void update(double secondsSurvived, boolean hasKilledEnemy, boolean hasBoughtTower){
        naturalUpdateMoney();
        naturalUpdateMoneyRateIncrease(secondsSurvived);
        enemyKillMoneyBonus(hasKilledEnemy);
        purchaseTower(hasBoughtTower);
    }

    /**
     * Updates the rate at which the user naturally generates money
     */
    public void naturalUpdateMoney(){
        this.timeSinceLastMoneyGeneration = System.nanoTime() * 1e9 - this.lastMoneyGenerationTime;
        if (this.timeSinceLastMoneyGeneration >= 1){
            this.currentMoney += moneyPerSecond * (1 + naturalMoneyRateIncrease);
            this.lastMoneyGenerationTime = System.nanoTime() * 1e9;
        }
    }

    /**
     * Updates the rate value that determines how quickly the user naturally generates money based on time survived
     * @param secondsSurvived The number of seconds the user has survived for
     */
    public void naturalUpdateMoneyRateIncrease(double secondsSurvived){
        this.naturalMoneyRateIncrease += secondsSurvived / 1000;
    }

    /**
     * Gives the player a monetary bonus if they have killed an enemy since the last update
     * @param hasKilledEnemy The state of whether or not the user has killed an enemy
     */
    public void enemyKillMoneyBonus(boolean hasKilledEnemy){
        if(hasKilledEnemy) {
            this.currentMoney += enemyMonetaryValue;
        }
    }

    /**
     * Subtracts the cost of a tower from the player's money if they have bought a tower since the last update
     * @param hasBoughtTower The state of whether or not the user has bought a tower
     */
    public void purchaseTower(boolean hasBoughtTower){
        if(hasBoughtTower){
            this.currentMoney -= towerMonetaryValue;
        }
    }

}
