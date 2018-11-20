package towerdefense.game;

import java.util.Random;
import java.util.Set;

public class EnemySpawner {

    /** The fractional increase by which the spawning will increase over the updatePeriod **/
    private static double updateRate = 0.1;

    /** The minimum amount of time that must elapse before a new enemy can be spawned **/
    private static double updatePeriodLowerBound = 5;

    /** The maximum amount of time that can elapse before a new enemy will be spawned **/
    private static double updatePeriodUpperBound = 10;

    /** The amount of time since the last enemy was spawned **/
    private double timeSinceLastSpawn;

    /** An array of the different types of enemies that exist **/
    private Enemy[] enemyTypes;

    /** The amount of time survived (in seconds) **/
    private double survivalTime;

    public EnemySpawner(double survivalTime, Enemy[] enemyTypes){
        this.timeSinceLastSpawn = 0;
        this.survivalTime = survivalTime;
        this.enemyTypes = enemyTypes;
    }

    public Enemy trySpawn(){
        this.updateRate = this.survivalTime / 1000;
        if (shouldSpawn()){
            return enemyToSpawn();
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    public boolean shouldSpawn(){
        if (this.timeSinceLastSpawn >= this.updatePeriodUpperBound){
            return true;
        } else if(this.timeSinceLastSpawn <= this.updatePeriodLowerBound){
            return false;
        } else {
            Random rand = new Random();
            int randInt = rand.nextInt(99);
            if (randInt > 99- this.updateRate * 100){
                return true;
            } else{
                return false;
            }
        }
    }

    /**
     * Selects a random type of enemy to spawn (all enemies have equal chance of being selected)
     * @return The randomly selected enemy
     */
    public Enemy enemyToSpawn(){
        Random rand = new Random();
        int randInt = rand.nextInt(enemyTypes.length);
        return enemyTypes[randInt];
    }

}
