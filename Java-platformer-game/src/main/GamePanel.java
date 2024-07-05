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

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img, subImg;

    public GamePanel() {

        mouseInputs = new MouseInputs(this);

        importImg();
        
        setPanelSize();
        addKeyListener (new KeyboardInputs(this));
        addMouseListener (mouseInputs); 
        addMouseMotionListener (mouseInputs);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
        repaint();
    }
    
    public void changeYDelta(int value) {
        this.yDelta += value;
        repaint();
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics g) {
        //paintComponent is a magic method. JPanel calls it automatically upon window startup
        //What actually allous the method to paint is the Graphics method. That's why we pass an object Graphics onto it
        //In layman's terms, Graphics is the paintbrush.
       
        //For JPanel to call the correct method inside JComponent (JPanel's parent class), we must use:
        super.paintComponent(g);
        //this calls the super method already built within the JComponent class to be used in our paintComponent method.

        subImg = img.getSubimage(1*64, 8*40, 64, 40);
        g.drawImage(subImg, (int)xDelta, (int)yDelta, 128, 80, null);
        
    }
}
