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
public class Instruction extends Item{

    private int width;
    private int height;
    private Game game;
    private int instNo;
    private int val;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Instruction(int x, int y, int width, int height, int val, int instNo, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.instNo = instNo;
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
     * Get the value of the instruction
     * @return 
     */
    public int getVal() {
        return val;
    }
    
    /**
     * Get the number of the instruction
     * @return 
     */
    public int getInstNo() {
        return instNo;
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
     * Set the value of instruction number
     * @param instNo 
     */
    public void setInstNo(int instNo) {
        this.instNo = instNo;
    }
    
    /**
     * Set the value of the instruction
     * @param val 
     */
    public void setVal(int val) {
        this.val = val;
    }
    
    /**
     * Set the status of pressed button
     * @param pressed 
     */
    public void setPressed(boolean pressed) {
        this.game.newInst(val);
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
        }
    }
}
