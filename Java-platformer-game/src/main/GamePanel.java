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
    private BufferedImage img; 
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;

    public GamePanel() {

        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();
        
        setPanelSize();
        addKeyListener (new KeyboardInputs(this));
        addMouseListener (mouseInputs); 
        addMouseMotionListener (mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];
        
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
            }
        }
    }
    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    private void updateAnimationTick() {
       aniTick++;
       if (aniTick >= aniSpeed) {
        aniTick = 0;
        aniIndex++;
        if (aniIndex >= 6) {
            aniIndex = 0;
        }
       } 
    }
    
    public void paintComponent(Graphics g) {
        //paintComponent is a magic method. JPanel calls it automatically upon window startup
        //What actually allous the method to paint is the Graphics method. That's why we pass an object Graphics onto it
        //In layman's terms, Graphics is the paintbrush.
       
        //For JPanel to call the correct method inside JComponent (JPanel's parent class), we must use:
        super.paintComponent(g);
        //this calls the super method already built within the JComponent class to be used in our paintComponent method.
        updateAnimationTick();
        g.drawImage(animations[1][aniIndex], (int)xDelta, (int)yDelta, 128, 80, null);
        
    }

}
