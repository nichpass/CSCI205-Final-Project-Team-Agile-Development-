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
* File: EnemySpawner
* Description: A helper class to manage the spawning of enemies within an
* associated game.
*
* ****************************************
 */
package towerdefense.game;

import java.util.Random;

/**
 * A helper class to manage the spawning of {@link Enemy} objects within an
 * associated {@link TowerDefenseGame} object.
 *
 * @author zachd
 */
public class EnemySpawner {

	private final Enemy[] enemyTypes;

	private final double startSpawnChance = 10;

	private double currentSpawnChance = startSpawnChance;

	/**
	 * Initializes the EnemySpawner to spawn the given enemies at equal
	 * priority.
	 *
	 * @param enemyTypes the possible enemies to spawn
	 */
	public EnemySpawner(Enemy[] enemyTypes) {
		this.enemyTypes = enemyTypes;
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
		if (this.currentSpawnChance > 100) {
			this.currentSpawnChance = 100;
		}
		int randSpawnInt = new Random().nextInt(100);
		if (randSpawnInt < this.currentSpawnChance) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Selects a random type of enemy to spawn (all enemies have equal chance of
	 * being selected).
	 *
	 * @return the randomly selected {@link Enemy} object.
	 */
	public Enemy enemyToSpawn() {
		int randInt = new Random().nextInt(enemyTypes.length);
		return new Enemy(enemyTypes[randInt]);
	}

}
