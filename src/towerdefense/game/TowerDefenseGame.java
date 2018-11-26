/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 11:10:02 AM
*
* Project: csci205_final_project
* Package: game
* File: TowerDefenseGame
* Description: TODO fill in description for TowerDefenseGame
*
* ****************************************
 */
package towerdefense.game;

import javafx.animation.AnimationTimer;

/**
 *
 * @author rsf
 */
public class TowerDefenseGame extends AnimationTimer {

    /**
     * The internal calculation-oriented width of each {@link Tile} object.
     */
    public static final int TILE_WIDTH = 1000;
    private static final int NUM_ROWS = 3;
    private static final int NUM_TILES_PER_ROW = 6;
    private final Difficulty difficulty;
    private Tower selectedTower = null;
    private final Board gameBoard = new Board(NUM_ROWS, NUM_TILES_PER_ROW);
    private int playerMoney = 0;
    private int playerScore = 0;

    /**
     * Constructs a game with the given difficulty.
     *
     * @param difficulty the difficulty of the new game
     */
    public TowerDefenseGame(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Inherited from AnimationTimer, will need to look into.
     *
     * @param now the current system time?
     */
    @Override
    public void handle(long now) {
        // TODO figure out AnimationTimer and do this (fixed 60fps tickrate)
    }

    /**
     * Checks if the player has sufficient funds to buy the tower; then,
     * assuming the player has sufficient funds, assigns the passed
     * {@link Tower} object to the {@link Tile} object at the specified index in
     * the specified {@link TileRow} object if it is not already associated with
     * a {@link Tower} object.
     *
     * @param towerToBuy the {@link Tower} to be associated with the tile
     * @param rowIndex the index of the {@link TileRow} object within which the
     * {@link Tower} object should be added
     * @param tileIndex the index of the {@link Tile} object to which the
     * {@link Tower} object should be added
     * @return true if the player has sufficient funds to buy the tower and the
     * specified {@link Tile} object did not already have a tower on it (i.e.
     * the tower was added); false otherwise
     */
    public boolean tryBuyTower(Tower towerToBuy, int rowIndex, int tileIndex) {
        return canBuyTower(towerToBuy) && gameBoard.tryAddTowerAt(towerToBuy,
                                                                  rowIndex,
                                                                  tileIndex);
    }

    private boolean canBuyTower(Tower towerToBuy) {

        if (towerToBuy.cost <= playerMoney) {

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Spawns enemies based on the current state of the game.
     */
    private void spawnEnemies() {
        //if enemy has reached end or a certain amount of time has passed spawn another enenemy
        //certain enemies depending on certain levels?
        //time??
        // TODO create and implement algorithm for spawning enemies based on list of enemies provided (add spawning frequency as attribute? relate to difficulty? need to think about before implementation
    }
}
