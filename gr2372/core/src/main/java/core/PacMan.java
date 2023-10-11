package core;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Controlls the logic of collision and user-input, and the response to these events.
 * Also performs username-validation.
 * 
 */
public class PacMan {

    public static double dx = 0;
    public static double dy = 0;
    public static double rotate;
    private double xPosition = 330;
    private double yPosition = 115;
    private int score;
    private String username;
    
    /*
     * Constructor for a PacMan-object
     */
    public PacMan() {
        return;
    }

    //Various getters and setters
    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getYPosition() {
        return this.yPosition;
    }

    public void setYPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
   * Input validation on username, e.g. no spaces or empty strings
   * @param name username from player
   * @return true if the username is valid, else false
   */
    public boolean validateUsername(String name) {
        if (name.contains(" ")) {
        return false;
        } else if (name == "") {
        return false;
        } else if (name.length() <= 2) {
        return false;
        }
        return true;
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
        }
        else if(string.equals("LEFT")) {
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
     * if pacman collides with a wall, movement stops, e.g. dx and dy are set to 0.
     * Pacman's position bounces back 3px from the wall to ensure Pacman does not stop in a wall.
     * @param pacMan pacman-image
     * @param walls lsit of all walls on map
     */
    public boolean checkWallCollision(ImageView pacMan, List<Rectangle> walls) {
        for (Rectangle wall : walls) {

            if (pacMan.getBoundsInParent().intersects(wall.getBoundsInParent())) {
                if (dx == 1) {
                    xPosition -= 3;
                } else if (dx == -1) {
                    xPosition += 3;
                } else if (dy == 1) {
                    yPosition -= 3;
                } else if (dy == -1) {
                    yPosition += 3;
                }

                return true;
            }
        }
        return false;
    }

    /**
     * When pacman collides with a pellet,
     * if-statement checks if pellet has already been consumed.
     * If not, user is given 10 points and pellet is set to invisible
     * @param pacMan pacman-image
     * @param pellets list of all pellets on map
     */
    public void checkPelletCollision(ImageView pacMan, List<ImageView> pellets){
        for (ImageView pellet : pellets){
            if(pacMan.getBoundsInParent().intersects(pellet.getBoundsInParent()) && pellet.isVisible()){
                score += 10;
                pellet.setVisible(false);
            }
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
    public double rotationAngle() {
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