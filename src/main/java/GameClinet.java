import javax.swing.*;
import java.awt.*;

public class GameClinet extends JComponent {

    private int screenwidth;
    private int screenhight;



    public GameClinet(int screenwidth, int screenhight) {
        this.screenwidth = screenwidth;
        this.screenhight = screenhight;
        this.setPreferredSize(new Dimension(screenwidth,screenhight));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("assets\\images\\itankD.png").getImage(),
                400,100,null);
    }

    GameClinet(){
        this(800,600);
    }

}
