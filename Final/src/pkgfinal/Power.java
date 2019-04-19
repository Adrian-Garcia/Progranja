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
    public Power(int x, int y, int width, int height, /*int powerType,*/ Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.powerType = powerType;
        this.index = 0;
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
        
        if (index < game.getInstructions()) {
            
            switch (game.getInstructionAt(index)) {
                
                case 0: // Up
                    setY(getY() - 50);
                    index++;
                break;
                
                case 1: // Down
                    setY(getY() + 50);
                    index++;
                break;
                
                case 2: // Left
                    setX(getX() - 50);
                    index++;
                break;
                
                case 3: // Right
                    setX(getX() + 50);
                    index++;
                break;
                
                case 6: // Up
                    setY(getY() - 50);
                    index++;
                break;
                
                case 7: // Down
                    setY(getY() + 50);
                    index++;
                break;
                
                case 8: // Left
                    setX(getX() - 50);
                    index++;
                break;
                
                case 9: // Right
                    setX(getX() + 50);
                    index++;
                break;
            }
        }
    }

    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        
//        g.drawImage(Assets.fireball, getX(), getY(), getWidth(), getHeight(), null);
        
        switch (game.getInstructionAt(index)) {
            
            case 4:
                g.drawImage(Assets.fireball, getX(), getY(), getWidth(), getHeight(), null);
            break;
            case 5:
                g.drawImage(Assets.fireball, getX(), getY(), getWidth(), getHeight(), null);
            break;
            case 6:
                g.drawImage(Assets.fireball, getX(), getY(), getWidth(), getHeight(), null);
            break;
            case 7:
                g.drawImage(Assets.fireball, getX(), getY(), getWidth(), getHeight(), null);
            break;
            case 8:
                g.drawImage(Assets.fireball, getX(), getY(), getWidth(), getHeight(), null);
            break;
            case 9:
                g.drawImage(Assets.fireball, getX(), getY(), getWidth(), getHeight(), null);
            break;
            case 10:
                g.drawImage(Assets.shield, getX(), getY(), getWidth(), getHeight(), null);
            break;
        }
    }
}
