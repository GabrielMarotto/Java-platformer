package inputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;
import utils.Constants;

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
                gamePanel.setMoving(false);
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            
            case KeyEvent.VK_W:
                gamePanel.setDirection(utils.Constants.Directions.UP);
                break;
            case KeyEvent.VK_A:
                gamePanel.setDirection(utils.Constants.Directions.LEFT);
                break;
            case KeyEvent.VK_S:
                gamePanel.setDirection(utils.Constants.Directions.DOWN);
                break;
            case KeyEvent.VK_D:
                gamePanel.setDirection(utils.Constants.Directions.RIGHT);
                break;
        }
    }
}

