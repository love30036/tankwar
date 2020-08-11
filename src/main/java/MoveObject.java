import java.awt.*;

public abstract class MoveObject extends GameObject{

    Diretion diretion;
    protected int speed;
    protected boolean enemy;


    public MoveObject(int x, int y, Diretion diretion, Image[] image) {
        this(x,y,diretion,false,image);
    }
    public MoveObject(int x, int y, Diretion diretion, boolean enemy, Image[] image) {
        super(x, y, image);
        this.diretion = diretion;
        this.speed = 5;
        this.enemy=enemy;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int sleep) {
        this.speed = sleep;
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

    public Diretion getDiretion() {
        return diretion;
    }

    public void setDiretion(Diretion diretion) {
        this.diretion = diretion;
    }

    public void move(){
        oldX=x;
        oldY=y;
        switch (diretion){
            case UP:
                y-=speed;
                break;
            case DOWN:
                y+=speed;
                break;
            case LEFT:
                x-=speed;
                break;
            case RIGHT:
                x+=speed;
                break;
            case UP_LEFT:
                y-=speed;
                x-=speed;
                break;
            case UP_RIGFT:
                y-=speed;
                x+=speed;
                break;
            case DOWN_LEFT:
                y+=speed;
                x-=speed;
                break;
            case DOWN_RIGHT:
                y+=speed;
                x+=speed;
                break;
        }


    }
    public boolean collisionBound() {
        boolean collision = false;
        if(x<0){
            x = 0;
            collision = true;
        } else if (x > Tankwar.gameClinet.getWidth() - width) {
            x = Tankwar.gameClinet.getWidth() - width;
            collision = true;
        }
        if(y<0){
            y = 0;
            collision = true;
        } else if (y > Tankwar.gameClinet.getHeight() - height) {
            y = Tankwar.gameClinet.getHeight() - height;
            collision = true;
        }
        return collision;
    }
    public void collision(){

        collisionBound();

        for(GameObject object:Tankwar.gameClinet.getGameObject()){
            if(object!=this){
                if (object.getRectangle().intersects(this.getRectangle())){
                    x=oldX;
                    y=oldY;
                    return;
                }
            }


        }



    }

    abstract void draw(Graphics g);

    }


