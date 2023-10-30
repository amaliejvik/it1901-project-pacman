package core;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Blinky extends Ghost {

    public Blinky() {
        return;
    }

    public void reset() {
        super.changeDirection("RIGHT");
        super.setXPosition(23);
        super.setYPosition(32);
    }

    public void pathing(ImageView blinky, List<Rectangle> blinkyCollisionRectangles) {
        if (checkWallCollision(blinky, blinkyCollisionRectangles.get(0))) {
            changeDirection("DOWN");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(1))) {
            changeDirection("RIGHT");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(2))) {
            changeDirection("UP");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(3))) {
            changeDirection("RIGHT");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(4))) {
            changeDirection("DOWN");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(5))) {
            changeDirection("LEFT");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(6))) {
            changeDirection("UP");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(7))) {
            changeDirection("LEFT");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(8))) {
            changeDirection("DOWN");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(9))) {
            changeDirection("LEFT");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(10))) {
            changeDirection("UP");
        }
        else if (checkWallCollision(blinky, blinkyCollisionRectangles.get(11))) {
            changeDirection("RIGHT");
        }
    }
}