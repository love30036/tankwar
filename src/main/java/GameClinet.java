import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameClinet extends JComponent {

    private int screenwidth;
    private int screenhight;
    private Tank playerTank;
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
        playerTank = new Tank(getCenterPosX(47),getCenterPosY(47),
                Diretion.DOWN_RIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(playerTank.getimage(),
                playerTank.getX(),playerTank.getY(),null);
    }
    private int getCenterPosX(int width){
        return (screenwidth-width)/2;
    }

    private int getCenterPosY(int hight){
        return (screenhight-hight)/2;
    }
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                playerTank.setDiretion(Diretion.UP);
           //     playerTank.setY(playerTank.getY()-playerTank.getSpeed());
                break;
            case KeyEvent.VK_DOWN:
                playerTank.setDiretion(Diretion.DOWN);
          //      playerTank.setY(playerTank.getY()+playerTank.getSpeed());
                break;
            case KeyEvent.VK_LEFT:
                playerTank.setDiretion(Diretion.LEFT);
          //      playerTank.setX(playerTank.getX()-playerTank.getSpeed());
                break;
            case KeyEvent.VK_RIGHT:
                playerTank.setDiretion(Diretion.RIGHT);
           //     playerTank.setX(playerTank.getX()+playerTank.getSpeed());
                break;
        }
        playerTank.move();
    }


    GameClinet(){
        this(800,600);
    }



}
