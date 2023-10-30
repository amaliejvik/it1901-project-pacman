package core;

/**
 * Controlls the logic of collision and user-input, and the response to these events.
 * Also performs username-validation.
 * 
 */
public class PacMan {

    private static double dx = 0;
    private static double dy = 0;
    private static double rotate;
    private static double xPosition = 330;
    private static double yPosition = 115;
    // private static int score;
    // private static String username;

    //Various getters and setters
    
    public static double getXPosition() {
        return xPosition;
    }
    
    public static void setXPosition(double x) {
        xPosition = x;
    }
    
    public static double getYPosition() {
        return yPosition;
    }
    
    public static void setYPosition(double y) {
        yPosition = y;
    }
    

    public static double getDX() {
        return dx;
    }

    public static double getDY() {
        return dy;
    }

    public static double getRotate() {
        return rotate;
    }

    public static void setDX(double x) {
        dx = x;
    }

    public static void setDY(double y) {
        dy = y;
    }

    public static void setRotate(double r) {
        rotate = r;
    }

    public static void reset() {
        setDX(0);
        setDY(0);
        setRotate(0);
        setXPosition(330);
        setYPosition(115);
    }

    /**
     * Changes PacMan's direction of travel and rotation.
     * Receives key inputs from PacManApp.java.
     * Sets the static variables dx, dy and rotation which are read by the timeline function in the controller.
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
        // RIGHT
        if (rotate == 0) {
            return 0;
        }
        // LEFT
        else if (rotate == 1) {
            return 180;
        }
        // UP
        else if (rotate == 2) {
            return 270;
        }
        // DOWN
        return 90;
    }
}