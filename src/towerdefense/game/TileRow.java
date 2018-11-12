/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 11:26:58 AM
*
* Project: csci205_final_project
* Package: game
* File: TileRow
* Description: TODO fill in description for TileRow
*
* ****************************************
 */
package towerdefense.game;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

/**
 *
 * @author rsf
 */
public class TileRow {

    private ArrayList<Tile> tilesInRow = new ArrayList();
    private int livesLostInRow = 0;

    /**
     * Constructs a row with the specified number of tiles.
     *
     * @param numTiles the number of tiles in the row
     */
    public TileRow(int numTiles) {
        for (int i = 0; i < numTiles; i++) {
            tilesInRow.add(new Tile());
        }
    }

    /**
     * Iterates over tiles in the row, moving projectiles across tiles as
     * appropriate while passing the rest of the computation onto the tile.
     */
    public void update() {
        // TODO iterate over tiles in row and transfer between tiles
    }

    /**
     * Adds an enemy to the last tile in the row.
     *
     * @param spawnedEnemy the enemy to be added
     */
    public void spawnEnemy(Enemy spawnedEnemy) {
        ArrayList<Enemy> enemy = new ArrayList();
        enemy.add(spawnedEnemy);
        tilesInRow.get(tilesInRow.size() - 1).pushEnemies(enemy);
    }

    /**
     * Assigns the passed {@link Tower} object to the {@link Tile} object at the
     * specified index if it is not already associated with a {@link Tower}
     * object.
     *
     * @param towerToAdd the {@link Tower} to be associated with the tile
     * @param tileIndex the index of the {@link Tile} to which the {@link Tower}
     * should be added
     * @return true if the {@link Tile} did not already have a tower on it (i.e.
     * the tower was added); false otherwise
     */
    public boolean tryAddTowerAt(Tower towerToAdd, int tileIndex) {
        return tilesInRow.get(tileIndex).tryAddTower(towerToAdd);
    }

    private void makeTransitionsBackward(int tileIndex) {
        // TODO Transition any projectiles beyond the right of the tile at the given index to the start of tile at the next index.
    }

    private void makeTransitionsForward(int tileIndex) {
        // TODO Transition any enemies beyond the left of the tile at the given index to the end of tile at the previous index
    }

    /**
     * Returns a Node that will allow the entire row to be drawn in one step.
     *
     * @return a Node that is a parent of all UI elements of the row
     */
    public Node getDrawableNode() {
        HBox parentHBox = new HBox();
        for (Tile tile : tilesInRow) {
            parentHBox.getChildren().add(tile.getDrawableNode());
        }
        return parentHBox;
    }
}
