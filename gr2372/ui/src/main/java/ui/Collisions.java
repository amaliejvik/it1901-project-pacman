package ui;

import java.util.List;
import core.PacMan;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Collisions {

    /**
     * if pacman collides with a wall in the list, movement stops, e.g. dx and dy are set to 0.
     * Pacman's position bounces back 3px from the wall to ensure Pacman does not stop in a wall.
     * @param pacManImage pacman-image
     * @param walls list of all walls on map
     * @return boolean if PacMan has collided with wall, false if no collision
     */
    public static boolean PacmanWallCollision(ImageView pacManImage, List<Rectangle> walls) {
        for (Rectangle wall : walls) {

            if (pacManImage.getBoundsInParent().intersects(wall.getBoundsInParent())) {
                if (PacMan.getDX() == 1) {
                    PacMan.setXPosition(PacMan.getXPosition() - 3);
                } else if (PacMan.getDX() ==- 1) {
                    PacMan.setXPosition(PacMan.getXPosition() + 3);
                } else if (PacMan.getDY() == 1) {
                    PacMan.setYPosition(PacMan.getYPosition() - 3);
                } else if (PacMan.getDY() == -1) {
                    PacMan.setYPosition(PacMan.getYPosition() + 3);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Tests if pacman collides with a spesific wall
     * @param pacManImage pacman-image
     * @param walls A wall in the map
     * @return boolean if PacMan has collided with wall, false if no collision
     */
    public static boolean PacmanWallCollision(ImageView pacManImage, Rectangle wall) {
        if (pacManImage.getBoundsInParent().intersects(wall.getBoundsInParent()) && wall.isVisible()) {
            return true;
        }
        return false;
    }

    /**
     * When pacman collides with a pellet,
     * if-statement checks if pellet has already been consumed.
     * If not, user is given 10 points and pellet is set to invisible
     * @param pacManImage pacman-image
     * @param pellets list of all pellets on map
     */
    public static boolean PacmanPelletCollision(ImageView pacManImage, List<ImageView> pellets) {
        for (ImageView pellet : pellets) {
            if (pacManImage.getBoundsInParent().intersects(pellet.getBoundsInParent()) && pellet.isVisible()) {
                pellet.setVisible(false);
                return true;
            }
        }
        return false;
    }

    /**
     * When pacman collides with a ghost -> game over
     * @param pacManImage pacman-image
     * @param ghosts list of all ghosts on map
     */
    public static boolean PacmanGhostCollision(ImageView pacManImage, List<ImageView> ghosts) {
        for (ImageView ghost : ghosts) {
            if (pacManImage.getBoundsInParent().intersects(ghost.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    /**
     * When pacman collides with a cherry, return true
     * @param pacManImage pacman-image
     * @param cherry cherry-image
     */
    public static boolean PacmanCherryCollision(ImageView pacManImage, ImageView cherry) {
        if (pacManImage.getBoundsInParent().intersects(cherry.getBoundsInParent()) && cherry.isVisible()) {
            return true;
        }
        return false;
    }

}