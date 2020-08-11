import java.awt.*;

/***
 * 坦克物件
 */

public class Tank extends MoveObject {
    //上下左右
    protected boolean[] dirs = new boolean[4];

    public Tank(int x, int y, Diretion direction, Image[] image) {
        this(x, y, direction, false, image);
    }

    public Tank(int x, int y, Diretion direction, boolean enemy, Image[] image) {
        super(x, y, direction, enemy, image);
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.enemy = enemy;
        speed = 10;
    }


    public void fire() {
        Bullet bullet = new Bullet(x+width/2 - GameClinet.bullentImage[0].getWidth(null) /2,
                y+width/2 - GameClinet.bullentImage[0].getWidth(null) /2, direction, enemy, GameClinet.bullentImage);
        Tankwar.gameClinet.addGameObject(bullet);
    }

    public void superFire(){

    }


    @Override
    public void collision() {

        collisionBound();

        for (GameObject object : Tankwar.gameClinet.getGameObject()) {
            if (object != this) {
                if (object.getRectangle().intersects(getRectangle())) {
                    x = oldX;
                    y = oldY;
                    return;
                }
            }
        }
    }


    private void determineDirection() {
        //0:上 1:下 2:左 3:右
        if (dirs[0] && !dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Diretion.UP;
        } else if (!dirs[0] && dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Diretion.DOWN;
        } else if (!dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Diretion.LEFT;
        } else if (!dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Diretion.RIGHT;
        } else if (dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Diretion.UP_LEFT;
        } else if (dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Diretion.UP_RIGFT;
        } else if (!dirs[0] && dirs[1] && dirs[2] && !dirs[3]) {
            direction = Diretion.DOWN_LEFT;
        } else if (!dirs[0] && dirs[1] && !dirs[2] && dirs[3]) {
            direction = Diretion.DOWN_RIGHT;
        }
    }


    @Override
    public void draw(Graphics g) {
        if (!alive) {
            return;
        }

        if (!isStop()) {
            determineDirection();
            move();
            collision();
        }

        g.drawImage(image[direction.ordinal()], x, y, null);
    }

    private boolean isStop() {
        for (boolean dir : dirs) {
            if (dir) {
                return false;
            }
        }
        return true;
    }

    public boolean[] getDirs() {
        return dirs;
    }
}