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
public class Bar extends Item{

    private int direction;
    private int width;
    private int height;
    private Game game;
    public int speed;
    public int score = 0;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param direction
     * @param width
     * @param height
     * @param game 
     */
    public Bar(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 1;
    }

    /**
     * Get the direction 
     * @return an <code>integer</code> with the direction value
     */
    public int getDirection() {
        return direction;
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
     * Set the Direction
     * @param direction 
     */
    public void setDirection(int direction) {
        this.direction = direction;
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
     * Calculates the perimeter of the player according to the Width and
     * Height of it. 
     * @return Rectangle perimeter
     */
    public Rectangle getPerimetro() {
        return new Rectangle (getX(), getY(), getWidth(), getHeight());
    }
    
    
    /**
     * Validate if there was an intersection 
     * @param obj
     * @return intersection
     */
//    public boolean intersecta(Object obj) {
//                                                                //Castea
//        return obj instanceof Bad && getPerimetro().intersects(((Bad) obj).getPerimetro());
//    }

    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
//        g.drawImage(Assets.box, getX(), getY(), getWidth(), getHeight(), null);
    }
}
