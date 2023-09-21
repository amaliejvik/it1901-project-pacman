package app;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class PacMan {

    // ATTRIBUTES
    public static double dx = 0;
    public static double dy = 0;
    private double xPosition = 330;
    private double yPosition = 115;
    private static double rotate;
    private int score;

    // CONSTRUCTOR
    public PacMan() {
        return;
    }

    // GENERAL METHODS
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

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    // CHANGES PACMANS MOVEMENT-DIRECTION
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

    // CHECKS IF PACMAN HAS COLLIDED WITH WALL
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

    // CHECKS IF PACMAN HAS COLLIDED WITH PELLETS
    public void checkPelletCollision(ImageView pacMan, List<ImageView> pellets) {
        for (ImageView pellet : pellets) {
            if (pacMan.getBoundsInParent().intersects(pellet.getBoundsInParent()) && pellet.isVisible()) {
                score += 10;
                pellet.setVisible(false);
            }
        }

    }

    // GIVES ROTATIONANGLE
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