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
* File: Board
* Description: TODO fill in description for Board
*
* ****************************************
 */
package towerdefense.game;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author rsf
 */
public class Board {

	private ArrayList<TileRow> gameRows = new ArrayList();

	/**
	 * Constructs a new board with the given number of rows and tiles per row.
	 *
	 * @param numRows the number of {@link TileRow} objects to construct
	 * @param numTilesPerRow the number of {@link Tile} objects to associate
	 * with each tile
	 */
	public Board(int numRows, int numTilesPerRow) {
		for (int i = 0; i < numRows; i++) {
			gameRows.add(new TileRow(numTilesPerRow));
		}
	}

	/**
	 * Runs one game tick across each {@link TileRow} object associated with the
	 * board.
	 */
	public void update() {
		for (TileRow row : gameRows) {
			row.update();
		}
	}

	/**
	 * Assigns the given {@link Enemy} object to the {@link Tile} at the end of
	 * the {@link TileRow} at the given index.
	 *
	 * @param spawnedEnemy the {@link Enemy} object to be spawned
	 * @param rowIndex the index of the {@link TileRow} object at which
	 * {@code spawnedEnemy} should be spawned
	 */
	public void spawnEnemyAtRow(Enemy spawnedEnemy, int rowIndex) {
		gameRows.get(rowIndex).spawnEnemy(spawnedEnemy);
	}

	/**
	 * Assigns the passed {@link Tower} object to the {@link Tile} object at the
	 * specified index in the specified {@link TileRow} object if it is not
	 * already associated with a {@link Tower} object.
	 *
	 * @param towerToAdd the {@link Tower} to be associated with the tile
	 * @param rowIndex the index of the {@link TileRow} object within which the
	 * {@link Tower} object should be added
	 * @param tileIndex the index of the {@link Tile} object to which the
	 * {@link Tower} object should be added
	 * @return true if the {@link Tile} object did not already have a tower on
	 * it (i.e. the tower was added); false otherwise
	 */
	public boolean tryAddTowerAt(Tower towerToAdd, int rowIndex, int tileIndex) {
		return gameRows.get(rowIndex).tryAddTowerAt(towerToAdd, tileIndex);
	}

	/**
	 * Returns a Node that will allow the entire board to be drawn in one step.
	 *
	 * @return a Node that is a parent of all UI elements of the board
	 */
	public Node getDrawableNode() {
		VBox rows = new VBox();
		rows.setBorder(new Border(new BorderStroke(Color.BLACK,
												   BorderStrokeStyle.SOLID,
												   CornerRadii.EMPTY,
												   BorderWidths.DEFAULT)));
		for (TileRow row : gameRows) {
			rows.getChildren().add(row.getDrawableNode());
		}
		return rows;
	}
}
