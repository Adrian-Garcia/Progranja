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
public class Block extends Item{

    private int width;
    private int height;
    private Game game;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Block(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
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
     * Control the player movement 
     */
    @Override
    public void tick() {
    }
    
    /**
     * Get perimeter of Blocks for collisions
     * @return 
     */
    public Rectangle getPerimetro() {
        return new Rectangle (getX(), getY(), getWidth()-15, getHeight()-15);
    }

    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.block, getX(), getY(), getWidth(), getHeight(), null);
    }
}
