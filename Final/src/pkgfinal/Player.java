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
public class Player extends Item{

    private int width;
    private int height;
    private Game game;
    private int playerNo;
    private int index;
    
    /**
     * Box constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Player(int x, int y, int width, int height, int playerNo, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.playerNo = playerNo;
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
    public int getPlayerNo() {
        return playerNo;
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
            
            if (!game.getShootFire() && !game.getShootShield()) {
                
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
                }
            }
            
            switch (game.getInstructionAt(index)) {
                
                case 4:
                    game.setShootFire(!game.getShootFire());
                break;
                
                case 5:
                    game.setShootShield(!game.getShootShield());
                break;
                
//                case 6:
//                    game.setShootShield(true);
//                break;
//                
//                case 7:
//                    game.setShootShield(false);
//                break;
            }
        }
    }

    /**
     * render the image of the player 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        
        switch (playerNo) {
            
            case 1:
                g.drawImage(Assets.player1, getX(), getY(), getWidth(), getHeight(), null);
            break;
            
            case 2:
                g.drawImage(Assets.player2, getX(), getY(), getWidth(), getHeight(), null);
            break;
        }
    }
}
