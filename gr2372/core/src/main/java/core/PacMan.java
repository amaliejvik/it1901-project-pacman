package core;

import java.util.Arrays;
import java.util.List;

/**
 * Controlls the logic of user-input in form of arrow-keys pressed, and
 * handles the response to these events in form of speed and rotation on PacMan.
 * 
 */
public class PacMan {

    private static double dx = 0;
    private static double dy = 0;
    private static String rotate = "RIGHT";
    private static double xPosition = 330;
    private static double yPosition = 115;
    private static final List<String> DIRECTIONS = Arrays.asList("RIGHT", "DOWN", "UP", "LEFT");

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

    
    public static void setDx(double x) {
      dx = x;
    }
    
    public static void setDy(double y) {
      dy = y;
    }
    
    public static String getRotate() {
        return rotate;
    }

    public static void setRotate(String direction) {
        PacMan.validateDirection(direction);
        rotate = direction;
    }

    /**
     * Resets PacMan's speed, position and rotation
     * to the default start-values
     */
    public static void reset() {
        setDx(0);
        setDy(0);
        setRotate("RIGHT");
        setXposition(330);
        setYposition(115);
    }

    /**
     * Makes sure that PacMan's direction is valid
     * Throws IllegalArgumentException if invalid
     * 
     * @param string the direction of PacMan
     */
    public static void validateDirection(String string) {
        if (!DIRECTIONS.contains(string)) {
            throw new IllegalArgumentException("Invalid direction for PacMan");
        }
    }

    /**
     * Changes PacMan's direction of travel and rotation.
     * Receives key inputs from PacManApp.java.
     * Sets the static variables dx, dy and rotation which are read by the timeline
     * function in the controller.
     * 
     * @param string the direction of the corresponding arrow key typed.
     */
    public static void changeDirection(String string) {
        setRotate(string);
        if (string.equals("RIGHT")) {
            dy = 0;
            dx = 1;
        } else if (string.equals("LEFT")) {
            dy = 0;
            dx = -1;
        } else if (string.equals("UP")) {
            dy = -1;
            dx = 0;
        } else if (string.equals("DOWN")) {
            dy = 1;
            dx = 0;
        }
    }

    /**
     * Translates rotation-direction to degrees.
     * RIGHT -> 0,
     * LEFT -> 180,
     * UP -> 270,
     * DOWN -> 90.
     * 
     * @return correct rotation angle corresponding to direction of travel
     */
    public static double rotationAngle() {
        // RIGHT
        if (rotate == "RIGHT") {
            return 0;
        }
        // LEFT
        else if (rotate == "LEFT") {
            return 180;
        }
        // UP
        else if (rotate == "UP") {
            return 270;
        }
        // DOWN
      return 90;
    }
}