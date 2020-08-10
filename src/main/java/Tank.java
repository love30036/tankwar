import javax.swing.*;
import java.awt.*;

public class Tank extends GameObject{

    Diretion diretion;
    protected int speed;
    private boolean dirs[] = new boolean[4];
    protected boolean enemy;


    public Tank(int x, int y, Diretion diretion,Image[] image) {

        this(x,y,diretion,false,image);
    }
    public Tank(int x, int y, Diretion diretion,boolean enemy, Image[] image) {
        super(x, y, image);
        this.diretion = diretion;
        this.speed = 5;
        this.enemy=enemy;
    }

    public boolean[] getDirs() {
        return dirs;
    }

    public void setDirs(boolean[] dirs) {
        this.dirs = dirs;
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

//    public Image getimage(){
//
//        String name = enemy ? "etank":"itank";
//
//        if(diretion==Diretion.UP){
//            return new ImageIcon("assets\\images\\"+name+"U.png").getImage();
//        }
//        if(diretion==Diretion.DOWN){
//            return new ImageIcon("assets\\images\\"+name+"D.png").getImage();
//        }
//        if(diretion==Diretion.LEFT){
//            return new ImageIcon("assets\\images\\"+name+"L.png").getImage();
//        }
//        if(diretion==Diretion.RIGHT){
//            return new ImageIcon("assets\\images\\"+name+"R.png").getImage();
//        }
//        if(diretion==Diretion.UP_LEFT){
//            return new ImageIcon("assets\\images\\"+name+"LU.png").getImage();
//        }
//        if(diretion==Diretion.UP_RIGFT){
//            return new ImageIcon("assets\\images\\"+name+"RU.png").getImage();
//        }
//        if(diretion==Diretion.DOWN_LEFT){
//            return new ImageIcon("assets\\images\\"+name+"LD.png").getImage();
//        }
//        if(diretion==Diretion.DOWN_RIGHT){
//            return new ImageIcon("assets\\images\\"+name+"RD.png").getImage();
//        }
//        return null;
//    }
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
    public void collision(){

        if(x<0){
            x = 0;
        } else if (x > Tankwar.gameClinet.getWidth() - width) {
            x = Tankwar.gameClinet.getWidth() - width;
        }
        if(y<0){
            y = 0;
        } else if (y > Tankwar.gameClinet.getHeight() - height) {
            y = Tankwar.gameClinet.getHeight() - height;
        }

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


    private void determineDirection(){
        //  0:上  1:下  2:左   3:右
        if (dirs[0] && dirs[2]&& !dirs[1] &&!dirs[3]) diretion = Diretion.UP_LEFT;
        else if (dirs[0] && dirs[3]&& !dirs[2] &&!dirs[1]) diretion = Diretion.UP_RIGFT;
        else if (dirs[1] && dirs[2]&& !dirs[0] &&!dirs[3]) diretion = Diretion.DOWN_LEFT;
        else if (dirs[1] && dirs[3]&& !dirs[0] &&!dirs[2]) diretion = Diretion.DOWN_RIGHT;
        else if (dirs[0] && !dirs[1]&& !dirs[2] &&!dirs[3]) diretion = Diretion.UP;
        else if (dirs[1] && !dirs[0]&& !dirs[2] &&!dirs[3]) diretion = Diretion.DOWN;
        else if (dirs[2] && !dirs[3]&& !dirs[0] &&!dirs[1]) diretion = Diretion.LEFT;
        else if (dirs[3] && !dirs[1]&& !dirs[0] &&!dirs[2]) diretion = Diretion.RIGHT;
    }
    public void draw(Graphics g){

        if (!isStop()) {
            determineDirection();
            move();
            collision();
        }
        g.drawImage(image[diretion.ordinal()],x,y,null);


    }
    public boolean isStop(){
        //for(boolean dir:dirs){
        // if(dir){
        // return false;
        // }
        // }return true;
        for(int i =0; i < dirs.length ; i++){
            if(dirs[i]){
                return false;
            }
        }
        return true;
    }
    public void fire(){
        Tankwar.gameClinet.addGameObject(new Bullet(x+width/2 - GameClinet.bullentImage[0].getWidth(null)/2,
                y+height/2 - GameClinet.bullentImage[0].getHeight(null)/2,diretion,enemy,GameClinet.bullentImage));
    }

}
