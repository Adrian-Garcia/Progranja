/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author adria
 */
public class Casa extends Item{

    private int width;
    private int height;
    private Game game;
    private int index;
    private int prevX;
    private int prevY;
    private Animation animationUp;
    private Animation animationLeft;
    private Animation animationDown;
    private Animation animationRight;
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Casa(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.index = 0;
        this.prevX = x;
        this.prevY = y;
        
        this.animationUp = new Animation(Assets.playerUp, 100);
        this.animationLeft = new Animation(Assets.playerLeft, 100);
        this.animationDown = new Animation(Assets.playerDown, 100);
        this.animationRight = new Animation(Assets.playerRight, 100);
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
     * Get the previous value of X position
     * @return prevX
     */
    public int getPrevX() {
        return prevX;
    }
    
    /**
     * Get the previous value of Y position
     * @return prevY
     */
    public int getPrevY() {
        return prevY;
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
     * Set the previous value of X position
     * @param prevX 
     */
    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }
    
    /**
     * Set the previous value of Y position
     * @param prevY 
     */
    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    /**
     * Control the player movement 
     */
    @Override
    public void tick() {
        
    }
    
    /**
     * Get perimeter of player for collisions
     * @return 
     */
    public Rectangle getPerimetro() {
        return new Rectangle (getX(), getY(), getWidth()/2, getHeight()/2);
    }
    
    /**
     * Validate if there was an intersection 
     * @param obj
     * @return intersection
     */
    public boolean intersecta(Object obj) {
        return obj instanceof Player && getPerimetro().intersects(((Player) obj).getPerimetro());
    }
    
    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
            g.drawImage(Assets.farm, getX(), getY(), getWidth(), getHeight(), null);
    }
}
