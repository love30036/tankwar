import javax.swing.*;

public class Tankwar {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add(new GameClinet(1024,768));
        jFrame.setTitle("tankwar");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();

    }
}
