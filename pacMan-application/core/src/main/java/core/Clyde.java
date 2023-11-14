package core;

import java.util.List;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Pathing for the orange ghost.
 */
public class Clyde extends Ghost {

  /**
   * Constructor for Clyde.
   */
  public Clyde() {
    return;
  }

  /**
   * Resets ghost to start position.
   */
  public void reset() {
    super.changeDirection("LEFT");
    super.setXposition(768);
    super.setYposition(378);
  }

  /**
   * Sets the path for the ghost through the map.
   *
   * @param clyde                    The ghost
   * @param clydeCollisionRectangles Collisionrectangles for the path
   */
  public void pathing(ImageView clyde, List<Rectangle> clydeCollisionRectangles) {
    if (checkWallCollision(clyde, clydeCollisionRectangles.get(0))) {
      setXposition(getXposition());
      changeDirection("UP");
    } else if (checkWallCollision(clyde, clydeCollisionRectangles.get(1))) {
      setYposition(getYposition());
      changeDirection("LEFT");
    } else if (checkWallCollision(clyde, clydeCollisionRectangles.get(2))) {
      setXposition(getXposition());
      changeDirection("UP");
    } else if (checkWallCollision(clyde, clydeCollisionRectangles.get(3))) {
      setYposition(getYposition());
      changeDirection("RIGHT");
    } else if (checkWallCollision(clyde, clydeCollisionRectangles.get(4))) {
      setXposition(getXposition());
      changeDirection("UP");
    } else if (checkWallCollision(clyde, clydeCollisionRectangles.get(5))) {
      setYposition(getYposition());
      changeDirection("RIGHT");
    } else if (checkWallCollision(clyde, clydeCollisionRectangles.get(6))) {
      setXposition(getXposition());
      changeDirection("DOWN");
    } else if (checkWallCollision(clyde, clydeCollisionRectangles.get(7))) {
      setYposition(getYposition());
      changeDirection("LEFT");
    }
  }
}