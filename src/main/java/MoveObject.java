import java.awt.*;

/***
 * 坦克物件
 */

public abstract class MoveObject extends GameObject {

    protected int speed;
    protected Diretion direction;
    protected boolean enemy;

    public MoveObject(int x, int y, Diretion direction, Image[] image) {
        this(x, y, direction, false, image);
    }

    public MoveObject(int x, int y, Diretion direction, boolean enemy, Image[] image) {
        super(x, y, image);
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.enemy = enemy;
        speed = 10;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Diretion getDirection() {
        return direction;
    }

    public void setDirection(Diretion direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {

        oldX = x;
        oldY = y;

        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP_LEFT:
                y -= speed;
                x -= speed;
                break;
            case UP_RIGFT:
                y -= speed;
                x += speed;
                break;
            case DOWN_LEFT:
                x -= speed;
                y += speed;
                break;
            case DOWN_RIGHT:
                x += speed;
                y += speed;
                break;
        }
    }


    public boolean collisionBound() {

        boolean collision = false;
        if (x < 0) {
            x = 0;
            collision = true;
        } else if (x > Tankwar.gameClinet.getWidth() - width) {
            x = Tankwar.gameClinet.getWidth() - width;
            collision = true;
        }

        if (y < 0) {
            y = 0;
            collision = true;
        } else if (y > Tankwar.gameClinet.getHeight() - height) {
            y = Tankwar.gameClinet.getHeight() - height;
            collision = true;
        }

        return collision;
    }

    public abstract boolean collision();


    public void draw(Graphics g) {
        if (!alive) {
            return;
        }

        move();
        collision();


        g.drawImage(image[direction.ordinal()], x, y, null);
    }
}