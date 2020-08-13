import java.awt.*;
import java.util.Random;

public class EnenyTank extends Tank {

    public EnenyTank(int x, int y, Diretion diretion, boolean enemy, Image[] image) {
        super(x, y, diretion, enemy, image);
    }

    public void ai() {
        Random rand = new Random();
        if (rand.nextInt(20) == 1) {
            dirs = new boolean[4];

            if (rand.nextBoolean() == true) {
                return;
            }
            getNewDireion();

        }
        if (rand.nextInt(50) == 1) {
            fire();
        }


    }

    private void getNewDireion() {
        Random rand = new Random();
        int dir = rand.nextInt(Diretion.values().length);
        if(dir<=Diretion.RIGHT.ordinal()){
            dirs[dir]=true;
        }else {
            if(dir==Diretion.UP_LEFT.ordinal()){
                dirs[0]=true;
                dirs[2]=true;
            }
            if(dir==Diretion.UP_RIGFT.ordinal()){
                dirs[0]=true;
                dirs[3]=true;
            }
            if(dir==Diretion.DOWN_LEFT.ordinal()){
                dirs[1]=true;
                dirs[2]=true;
            }
            if(dir==Diretion.DOWN_RIGHT.ordinal()){
                dirs[1]=true;
                dirs[3]=true;
            }

        }





    }


    @Override
    public void draw(Graphics g) {
        ai();
        super.draw(g);
    }

    @Override
    public boolean collision() {
        if(super.collision()){
            getNewDireion();
            return true;
        }
        return false;
    }
}
