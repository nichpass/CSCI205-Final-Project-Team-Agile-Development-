/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 11:24:52 AM
*
* Project: csci205_final_project
* Package: game
* File: Difficulty
* Description: A simple enumerated type to store the difficulty associated with
* a given game.
*
* ****************************************
 */
package towerdefense.game;

/**
 * A simple enumerated type to store the difficulty associated with a given
 * {@link TowerDefenseGame} instance. Stores a cost multiplier so that all
 * {@link Tower} objects are that much more expensive or cheaper from the
 * perspective of the {@link MoneyHandler} object.
 *
 * @author zachd
 */
public enum Difficulty {
	/**
	 * A difficulty with a cost multiplier of 0.75, making the game easier.
	 */
	EASY(0.75),
	/**
	 * A difficulty with a cost multiplier of 1, not affecting the game's
	 * difficulty.
	 */
	MEDIUM(1.00),
	/**
	 * A difficulty with a cost multiplier of 1.25, making the game harder.
	 */
	HARD(1.25);

	private final double costMultiplier;

	private Difficulty(double costMultiplier) {
		this.costMultiplier = costMultiplier;
	}

	/**
	 * Returns the multiplier to the cost of all {@link Tower} objects that will
	 * be used when this difficulty is selected.
	 *
	 * @return the multiplier to the cost of all {@link Tower} objects that will
	 * be used when this difficulty is selected
	 */
	public double getCostMultiplier() {
		return costMultiplier;
	}
}
