package gameobject;






import java.awt.*;

import static javafx.scene.input.KeyCode.T;

public abstract class Moveobject extends GameObject{

    public Moveobject(int x, int y, Image[] image) {
        super(x, y, image);
    }
//    public MoveObject(int x, int y, Direction direction, boolean enemy, Image[] image) {
//        super(x, y, image);
//        this.direction = direction;
//        speed = 5;
//        this.enemy = enemy;
//    }
}
