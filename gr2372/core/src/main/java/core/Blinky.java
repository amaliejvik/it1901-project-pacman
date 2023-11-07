package core;

import java.util.List;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Pathing for the red ghost.
 */
public class Blinky extends Ghost {

  /**
   * Constructor for Blinky.
   */
  public Blinky() {
    return;
  }

  /**
   * Resets ghost to start position.
   */
  public void reset() {
    super.changeDirection("RIGHT");
    super.setXposition(23);
    super.setYposition(32);
  }

  /**
   * Sets the path for the ghost through the map.

   * @param blinky The ghost
   * @param blinkyCollisionRectangles Collisionrectangles for the path
   */
  public void pathing(ImageView blinky, List<Rectangle> blinkyCollisionRectangles) {
    if (checkWallCollision(blinky, blinkyCollisionRectangles.get(0))) {
      changeDirection("DOWN");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(1))) {
      changeDirection("RIGHT");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(2))) {
      changeDirection("UP");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(3))) {
      changeDirection("RIGHT");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(4))) {
      changeDirection("DOWN");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(5))) {
      changeDirection("LEFT");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(6))) {
      changeDirection("UP");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(7))) {
      changeDirection("LEFT");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(8))) {
      changeDirection("DOWN");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(9))) {
      changeDirection("LEFT");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(10))) {
      changeDirection("UP");
    } else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(11))) {
      changeDirection("RIGHT");
    }
  }
}