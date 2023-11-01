package core;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Inky extends Ghost {

    public Inky() {
        return;
    }

    public void reset() {
        super.changeDirection("DOWN");
        super.setXPosition(548);
        super.setYPosition(24);
        
    }

    public void pathing(ImageView inky, List<Rectangle> inkyCollisionRectangles) {
        if (checkWallCollision(inky, inkyCollisionRectangles.get(0))) {
            changeDirection("RIGHT");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(1))) {
            changeDirection("UP");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(2))) {
            changeDirection("RIGHT");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(3))) {
            changeDirection("DOWN");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(4))) {
            changeDirection("LEFT");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(5))) {
            changeDirection("UP");
        }
        else if (checkWallCollision(inky,inkyCollisionRectangles.get(6))) {
            changeDirection("LEFT");
        }
        else if (checkWallCollision(inky,inkyCollisionRectangles.get(7))) {
            changeDirection("DOWN");
        }
        else if (checkWallCollision(inky,inkyCollisionRectangles.get(8))) {
            changeDirection("LEFT");
        }
        else if (checkWallCollision(inky,inkyCollisionRectangles.get(9))) {
            changeDirection("UP");
        }
        else if (checkWallCollision(inky,inkyCollisionRectangles.get(10))) {
            changeDirection("LEFT");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(11))) {
            changeDirection("DOWN");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(12))) {
            changeDirection("LEFT");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(13))) {
            changeDirection("UP");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(14))) {
            changeDirection("RIGHT");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(15))) {
            changeDirection("DOWN");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(16))) {
            changeDirection("RIGHT");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(17))) {
            changeDirection("UP");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(18))) {
            changeDirection("RIGHT");
        }
        else if (checkWallCollision(inky, inkyCollisionRectangles.get(19))) {
            changeDirection("DOWN");
        }
    }
}