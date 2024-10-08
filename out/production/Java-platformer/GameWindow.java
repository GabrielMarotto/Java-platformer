package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GameWindow {

    private JFrame jframe;

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();

                    
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel); //Necessaaaaaaaaaary to join the JFrame and JPanel together. Also passin in a Jpanel(GamePanel in this case) in the method parameters.
        jframe.setLocationRelativeTo(null);//Makes frame appear in the middle of the screen
        jframe.setResizable(false);
        jframe.pack(); //Telling JFrame to adjust to the size of the JPanel.
        jframe.setVisible(true); //must be on the bottom of function stack

        jframe.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().WindowFocusLost();
            }
        });
    }
}
