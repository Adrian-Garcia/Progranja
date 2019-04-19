/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Graphics;

/**
 *
 * @author adria
 */
public class Action extends Item{

    private int width;
    private int height;
    private Game game;
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
    public void setPressed() {
        game.newInst(val);
    }

    /**
     * Control the player movement 
     */
    @Override
    public void tick() {
        if (game.getMouseManager().isIzquierdo()) {
            setPressed();
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
                g.drawImage(Assets.arrowUp, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 1:
                g.drawImage(Assets.arrowDown, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 2:
                g.drawImage(Assets.arrowLeft, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 3:
                g.drawImage(Assets.arrowRight, getX(), getY(), getWidth(), getHeight(), null);
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
