import javax.swing.*;

public class Tankwar {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        GameClinet gameClinet = new GameClinet(1024,768);
        jFrame.add(gameClinet);
        jFrame.setTitle("tankwar");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();

    }
}
