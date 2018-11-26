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
	private static double updatePeriodLowerBound = 5;

	/**
	 * The maximum amount of time that can elapse before a new enemy will be
	 * spawned *
	 */
	private static double updatePeriodUpperBound = 10;

	/**
	 * The amount of time since the last enemy was spawned *
	 */
	private double timeSinceLastSpawn;

	/**
	 * An array of the different types of enemies that exist *
	 */
	private Enemy[] enemyTypes;

	public EnemySpawner(Enemy[] enemyTypes) {
		this.timeSinceLastSpawn = 0;
		this.enemyTypes = enemyTypes;
	}

	/**
	 * Updates the spawn rate and potentially spawns a new enemy
	 *
	 * @param secondsSurvived The amount of seconds the player has survived for
	 */
	public void update(double secondsSurvived) {
		//TODO somehow get the returned enemy variable from trySpawn() back into the game to be displayed and used
		trySpawn(secondsSurvived);
		updateUpdateRate(secondsSurvived);
	}

	public Enemy trySpawn(double secondsSurvived) {
		this.updateRate = secondsSurvived / 1000;
		if (shouldSpawn()) {
			return enemyToSpawn();
		}
		else {
			return null;
		}
	}

	/**
	 * Checks how much time has passed since the last spawn: if
	 * <code>timeSinceLastSpawn</code> &lt; <code>updatePeriodUpperBound</code>
	 * then return true, if <code>timeSinceLastSpawn</code> &lt;
	 * <code>updatePeriodLowerBound</code> then return true, else there is a
	 * percent chance of spawning based on <code>updateRate</code>
	 *
	 * @return
	 */
	public boolean shouldSpawn() {
		if (this.timeSinceLastSpawn >= this.updatePeriodUpperBound) {
			return true;
		}
		else if (this.timeSinceLastSpawn <= this.updatePeriodLowerBound) {
			return false;
		}
		else {
			Random rand = new Random();
			int randInt = rand.nextInt(99);
			if (randInt > 99 - this.updateRate * 100) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	/**
	 * Updates the rate at which spawning increases based on the amount of time
	 * the player has survived
	 *
	 * @param secondsSurvived
	 */
	public void updateUpdateRate(double secondsSurvived) {
		this.updateRate = secondsSurvived / 1000;
	}

	/**
	 * Selects a random type of enemy to spawn (all enemies have equal chance of
	 * being selected)
	 *
	 * @return The randomly selected enemy
	 */
	public Enemy enemyToSpawn() {
		Random rand = new Random();
		int randInt = rand.nextInt(enemyTypes.length);
		return enemyTypes[randInt];
	}

}
