/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

/**
 *
 * @author adria
 */
public class Bad extends Item{

    private int width;
    private int height;
    private Game game;
    private int prevX;
    private int prevY;
    private boolean finish;
    private int direction;
    private int delay;
    private Animation animationUp;
    private Animation animationLeft;
    private Animation animationDown;
    private Animation animationRight;
    private LinkedList<Integer> forInstructions;
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Bad(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.prevX = x;
        this.prevY = y;
        this.direction = 2;
        this.delay = 0;
        this.animationUp = new Animation(Assets.badUp, 100);
        this.animationLeft = new Animation(Assets.badLeft, 100);
        this.animationDown = new Animation(Assets.badDown, 100);
        this.animationRight = new Animation(Assets.badRight, 100);
        forInstructions = new LinkedList<Integer>();
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
     * To make game know if all the instructions where done
     * @return 
     */
    public boolean getFinish() {
        return finish;
    }
    
    /**
     * Setter of finish
     * @param finish 
     */
    public void setFinish(boolean finish) {
        this.finish = finish;
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
     * Get the direction of the bad
     * @return direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Set the direction of the bad
     * @param direction 
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    /**
     * Control the bad movement 
     * Manage with numbers to know where direction to go
     * For loops can be done as well
     */
    @Override
    public void tick() {
        
        if (delay > 3) {
            
            if (game.getPlayerX() - x < 0) {
                setX(getX() - 1);
                setDirection(1);
                this.animationLeft.tick();
            } 

            if (game.getPlayerX() - x > 0) {
                setX(getX() + 1);
                setDirection(2);
                this.animationRight.tick();
            }

            if (game.getPlayerY() - y < 0) {
                setY(getY() - 1);
                setDirection(3);
                this.animationUp.tick();
            }

            if (game.getPlayerY() - y > 0) {    
                setY(getY() + 1);
                setDirection(4);
                this.animationDown.tick();
            }
            
            delay = -1;
        } 
        
        delay++;
    }
    
    /**
     * Get perimeter of bad for collisions
     * @return 
     */
    public Rectangle getPerimetro() {
        return new Rectangle (getX(), getY(), getWidth() -15, getHeight() -15) ;
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
     * render the image of the bad
     * @param g 
     */
    @Override
    public void render(Graphics g) {
         if (getDirection() == 3) {
                    g.drawImage(animationUp.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);

                }
                if (getDirection() == 4) {
                    g.drawImage(animationDown.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);

                }
                if (getDirection() == 1) {
                    g.drawImage(animationLeft.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);

                }
                if (getDirection() == 2) {
                    g.drawImage(animationRight.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);

                }
    }
}
