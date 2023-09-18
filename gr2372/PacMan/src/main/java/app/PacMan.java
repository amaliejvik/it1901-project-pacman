package app;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class PacMan {

    private double xPosition = 333;
    private double yPosition = 124;
    
    public static double dx = 0;
    public static double dy = 0;

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


    public PacMan() {
        return;
    }

    public static void changeDirection(String string) {
        if(string.equals("RIGHT")) {
            dy = 0;
            dx = 1;
            
        }
        else if(string.equals("LEFT")) {
            dy = 0;
            dx = -1;
        }
        else if(string.equals("UP")) {
            dy = -1;
            dx = 0;
        }
        else if(string.equals("DOWN")) {
            dy = 1;
            dx = 0;
        }
    }

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
}