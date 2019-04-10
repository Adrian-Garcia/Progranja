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

    public static BufferedImage background;     // to store background image
    public static BufferedImage bar;            // to store bar image
    public static BufferedImage button;         // to store button image
    public static BufferedImage arrowUp;        // to store arrow up button
    public static BufferedImage arrowDown;      // to store arrow down button
    public static BufferedImage arrowLeft;      // to store arrow left button
    public static BufferedImage arrowRight;     // to store arrow right button

    /**
     * initializing the images of the game
     */
    public static void init() {
        
        background = ImageLoader.loadImage("/images/gray.jpg");
        bar = ImageLoader.loadImage("/images/cian.jpg");
        button = ImageLoader.loadImage("/images/button.png");
        
        arrowUp = ImageLoader.loadImage("/images/arrowUp.png");
        arrowDown = ImageLoader.loadImage("/images/arrowDown.png");
        arrowLeft = ImageLoader.loadImage("/images/arrowLeft.png");
        arrowRight = ImageLoader.loadImage("/images/arrowRight.png");
    }
}