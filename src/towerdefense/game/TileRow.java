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
import javafx.geometry.Pos;
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
		for (int i = 0; i < tilesInRow.size(); i++) {
			Tile currentTile = tilesInRow.get(i);
			currentTile.update();
		}
		for (int i = 0; i < tilesInRow.size(); i++) {
			makeTransitionsLeft(i);
			makeTransitionsRight(i);
		}
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
	 * Returns a Node that will allow the entire row to be drawn in one step.
	 *
	 * @return a Node that is a parent of all UI elements of the row
	 */
	public Node getDrawableNode() {
		HBox row = new HBox();
//		row.setBorder(new Border(new BorderStroke(Color.BLUE,
//												  BorderStrokeStyle.SOLID,
//												  CornerRadii.EMPTY,
//												  BorderWidths.DEFAULT)));
		for (Tile tile : tilesInRow) {
			row.getChildren().add(tile.getDrawableNode());
		}
		row.setAlignment(Pos.CENTER);
		return row;
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
	
	private void makeTransitionsRight(int tileIndex) {
		if (tileIndex == tilesInRow.size() - 1) {
			tilesInRow.get(tileIndex).popProjectiles();
		}
		else {
			tilesInRow.get(tileIndex + 1).pushProjectiles(tilesInRow.get(
					tileIndex).popProjectiles());
		}
		
	}
	
	private void makeTransitionsLeft(int tileIndex) {
		if (tileIndex == 0) {
			livesLostInRow += tilesInRow.get(tileIndex).popEnemies().size();
		}
		else {
			tilesInRow.get(tileIndex - 1).pushEnemies(
					tilesInRow.get(tileIndex).popEnemies());
		}
		
	}
}
