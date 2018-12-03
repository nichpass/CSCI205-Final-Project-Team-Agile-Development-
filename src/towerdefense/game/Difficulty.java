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
* Description: TODO fill in description for Board
*
* ****************************************
 */
package towerdefense.game;

/**
 *
 * @author zachd
 */
public enum Difficulty {

    EASY(0.75),
    MEDIUM(1.00),
    HARD(1.25);

    private final double costMultiplier;

    /**
     * Constructor for Difficulty
     *
     * @param costMultiplier
     */
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
