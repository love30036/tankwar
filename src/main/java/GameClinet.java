import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;


public class GameClinet extends JComponent {

    private int screenwidth;
    private int screenhight;
    private Tank playerTank;
    private List<Tank> enemyTank = new ArrayList<>();
    private List<Wall> walls = new ArrayList<>();
    private boolean stop;

    public GameClinet(int screenwidth, int screenhight) {
        this.screenwidth = screenwidth;
        this.screenhight = screenhight;
        this.setPreferredSize(new Dimension(screenwidth,screenhight));
        init();

        new Thread(()->{
            while (!stop){
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                 }
            }
        }).start();

    }
    public void init(){
        playerTank = new Tank(getCenterPosX(47),100,
                Diretion.DOWN_RIGHT);
        for(int i =0; i<3 ;i++){
            for (int j = 0; j<4 ;j++){
                enemyTank.add(new Tank(300+j*80,500+i*80,Diretion.UP,true));
            }
        walls.add(new Wall(250,150,15,true));
        walls.add(new Wall(150,200,15,false));
        walls.add(new Wall(800,200,15,false));



        }
    }

    @Override
    protected void paintComponent(Graphics g) {
//        g.drawImage(playerTank.getimage(),
//                playerTank.getX(),playerTank.getY(),null);
        playerTank.draw(g);
        for(Tank tank:enemyTank){
            tank.draw(g);
        }
        for(Wall wall:walls){
            wall.draw(g);
        }

    }
    private int getCenterPosX(int width){
        return (screenwidth-width)/2;
    }

    private int getCenterPosY(int hight){
        return (screenhight-hight)/2;
    }


    public void keyPressed(KeyEvent e) {
       boolean[] dirs = playerTank.getDirs();
        switch (e.getKeyCode()){

            case KeyEvent.VK_UP:
                dirs[0]=true;
//                playerTank.setDiretion(Diretion.UP);
//                playerTank.setY(playerTank.getY()-playerTank.getSpeed());
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=true;
//                playerTank.setDiretion(Diretion.DOWN);
//                playerTank.setY(playerTank.getY()+playerTank.getSpeed());
                break;
            case KeyEvent.VK_LEFT:
                dirs[2]=true;
//                playerTank.setDiretion(Diretion.LEFT);
//                playerTank.setX(playerTank.getX()-playerTank.getSpeed());
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3]=true;
//                playerTank.setDiretion(Diretion.RIGHT);
//                playerTank.setX(playerTank.getX()+playerTank.getSpeed());
                break;

        }

    }
    public void keyReleased(KeyEvent e){
        boolean[] dirs = playerTank.getDirs();
        switch (e.getKeyCode()){

            case KeyEvent.VK_UP:
                dirs[0]=false;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=false;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2]=false;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3]=false;
                break;


        }





    }


    GameClinet(){
        this(800,600);
    }



}
