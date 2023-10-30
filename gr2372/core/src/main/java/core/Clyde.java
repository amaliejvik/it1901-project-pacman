package core;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Clyde extends Ghost {

    public Clyde() {
        return;
    }

    public void reset() {
        super.changeDirection("LEFT");
        super.setXPosition(768);
        super.setYPosition(378);
    }

    public void pathing(ImageView clyde, List<Rectangle> clydeCollisionRectangles) {
        if (checkWallCollision(clyde, clydeCollisionRectangles.get(0))) {
            setXPosition(getXPosition()+3);
            changeDirection("UP");
        }
        else if (checkWallCollision(clyde, clydeCollisionRectangles.get(1))) {
            setYPosition(getYPosition()+3);
            changeDirection("LEFT");
        }
        else if (checkWallCollision(clyde,clydeCollisionRectangles.get(2))) {
            setXPosition(getXPosition()+3);
            changeDirection("UP");
        }
        else if (checkWallCollision(clyde,clydeCollisionRectangles.get(3))) {
            setYPosition(getYPosition()+3);
            changeDirection("RIGHT");
        }
        else if (checkWallCollision(clyde, clydeCollisionRectangles.get(4))) {
            setXPosition(getXPosition()-3);
            changeDirection("UP");
        }
        else if (checkWallCollision(clyde,clydeCollisionRectangles.get(5))) {
            setYPosition(getYPosition()+3);
            changeDirection("RIGHT");
        }
        else if (checkWallCollision(clyde, clydeCollisionRectangles.get(6))) {
            setXPosition(getXPosition()-3);
            changeDirection("DOWN");
        }
        else if (checkWallCollision(clyde, clydeCollisionRectangles.get(7))) {
            setYPosition(getYPosition()-3);
            changeDirection("LEFT");
        }
    }
}