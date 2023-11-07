package core;

import java.util.List;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Pathing for the pink ghost.
 */
public class Pinky extends Ghost {

  /**
   * Constructor for Pinky.
   */
  public Pinky() {
    return;
  }

  /**
   * Resets ghost to start position.
   */
  public void reset() {
    super.changeDirection("LEFT");
    super.setXposition(395);
    super.setYposition(290);
  }

  /**
   * Sets the path for the ghost through the map.

   * @param pinky The ghost
   * @param pinkyCollisionRectangles Collisionrectangles for the path
   */
  public void pathing(ImageView pinky, List<Rectangle> pinkyCollisionRectangles) {
    if (checkWallCollision(pinky, pinkyCollisionRectangles.get(0))) {
      changeDirection("UP");
    } else if (checkWallCollision(pinky, pinkyCollisionRectangles.get(1))) {
      changeDirection("RIGHT");
    } else if (checkWallCollision(pinky, pinkyCollisionRectangles.get(2))) {
      changeDirection("DOWN");
    } else if (checkWallCollision(pinky, pinkyCollisionRectangles.get(3))) {
      changeDirection("LEFT");
    }
  }

}