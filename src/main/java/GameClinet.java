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




    GameClinet(){
        this(800,600);
    }

}
