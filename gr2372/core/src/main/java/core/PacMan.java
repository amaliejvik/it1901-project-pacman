package core;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class PacMan {

    // ATTRIBUTES
    public static double dx = 0;
    public static double dy = 0;
    public static double rotate;
    private double xPosition = 330;
    private double yPosition = 115;
    private int score;
    private String username;
    
    //CONSTRUCTOR
    public PacMan() {
        return;
    }

    //GETTERS AND SETTERS
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

    public void setUsername(String usr) {
        username = usr;
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
     * Changes PacMan's direction and rotation.
     * Receives key inputs from PacManApp class.
     * @param string the direction of the corresponding arrow key typed.
     * sets the static variables dx, dy and rotation which are fed into the timeline function in the controller
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

    //CHECKS IF PACMAN HAS COLLIDED WITH WALL
    /**
     * @param pacMan pacman's position
     * @param walls lsit of all walls on map
     * if pacman collides with a wall, movement stops, dx dy set to 0.
     * pacman's position bounces back from the wall.
     */
    public void checkWallCollision(ImageView pacMan, List<Rectangle> walls) {
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

                dx = 0;
                dy = 0;
            }
        }
    }

    //CHECKS IF PACMAN HAS COLLIDED WITH PELLETS
    /**
     * When pacman collides with a pellet,
     * If-statement checks if pellet has already been consumed.
     * If not, user is given 10 points and pellet is set to invisible
     * @param pacMan pacman's position
     * @param pellets list of pellet positions
     */
    public void checkPelletCollision(ImageView pacMan, List<ImageView> pellets){
        for (ImageView pellet : pellets){
            if(pacMan.getBoundsInParent().intersects(pellet.getBoundsInParent()) && pellet.isVisible()){
                score += 10;
                pellet.setVisible(false);
            }
        }

    }

    //GIVES ROTATION-ANGLE
    /**
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