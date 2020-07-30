import javax.swing.*;
import java.awt.*;

public class Tank {
    private int x;
    private int y;
    Diretion diretion;
    private int speed;

    public Tank(int x, int y, Diretion diretion) {
        this.x = x;
        this.y = y;
        this.diretion = diretion;
        this.speed = 5;
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

    public Image getimage(){
        if(diretion==Diretion.UP){
            return new ImageIcon("assets\\images\\itankU.png").getImage();
        }
        if(diretion==Diretion.DOWN){
            return new ImageIcon("assets\\images\\itankD.png").getImage();
        }
        if(diretion==Diretion.LEFT){
            return new ImageIcon("assets\\images\\itankL.png").getImage();
        }
        if(diretion==Diretion.RIGHT){
            return new ImageIcon("assets\\images\\itankR.png").getImage();
        }
        if(diretion==Diretion.UP_LEFT){
            return new ImageIcon("assets\\images\\itankLU.png").getImage();
        }
        if(diretion==Diretion.UP_RIGFT){
            return new ImageIcon("assets\\images\\itankRU.png").getImage();
        }
        if(diretion==Diretion.DOWN_LEFT){
            return new ImageIcon("assets\\images\\itankLD.png").getImage();
        }
        if(diretion==Diretion.DOWN_RIGHT){
            return new ImageIcon("assets\\images\\itankRD.png").getImage();
        }
        return null;
    }
    public void move(){
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
                x+=speed;
                break;
            case DOWN_RIGHT:
                y+=speed;
                x-=speed;
                break;
        }

    }
}
