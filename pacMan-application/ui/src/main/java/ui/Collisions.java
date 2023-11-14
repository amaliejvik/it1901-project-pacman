package ui;

import core.PacMan;
import java.util.List;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Handles general collision-mechanics in the game.
 */
public class Collisions {

  /**
   * if PacMan collides with a wall in the list, movement stops, e.g. dx and dy
   * are set to 0.
   * PacMan's position bounces back 3px from the wall to ensure PacMan does not
   * stop in a wall.
   *
   * @param pacManImage PacMan-image
   * @param walls       list of all walls on map
   * @return boolean if PacMan has collided with wall, false if no collision
   */
  public static boolean pacManWallCollision(ImageView pacManImage, List<Rectangle> walls) {
    for (Rectangle wall : walls) {

      if (pacManImage.getBoundsInParent().intersects(wall.getBoundsInParent())) {
        if (PacMan.getDx() == 1) {
          PacMan.setXposition(PacMan.getXposition() - 3);
        } else if (PacMan.getDx() == -1) {
          PacMan.setXposition(PacMan.getXposition() + 3);
        } else if (PacMan.getDy() == 1) {
          PacMan.setYposition(PacMan.getYposition() - 3);
        } else if (PacMan.getDy() == -1) {
          PacMan.setYposition(PacMan.getYposition() + 3);
        }
        return true;
      }
    }
    return false;
  }

  /**
   * Tests if PacMan collides with a spesific wall.
   *
   * @param pacManImage PacMan-image
   * @param wall        A wall in the map
   * @return boolean if PacMan has collided with wall, false if no collision
   */
  public static boolean pacManWallCollision(ImageView pacManImage, Rectangle wall) {
    if (pacManImage.getBoundsInParent().intersects(wall.getBoundsInParent()) && wall.isVisible()) {
      return true;
    }
    return false;
  }

  /**
   * When PacMan collides with a pellet,
   * if-statement checks if pellet has already been consumed.
   * If not, user is given 10 points and pellet is set to invisible.
   *
   * @param pacManImage PacMan-image
   * @param pellets     list of all pellets on map
   */
  public static boolean pacManPelletCollision(ImageView pacManImage, List<ImageView> pellets) {
    for (ImageView pellet : pellets) {
      if (pacManImage.getBoundsInParent().intersects(pellet.getBoundsInParent())
          && pellet.isVisible()) {
        pellet.setVisible(false);
        return true;
      }
    }
    return false;
  }

  /**
   * When PacMan collides with a ghost -> game over.
   *
   * @param pacManImage PacMan-image
   * @param ghosts      list of all ghosts on map
   */
  public static boolean pacManGhostCollision(ImageView pacManImage, List<ImageView> ghosts) {
    for (ImageView ghost : ghosts) {
      if (pacManImage.getBoundsInParent().intersects(ghost.getBoundsInParent())) {
        return true;
      }
    }
    return false;
  }

  /**
   * When PacMan collides with a cherry, return true.
   *
   * @param pacManImage PacMan-image
   * @param cherry      cherry-image
   */
  public static boolean pacManCherryCollision(ImageView pacManImage, ImageView cherry) {
    if (pacManImage.getBoundsInParent().intersects(cherry.getBoundsInParent())
        && cherry.isVisible()) {
      return true;
    }
    return false;
  }

}