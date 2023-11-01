package core;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Controlls the logic of collision and the route of the ghost.
 * 
 */
public class Ghost {

    private double dx = 0;
    private double dy = 0;
    private double xPosition;
    private double yPosition;

    /*
     * Constructor for a ghost-object
     */
    public Ghost() {
        return;
    }

    // Various getters and setters

    public double getXPosition() {
        return xPosition;
    }

    public void setXPosition(double x) {
        xPosition = x;
    }

    public double getYPosition() {
        return yPosition;
    }

    public void setYPosition(double y) {
        yPosition = y;
    }

    public double getDX() {
        return dx;
    }

    public void setDX(double x) {
        dx = x;
    }

    public double getDY() {
        return dy;
    }

    public void setDY(double y) {
        dy = y;
    }

    /**
     * Changes the ghosts direction of travel.
     * Sets the variables dx and dy which are read by the timeline function in the
     * controller.
     * 
     * @param string the direction of the corresponding arrow key typed.
     */
    public void changeDirection(String string) {
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
     * Checks if ghost collides with a wall
     * Ghosts position bounces back 3px from the wall to ensure it does not stop in
     * a wall.
     * 
     * @param ghost pacman-image
     * @param wall  wall to check collision with
     * @return boolean if ghost has collided with wall, false if no collision
     */
    public boolean checkWallCollision(ImageView ghost, Rectangle wall) {
        if (ghost.getBoundsInParent().intersects(wall.getBoundsInParent())) {
            return true;
        }
        return false;
    }
}
