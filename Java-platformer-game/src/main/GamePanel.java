package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;
import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game) {
        mouseInputs = new MouseInputs(this);
        this.game = game;
        
        setPanelSize();
        addKeyListener (new KeyboardInputs(this));
        addMouseListener (mouseInputs); 
        addMouseMotionListener (mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("size: " + GAME_WIDTH + " : " + GAME_HEIGHT);
    }

    public void updateGame() {

    }
    public void paintComponent(Graphics g) {
        //paintComponent is a magic method. JPanel calls it automatically upon window startup
        //What actually allous the method to paint is the Graphics method. That's why we pass an object Graphics onto it
        //In layman's terms, Graphics is the paintbrush.
       
        //For JPanel to call the correct method inside JComponent (JPanel's parent class), we must use:
        super.paintComponent(g);
        //this calls the super method already built within the JComponent class to be used in our paintComponent method.
        game.render(g);
        
    }

    public Game getGame() {
        return game;
    }



}
