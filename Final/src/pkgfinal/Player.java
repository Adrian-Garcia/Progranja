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
public class Player extends Item{

    private int width;
    private int height;
    private Game game;
    private int playerNo;
    private int index;
    private int prevX;
    private int prevY;
    private boolean finish;
    private int counter;
    private int direction;
    private int forPosition;
    private int forIndex;
    private int forLimit;
    private boolean forStart;
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
    public Player(int x, int y, int width, int height,int direction, int playerNo, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.playerNo = playerNo;
        this.index = 0;
        this.prevX = x;
        this.prevY = y;
        this.counter = 0;
        this.forStart = false;
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
     * Get the value of the arrow
     * @return 
     */
    public int getPlayerNo() {
        return playerNo;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    
    /**
     * Control the player movement 
     */
    @Override
    public void tick() {
        
        if (index < game.getInstructions()) {
            
            if (!game.getShootFire() && !game.getShootShield()) {
                
                counter++;
                
                if (counter > 7) {
                
                    counter = 0;
                    
                    switch (game.getInstructionAt(index)) {

                        case 0: // Up
                            setPrevY(getY());
                            setY(getY() - 65);
                            setDirection(0);
                            this.animationUp.tick();
                        break;

                        case 1: // Down
                            setPrevY(getY());
                            setY(getY() + 65);
                            setDirection(1);
                            this.animationDown.tick();
                        break;

                        case 2: // Left
                            setPrevX(getX());
                            setX(getX() - 50);
                            setDirection(2);
                            this.animationLeft.tick();
                        break;

                        case 3: // Right
                            setPrevX(getX());
                            setX(getX() + 50);
                            setDirection(3);
                            this.animationRight.tick();
                        break;

                        case 4: // Throw a fire ball
                            game.setShootFire(!game.getShootFire());
                        break;

                        case 5: // Throw a Shield
                            if (game.getShootShield()){
                                game.setShootShield(false);
                            }
                            else {
                                game.setShootShield(true);
                            }    
                        break;
                        
                        case 10: 
                            if (forStart){
                                index = forPosition;
                                forIndex++;
                            }
                        break;
                        
                        case 11:
                            forLimit = 1;
                            forStart = true;
                        break;
                            
                        case 12: 
                            forLimit = 2;
                            forStart = true;
                        break;
                        
                        case 13: 
                            forLimit = 3;
                            forStart = true; 
                        break;
                            
                        case 14: 
                            forLimit = 4;
                            forStart = true;  
                        break;
                        
                        case 15: 
                            forLimit = 5;
                            forStart = true;  
                        break;
                            
                        case 16: 
                            forLimit = 6;
                            forStart = true;  
                        break;
                        
                        case 17: 
                            forLimit = 7;
                            forStart = true;  
                        break;
                        
                        case 18: 
                            forLimit = 8;
                            forStart = true;  
                        break;
                        
                        case 19: 
                            forLimit = 9;
                            forStart = true;  
                        break;
                        
                        case 20: 
                            forLimit = 10;
                            forStart = true;  
                        break;
                    }

                    index++;
                }
            }
        }
        
        // Player finish
        else {
            finish = true;
            index=0;
        }
    }
    
    /**
     * Get perimeter of player for collisions
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
        return obj instanceof Block && getPerimetro().intersects(((Block) obj).getPerimetro());
    }
    
    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        
        switch (playerNo) {

            case 1:
                if (getDirection() == 0) {
                    g.drawImage(animationUp.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);

                }
                if (getDirection() == 1) {
                    g.drawImage(animationDown.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);

                }
                if (getDirection() == 2) {
                    g.drawImage(animationLeft.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);

                }
                if (getDirection() == 3) {
                    g.drawImage(animationRight.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);

                }
                break;

            case 2:
                g.drawImage(Assets.farm, getX(), getY(), getWidth(), getHeight(), null);
                break;
        }
    }
}
