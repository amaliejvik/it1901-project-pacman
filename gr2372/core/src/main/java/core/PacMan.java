package core;

/**
 * Controlls the logic of collision and user-input, and the response to these
 * events.
 * Also performs username-validation.
 * 
 */
public class PacMan {

  private static double dx = 0;
  private static double dy = 0;
  private static double rotate;
  private static double xPosition = 330;
  private static double yPosition = 115;

  // Various getters and setters

  public static double getXposition() {
    return xPosition;
  }

  public static void setXposition(double x) {
    xPosition = x;
  }

  public static double getYposition() {
    return yPosition;
  }

  public static void setYposition(double y) {
    yPosition = y;
  }

  public static double getDx() {
    return dx;
  }

  public static double getDy() {
    return dy;
  }

  public static double getRotate() {
    return rotate;
  }

  public static void setDx(double x) {
    dx = x;
  }

  public static void setDy(double y) {
    dy = y;
  }

  public static void setRotate(double r) {
    rotate = r;
  }

  /**
   * Resets Pacman to start position.
   */
  public static void reset() {
    setDx(0);
    setDy(0);
    setRotate(0);
    setXposition(330);
    setYposition(115);
  }

  /**
   * Changes PacMan's direction of travel and rotation.
   * Receives key inputs from PacManApp.java.
   * Sets the static variables dx, dy and rotation which are read by the timeline
   * function in the controller.

   * @param string the direction of the corresponding arrow key typed.
   */
  public static void changeDirection(String string) {
    if (string.equals("RIGHT")) {
      dy = 0;
      dx = 1;
      rotate = 0;
    } else if (string.equals("LEFT")) {
      dy = 0;
      dx = -1;
      rotate = 1;
    } else if (string.equals("UP")) {
      dy = -1;
      dx = 0;
      rotate = 2;
    } else if (string.equals("DOWN")) {
      dy = 1;
      dx = 0;
      rotate = 3;
    }
  }

  /**
   * Translates rotation-index to degrees.
   * 0 -> right,
   * 1 -> left,
   * 2 -> up,
   * 3 -> down.

   * @return correct rotation angle corresponding to direction of travel
   */
  public static double rotationAngle() {
    if (rotate == 0) {  // RIGHT
      return 0;
    } else if (rotate == 1) {   //LEFT
      return 180;
    } else if (rotate == 2) {   // UP
      return 270;
    }
    return 90;  // DOWN
  }
}