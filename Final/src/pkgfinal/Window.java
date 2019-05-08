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
public class Window extends Item{

    private int width;
    private int height;
    private Game game;
    private boolean pressed;
    private boolean available;
    private int type;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Window(int x, int y, int width, int height, int type, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.pressed = false;
        this.type = type;
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
     * @return a <code>boolean</code> with the Height value
     */
    public boolean getPressed() {
        return pressed;
    }
    
    /**
     * Get the type of the instruction
     * @return an <code>integer</code> with the type value
     */
    public int getType() {
        return type;
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
        
        switch (type) {
            
            case 1:
                g.drawImage(Assets.instNivel1, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 2:
                g.drawImage(Assets.instNivel2, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 3:
                g.drawImage(Assets.win, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 4:
                g.drawImage(Assets.winWin, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 5:
                g.drawImage(Assets.lose, getX(), getY(), getWidth(), getHeight(), null);
            break;
        }
    }
}