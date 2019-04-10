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
public class moveArrow extends Item{

    private int width;
    private int height;
    private Game game;
    private int val;
    private int speedX;
    private int speedY;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public moveArrow(int x, int y, int width, int height, int val, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.val = val;
        this.speedX = 0;
        this.speedY = 0;
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
     * Get the value of speed in X 
     * @return 
     */
    public int getSpeedX() {
        return speedX;
    }
    
    /**
     * Get the value of speed in Y
     * @return 
     */
    public int getSpeedY() {
        return speedY;
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
//        if (game.getMouseManager().isIzquierdo()) {
            this.setX(game.getMouseManager().getX() - (getHeight() / 2));
            this.setY(game.getMouseManager().getY() - (getHeight() / 2));
            game.getMouseManager().setIzquierdo(false);                  
        }
        
        setX(getX() + getSpeedX());
        setY(getY() + getSpeedY());
        
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
