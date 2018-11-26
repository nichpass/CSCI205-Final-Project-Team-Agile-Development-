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

/**
 *
 * @author rsf
 */
public class Tile {

    private Tower tower;
    private ArrayList<Projectile> projectiles = new ArrayList();
    private ArrayList<Enemy> enemies = new ArrayList();

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
        // TODO update state of Tile based on rules in above documentation
    }

    /**
     * Pops all enemies that are past the beginning of the tile.
     *
     * @return an ArrayList containing all of the {@link Enemy} objects that
     * passed the left side of the tile
     */
    public ArrayList<Enemy> popEnemies() {
        // TODO pop enemies with local position < 0 and return
        return null;
    }

    /**
     * Pops all projectiles that are past the end of the tile.
     *
     * @return an ArrayList containing all of the {@link Projectile} objects
     * that passed the right side of the tile
     */
    public ArrayList<Projectile> popProjectiles() {
        // TODO pop enemies with local position > TowerDefenseGame.TILE_WIDTH and return
        return null;
    }

    /**
     * Adds the enemies from the given list to the tile and adjusts their local
     * positions to match the new tile.
     *
     * @param enemies the {@link Enemy} objects to be added to the tile
     */
    public void pushEnemies(ArrayList<Enemy> enemies) {
        this.enemies.addAll(enemies);
        for (Enemy enemy : enemies) {
            //please help me with this
            // TODO Adjust enemy position based on TowerDefenseGame.TILE_WIDTH (done in Enemy?)
        }
    }

    /**
     * Adds the projectiles from the given list to the tile and adjusts their
     * local positions to match the new tile.
     *
     * @param projectiles the {@link Projectile} objects to be added to the tile
     */
    public void pushProjectiles(ArrayList<Projectile> projectiles) {
        this.projectiles.addAll(projectiles);
        for (Projectile projectile : projectiles) {
            //please help me with this
            // TODO Adjust projectile position based on TowerDefenseGame.TILE_WIDTH (done in Projectile?)
        }
    }

    private void handleCollisions() {
        for (Projectile project : projectiles) {
            if () //TO DO: finish this
            {

            }
        }

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
}
