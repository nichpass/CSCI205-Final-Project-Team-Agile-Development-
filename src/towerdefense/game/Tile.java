/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Alison Esterow, Nick Passantino, Zach Dunbrack
* Date: Nov 9, 2018
* Time: 11:31:39 AM
*
* Project: csci205_final_project
* Package: game
* File: Tile
* Description: TODO fill in description for Tile
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author rsf
 */
public class Tile {

	private Tower tower;
	private ArrayList<Projectile> projectiles = new ArrayList();
	private ArrayList<Enemy> enemies = new ArrayList();

	private static final ArrayList<Enemy> killedEnemies = new ArrayList();

	/**
	 * Constructs a new Tile object with no {@link Tower} on it.
	 */
	public Tile() {
		this.tower = null;
	}

	/**
	 * Updates all items on the current tile with the following guidelines:
	 * <ol><li> The tower should shoot if its <li> Enemies should move left
	 * unless making contact with a tower, at which point they should attack the
	 * tower and remain stationary;
	 * </li><li>Projectiles should move right </li><li> Collisions should be
	 * checked to ensure that no projectiles need to be destroyed due to contact
	 * with an enemy.</li></ol>
	 */
	public void update() {
		trySpawnProjectile();
		checkCollisions();
		for (Projectile projectile : projectiles) {
			projectile.update();
		}
		checkCollisions();
		for (Enemy enemy : enemies) {
			if (enemy.update(tower)) {
				tower = null;
			}
		}
		checkCollisions();
	}

	/**
	 * Pops all enemies that are past the beginning of the tile.
	 *
	 * @return an ArrayList containing all of the {@link Enemy} objects that
	 * passed the left side of the tile
	 */
	public ArrayList<Enemy> popEnemies() {
		ArrayList<Enemy> poppedEnemies = new ArrayList<>();
		for (Enemy enemy : enemies) {
			if (enemy.fixPosition()) {
				poppedEnemies.add(enemy);
			}
		}
		this.enemies.removeAll(poppedEnemies);
		return poppedEnemies;
	}

	/**
	 * Pops all projectiles that are past the end of the tile.
	 *
	 * @return an ArrayList containing all of the {@link Projectile} objects
	 * that passed the right side of the tile
	 */
	public ArrayList<Projectile> popProjectiles() {
		ArrayList<Projectile> poppedProjectiles = new ArrayList();
		for (Projectile projectile : projectiles) {
			if (projectile.fixPosition()) {
				poppedProjectiles.add(projectile);
			}
		}
		this.projectiles.removeAll(poppedProjectiles);
		return poppedProjectiles;
	}

	/**
	 * Adds the enemies from the given list to the tile and adjusts their local
	 * positions to match the new tile.
	 *
	 * @param enemies the {@link Enemy} objects to be added to the tile
	 */
	public void pushEnemies(ArrayList<Enemy> enemies) {
		this.enemies.addAll(enemies);
		ArrayList<Projectile> collidedProjectiles = new ArrayList();
		for (Projectile projectile : projectiles) {
			ArrayList<Enemy> justKilledEnemies = new ArrayList();
			for (Enemy enemy : enemies) {
				if (enemy.getPositionInTile() <= projectile.getPositionInTile()) {
					collidedProjectiles.add(projectile);
					if (projectile.damageEnemy(enemy)) {
						justKilledEnemies.add(enemy);
					}
					break;
				}
			}
			enemies.removeAll(justKilledEnemies);
			Tile.killedEnemies.addAll(justKilledEnemies);
		}
		projectiles.removeAll(collidedProjectiles);
	}

	/**
	 * Adds the projectiles from the given list to the tile and adjusts their
	 * local positions to match the new tile.
	 *
	 * @param projectiles the {@link Projectile} objects to be added to the tile
	 */
	public void pushProjectiles(ArrayList<Projectile> projectiles) {
		this.projectiles.addAll(projectiles);
		ArrayList<Projectile> collidedProjectiles = new ArrayList();
		for (Projectile projectile : projectiles) {
			ArrayList<Enemy> justKilledEnemies = new ArrayList();
			for (Enemy enemy : enemies) {
				if (enemy.getPositionInTile() <= projectile.getPositionInTile()) {
					collidedProjectiles.add(projectile);
					if (projectile.damageEnemy(enemy)) {
						justKilledEnemies.add(enemy);
					}
					break;
				}
			}
			enemies.removeAll(justKilledEnemies);
			Tile.killedEnemies.addAll(justKilledEnemies);
		}
		projectiles.removeAll(collidedProjectiles);
	}

	private void checkCollisions() {
		ArrayList<Projectile> collidedProjectiles = new ArrayList();
		for (Projectile projectile : projectiles) {
			ArrayList<Enemy> justKilledEnemies = new ArrayList();
			for (Enemy enemy : enemies) {
				if (Math.abs(
						projectile.getPositionInTile() - enemy.getPositionInTile()) < TowerDefenseGame.COLLISION_THRESHOLD) {
					collidedProjectiles.add(projectile);
					if (projectile.damageEnemy(enemy)) {
						justKilledEnemies.add(enemy);
					}
					break;
				}
			}
			enemies.removeAll(justKilledEnemies);
			Tile.killedEnemies.addAll(justKilledEnemies);
		}
		projectiles.removeAll(collidedProjectiles);
	}

	/**
	 * Assigns the passed {@link Tower} object to the tile if it is not already
	 * associated with a {@link Tower} object.
	 *
	 * @param towerToAdd the {@link Tower} to be associated with the tile
	 * @return true if the tile did not already have a tower on it (i.e. the
	 * tower was added); false otherwise
	 */
	public boolean tryAddTower(Tower towerToAdd) {
		if (this.tower == null) {
			this.tower = towerToAdd;
			return true;
		}
		return false;
	}

	/**
	 * Returns a Node that will allow the entire tile to be drawn in one step.
	 *
	 * @return a Node that is a parent of all UI elements of the tile
	 */
	public Node getDrawableNode() {
		Pane tile = new Pane();
		for (Enemy enemy : enemies) {
			Node enemyNode = enemy.getDrawableNode();

			tile.getChildren().add(enemyNode);
		}
		for (Projectile projectile : projectiles) {
			tile.getChildren().add(projectile.getDrawableNode());
		}
		if (tower != null) {
			tile.getChildren().add(tower.getDrawableNode());
		}
		tile.setPrefSize(TowerDefenseGame.TILE_PIXEL_SIZE,
						 TowerDefenseGame.TILE_PIXEL_SIZE);

		tile.setBorder(new Border(new BorderStroke(Color.BLACK,
												   BorderStrokeStyle.SOLID,
												   CornerRadii.EMPTY,
												   BorderWidths.DEFAULT)));
		return tile;
	}

	private void trySpawnProjectile() {
		if (tower != null) {
			Projectile p = tower.update();
			if (p != null) {
				projectiles.add(p);
			}
		}
	}

	/**
	 * Returns the list of enemies killed on all tiles since the last update.
	 *
	 * @return the list of enemies killed on all tiles since the last update
	 */
	public static ArrayList<Enemy> getKilledEnemies() {
		return Tile.killedEnemies;
	}

	/**
	 * Clears the list of enemies killed on all tiles since the last update.
	 */
	public static void clearKilledEnemies() {
		Tile.killedEnemies.clear();
	}
}
