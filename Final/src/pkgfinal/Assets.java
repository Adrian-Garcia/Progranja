/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.image.BufferedImage;

/**
 *
 * @author adria
 */
public class Assets {

    public static BufferedImage player1;     // to store background image
    public static BufferedImage player2;     // to store background image
    public static BufferedImage background;     // to store background image
    public static BufferedImage cian;           // to store wood image
    public static BufferedImage clearGray;      // to store wood image
    public static BufferedImage bar;            // to store bar image
    public static BufferedImage button;         // to store button image
    public static BufferedImage block;         // to store button image
    public static BufferedImage arrowUp;        // to store arrow up button
    public static BufferedImage arrowDown;      // to store arrow down button
    public static BufferedImage arrowLeft;      // to store arrow left button
    public static BufferedImage arrowRight;     // to store arrow right button
    public static BufferedImage fireball;       // to store fireball
    public static BufferedImage shield;         // to store shiel
    public static BufferedImage play;           // to store play
    

    /**
     * initializing the images of the game
     */
    public static void init() {
        
        player1 = ImageLoader.loadImage("/images/player1.png");
        player2 = ImageLoader.loadImage("/images/player2.png");
        
        background = ImageLoader.loadImage("/images/gray.jpg");
        clearGray = ImageLoader.loadImage("/images/clearGray.jpg");
        cian = ImageLoader.loadImage("/images/cian.jpg");
        bar = ImageLoader.loadImage("/images/cian.jpg");
        block = ImageLoader.loadImage("/images/line.png");
        button = ImageLoader.loadImage("/images/button.png");
        
        arrowUp = ImageLoader.loadImage("/images/arrowUp.png");
        arrowDown = ImageLoader.loadImage("/images/arrowDown.png");
        arrowLeft = ImageLoader.loadImage("/images/arrowLeft.png");
        arrowRight = ImageLoader.loadImage("/images/arrowRight.png");
        
        fireball = ImageLoader.loadImage("/images/fireball.png");
        shield = ImageLoader.loadImage("/images/shield.png");
        play = ImageLoader.loadImage("/images/play.png");
    }
}