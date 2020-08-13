import java.awt.*;

public class PlayTank extends Tank implements SuperFire{
    public PlayTank(int x, int y, Diretion diretion, Image[] image) {
        super(x, y, diretion, image);
    }

    @Override
    public void superFire() {
        for(Diretion diretion:Diretion.values()){
            Bullet bullet = new Bullet(x+width/2 -GameClinet.bullentImage[0].getWidth(null)/2,
                    y+height/2- GameClinet.bullentImage[0].getHeight(null)/2,diretion
                    ,enemy,GameClinet.bullentImage);
            bullet.setSpeed(15);
            Tankwar.gameClinet.addGameObject(bullet);
        }
    }
}
