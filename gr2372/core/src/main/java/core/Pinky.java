package core;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Pinky extends Ghost {

    public Pinky() {
        return;
    }

    public void reset() {
        super.changeDirection("LEFT");
        super.setXPosition(395);
        super.setYPosition(290);
    }

    public void pathing(ImageView pinky, List<Rectangle> pinkyCollisionRectangles) {
        if (checkWallCollision(pinky, pinkyCollisionRectangles.get(0))) {
            changeDirection("UP");
        } else if (checkWallCollision(pinky, pinkyCollisionRectangles.get(1))) {
            changeDirection("RIGHT");
        } else if (checkWallCollision(pinky, pinkyCollisionRectangles.get(2))) {
            changeDirection("DOWN");
        } else if (checkWallCollision(pinky, pinkyCollisionRectangles.get(3))) {
            changeDirection("LEFT");
        }
    }

}