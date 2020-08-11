import java.awt.*;
import java.util.List;

public class Bullet extends MoveObject {


    public Bullet(int x, int y, Diretion diretion, Image[] image) {
        super(x, y, diretion, image);
    }

    public Bullet(int x, int y, Diretion diretion, boolean enemy, Image[] image) {
        super(x, y, diretion, enemy, image);
        speed=10;
    }

    @Override
    public void draw(Graphics g) {
        if(!alive){
            return;
        }


        move();
        collision();

        g.drawImage(image[direction.ordinal()],x,y,null);
    }

    @Override
    public void collision() {
        if(collisionBound()){
            alive = false;
            return;
        }
       List<GameObject> objects = Tankwar.gameClinet.getGameObject();

        for(GameObject object:objects){
            if(object==this){
                continue;
            }
            if(object instanceof Tank){
                if(((Tank)object).enemy==enemy){
                    continue;
                }
            }
            if(getRectangle().intersects(object.getRectangle())){
                alive = false;

                if(object instanceof Tank){
                    alive = false;
                    object.alive=false;

                }


               return;
            }
        }

    }



}
