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
public class Button extends Item{

    private int width;
    private int height;
    private Game game;
    private boolean pressed;
    private int level;
    private boolean available;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Button(int x, int y, int width, int height, int level, boolean available, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.level = level;
        this.available = available;
        this.game = game;
        this.pressed = false;
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
     * Get status of pressed button
     * @return 
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
     * Control the player movement 
     */
    @Override
    public void tick() {
        if (game.getMouseManager().isIzquierdo()) {
            setPressed(true);
        }
    }

    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.button, getX(), getY(), getWidth(), getHeight(), null);
    }
}
