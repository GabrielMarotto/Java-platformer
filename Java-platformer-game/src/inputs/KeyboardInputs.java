package inputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;
import static utils.Constants.Directions.*;

public class KeyboardInputs implements KeyListener{

    public GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void keyTyped(KeyEvent e) { 

    }
    
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setMoving(false);
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            
            case KeyEvent.VK_W:
                gamePanel.getGame().getPlayer().setDirection(UP);
                break;
            case KeyEvent.VK_A:
                gamePanel.getGame().getPlayer().setDirection(LEFT);
                break;
            case KeyEvent.VK_S:
                gamePanel.getGame().getPlayer().setDirection(DOWN);
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setDirection(RIGHT);
                break;
        }
    }
}

