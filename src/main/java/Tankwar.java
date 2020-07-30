import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tankwar {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        GameClinet gameClinet = new GameClinet(1024,768);
        jFrame.add(gameClinet);
        jFrame.setTitle("tankwar");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();


        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gameClinet.keyPressed(e);
//                super.keyPressed(e);
//                System.out.println((char) e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });

    }
}
