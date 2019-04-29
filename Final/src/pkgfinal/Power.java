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
public class Power extends Item{

    private int width;
    private int height;
    private Game game;
    private int powerType;
    private int index;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Power(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.index = -1;
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
    public int getPowerType() {
        return powerType;
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
        
        if (index < game.getInstructions()-1) {
            
            index++;
            
            switch (game.getInstructionAt(index)) {
                
                case 0: // Up
                    setY(getY() - 50);
                break;
                
                case 1: // Down
                    setY(getY() + 50);
                break;
                
                case 2: // Left
                    setX(getX() - 50);
                break;
                
                case 3: // Right
                    setX(getX() + 50);
                break;
            }
        }
    }

    /**
     * Get perimeter of player for collisions
     * @return 
     */
    public Rectangle getPerimetro() {
        return new Rectangle (getX(), getY(), getWidth(), getHeight());
    }
    
    /**
     * Validate if there was an intersection 
     * @param obj
     * @return intersection
     */
    public boolean intersecta(Object obj) {
                                                                //Castea
        return obj instanceof Player && getPerimetro().intersects(((Player) obj).getPerimetro());
    }
    
    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.fireball, getX(), getY(), getWidth(), getHeight(), null);
    }
}