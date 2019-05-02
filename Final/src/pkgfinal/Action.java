/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author adria
 */
public class Action extends Item{

    private int width;
    private int height;
    private Game game;
    private boolean pressed;
    private int val;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Action(int x, int y, int width, int height, int val, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.val = val;
        pressed = false;
    }

    /**
     * Get the Height
     * @return an <code>integer</code> with the Width value
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the Height
     * @return an <code>integer</code> with the Height value
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Get the value of the arrow
     * @return 
     */
    public int getVal() {
        return val;
    }
    
    /**
     * Get the value of pressed boolean
     * @return pressed
     */
    public boolean getPressed() {
        return pressed;
    }

    /**
     * Set the Width
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Set the Height
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * Set the status of pressed button
     * @param pressed 
     */
    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
    
    /**
     * To get the a rectangle with the position in x and y, the width, and the height of the player
     * @return an <code>Rectangle</code> value with the rectangle 
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Control the player movement 
     */
    @Override
    public void tick() {
        if (game.getMouseManager().isIzquierdo() && getPerimetro().contains(game.getMouseManager().getX(), game.getMouseManager().getY())) {
            setPressed(true);
        }
    }

    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        
        switch (val) {
            
            case 0:
                
            break;
            
            case 1:
                
            break;
            
            case 2:
               
            break;
            
            case 3:
                
            break;
            
            case 4:
                g.drawImage(Assets.fireball, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 5:
                g.drawImage(Assets.shield, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 6:
                g.drawImage(Assets.play, getX(), getY(), getWidth(), getHeight(), null);
            break;
        }
    }
}
