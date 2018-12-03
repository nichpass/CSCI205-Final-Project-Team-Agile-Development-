package towerdefense.game;

import java.util.Random;

public class EnemySpawner {

    /**
     * The fractional increase by which the spawning will increase over the
     * updatePeriod *
     */
    private static double updateRate = 0.1;

    /**
     * The minimum amount of time that must elapse before a new enemy can be
     * spawned *
     */
    private static double updatePeriodLowerBound = 2;

    /**
     * The maximum amount of time that can elapse before a new enemy will be
     * spawned *
     */
    private static double updatePeriodUpperBound = 10;

    /**
     * The amount of time since the last enemy was spawned *
     */
    private double timeSinceLastSpawn;

    private double timeSinceLastUpdate;

    /**
     * An array of the different types of enemies that exist *
     */
    private Enemy[] enemyTypes;

    private Board gameBoard;

    //this is where the newer simpler spawner starts
    private double startSpawnChance;

    private double currentSpawnChance;

    public EnemySpawner( Board board) {
        this.timeSinceLastSpawn = 0;
        this.timeSinceLastUpdate = 0.0;
        this.gameBoard = board;
        this.startSpawnChance = 25;
        this.currentSpawnChance = startSpawnChance;
    }

    /**
     * Updates the spawn rate and potentially spawns a new enemy
     *
     * @param secondsSurvived the number of seconds that the player has survived
     * in the current game
     */
    public void update(double secondsSurvived, int index) {
        //trySpawn(secondsSurvived, index);
        //updateUpdateRate(secondsSurvived);
    }

    /**
     * Tries to spawn an enemy and returns the spawned enemy.
     *
     * @param secondsSurvived the number of seconds that the player has survived
     * in the current game
     * @return <code>null</code> if no {@link Enemy} spawns; the spawned
     * {@link Enemy} otherwise
     */
    public boolean shouldSpawn(double secondsSurvived) {

        this.currentSpawnChance = startSpawnChance + secondsSurvived / 8;
        if(this.currentSpawnChance > 100){
            this.currentSpawnChance = 100;
        }

        int randSpawnInt = new Random().nextInt(100);
        if(randSpawnInt < this.currentSpawnChance){
            return true;
        } else {
            return false;
        }

       /*

        this.updateRate = secondsSurvived / 1000;
        if (shouldSpawn(randSpawnInt)) {
            this.gameBoard.spawnEnemyAtRow(enemyToSpawn(), index);
            System.out.println("spawned");
            this.timeSinceLastSpawn = 0;
        }else {
            this.timeSinceLastSpawn += secondsSurvived - this.timeSinceLastUpdate;
            this.timeSinceLastUpdate = secondsSurvived;
        }
        */
    }

    /**
     * Checks how much time has passed since the last spawn: if
     * <code>timeSinceLastSpawn</code> &lt; <code>updatePeriodUpperBound</code>
     * then return true, if <code>timeSinceLastSpawn</code> &lt;
     * <code>updatePeriodLowerBound</code> then return true, else there is a
     * percent chance of spawning based on <code>updateRate</code>
     *
     * @return whether or not an enemy should spawn at the current time
     */
    //public boolean shouldSpawn(int randInt) {

        /*
        if (this.timeSinceLastSpawn >= this.updatePeriodUpperBound) {
            return true;
        }
        else if (this.timeSinceLastSpawn <= this.updatePeriodLowerBound) {
            return false;
        }
        else {
            Random rand = new Random();
            int randInt = rand.nextInt(99);
            if (randInt > 30 - this.updateRate) {
                return true;
            }
            else {
                return false;
            }
        }
        */
    //}

    /**
     * Updates the rate at which spawning increases based on the amount of time
     * the player has survived.
     *
     * @param secondsSurvived the number of seconds that the player has survived
     * in the current game
     */
    public void updateUpdateRate(double secondsSurvived) {
        this.updateRate = secondsSurvived / 1000;
    }

    /**
     * Selects a random type of enemy to spawn (all enemies have equal chance of
     * being selected).
     *
     * @return the randomly selected enemy
     */
    public Enemy enemyToSpawn() {
        int randInt = new Random().nextInt(enemyTypes.length);
        return enemyTypes[randInt];
    }

}
