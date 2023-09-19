package app;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class PacMan {

    //Attributes
    public static double dx = 0;
    public static double dy = 0;
    private double xPosition = 330;
    private double yPosition = 115;
    private static double rotate;
    private int score;
    
    /**
     * Constructor for PacMan
     */
    public PacMan() {
        return;
    }

    /**
     * Getter for score
     * @return current score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Setter for score
     * @param score score to be set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Getter for PacMan's x-position
     * @return current x-position
     */
    public double getXPosition() {
        return this.xPosition;
    }

    /**
     * Setter for PacMan's x-position
     * @param xPosition x-position to be set
     */
    public void setXPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Getter for PacMan's y-position
     * @return current y-position
     */
    public double getYPosition() {
        return this.yPosition;
    }

    /**
     * Setter for PacMan's y-position
     * @param yPosition y-position to be set
     */
    public void setYPosition(double yPosition) {
        this.yPosition = yPosition;
    }


    
    /**
     * Changes which direction PacMan is moving and facing
     * @param string string to indicate what arrow is pressed
     */
    public static void changeDirection(String string) {
        if(string.equals("RIGHT")) {
            dy = 0;
            dx = 1;
            rotate = 0;
            
        }
        else if(string.equals("LEFT")) {
            dy = 0;
            dx = -1;
            rotate = 1;
        }
        else if(string.equals("UP")) {
            dy = -1;
            dx = 0;
            rotate = 2;
        }
        else if(string.equals("DOWN")) {
            dy = 1;
            dx = 0;
            rotate = 3;
        }
    }

    
    /**
     * Checks if PacMan is colliding with any wall
     * @param pacMan the PacMan model
     * @param walls array with all walls
     */
    public void checkWallCollision(ImageView pacMan, List<Rectangle> walls) {
        for (Rectangle wall : walls){
            
            if (pacMan.getBoundsInParent().intersects(wall.getBoundsInParent())) {
                if (dx == 1) {
                    xPosition -= 3;
                }
                else if (dx == -1) {
                    xPosition += 3;
                }
                else if (dy == 1) {
                    yPosition -= 3;
                }
                else if (dy == -1) {
                    yPosition += 3;
                }

                dx = 0;
                dy = 0;
            }
        }
    }

    /**
     * Checks if PacMan is colliding with any pellets,
     * if so, removes pellet, adds to score
     * @param pacMan the PacMan model
     * @param walls array with all pellets
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
     * Translates rotation index to degrees
     * @return angle to point PacMan
     */
    public double rotationAngle() {
        //Right
        if(rotate == 0){
            return 0;
        }
        //Left
        else if (rotate == 1) {
            return 180;
        }
        //Up
        else if (rotate == 2) {
            return 270;
        }
        //Down
        return 90;
    }
}