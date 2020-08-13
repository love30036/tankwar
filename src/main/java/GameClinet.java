import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class GameClinet extends JComponent {

    private int screenwidth;
    private int screenhight;
    private PlayTank playerTank;
//    private List<Tank> enemyTank = new ArrayList<>();
//    private List<Wall> walls = new ArrayList<>();
    private CopyOnWriteArrayList<GameObject> gameObjects =new CopyOnWriteArrayList<>();
    private boolean stop;
    public static Image[] bullentImage = new Image[8];
    public static Image[] explosinsImage =new Image[11];

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
        Image[] brickImage = {Tools.getImage("brick.png")};
        Image[] iTankImage = new Image[8];
        Image[] eTankImage = new Image[8];

        String[] sub = {"U.png","D.png","L.png","R.png","LU.png","RU.png","LD.png","RD.png"};

        for(int i = 0; i<iTankImage.length;i++){
            iTankImage[i]=Tools.getImage("iTank"+sub[i]);
            eTankImage[i]=Tools.getImage("eTank"+sub[i]);
            bullentImage[i]=Tools.getImage("missile"+sub[i]);
        }
        for(int i =0;i<explosinsImage.length;i++){
            explosinsImage[i]=Tools.getImage(i+".png");
        }

        playerTank = new PlayTank(getCenterPosX(47),100,Diretion.UP ,iTankImage);
        for(int i =0; i<3 ;i++){
            for (int j = 0; j<4 ;j++){
                gameObjects.add(new EnenyTank(300+j*80,500+i*80,Diretion.UP,true,eTankImage));
            }
        Image image = Tools.getImage("brick.png");
        gameObjects.add(new Wall(250,150,15,true,brickImage));
        gameObjects.add(new Wall(150,200,15,false,brickImage));
        gameObjects.add(new Wall(800,200,15,false,brickImage));



        }
    }
    public List<GameObject> getGameObject(){
        return gameObjects;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getHeight());
//        g.drawImage(playerTank.getimage(),
//                playerTank.getX(),playerTank.getY(),null);
        playerTank.draw(g);
        for(GameObject object:gameObjects){
            object.draw(g);
        }
        for(GameObject object:gameObjects){
            if(!object.alive){
                gameObjects.remove(object);

            }
        }

//        Iterator<GameObject> iterator=gameObjects.iterator();
//
//        while(iterator.hasNext()){
//            if (!iterator.next().alive) {
//                iterator.remove();
//            }
//        }
        System.out.println(gameObjects.size());

//        for(Tank tank:enemyTank){
//            tank.draw(g);
//        }
//        for(Wall wall:walls){
//            wall.draw(g);
//        }

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
            case KeyEvent.VK_CONTROL:
                playerTank.fire();
                break;
            case KeyEvent.VK_A:
                playerTank.superFire();
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
    public void addGameObject(GameObject object){
        gameObjects.add(object);
    }

    GameClinet(){
        this(800,600);
    }

    public void checkGameStatus(){
        boolean gameWin = true;


    }

}
