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
    public static BufferedImage Playersprites;
    public static BufferedImage playerUp[];
    public static BufferedImage playerLeft[];
    public static BufferedImage playerDown[];
    public static BufferedImage playerRight[];
    public static BufferedImage farm; 
    public static BufferedImage wood;
    public static BufferedImage instrucciones;
    public static BufferedImage background;     // to store background image
    public static BufferedImage pasto;           // to store cian color
    public static BufferedImage clearGray;      // to store gray color
    public static BufferedImage bar;            // to store bar image
    public static BufferedImage button;         // to store button image
    public static BufferedImage block;          // to store button image

    public static BufferedImage fireball;       // to store fireball
    public static BufferedImage shield;         // to store shiel
    public static BufferedImage play;           // to store play
    public static BufferedImage hearth;           // to store play

    public static SoundClip music;              // to store music for the game
    public static SoundClip moo;                // to store moo sound
    
    /**
     * initializing the images of the game
     */
    public static void init() {
         
        Playersprites = ImageLoader.loadImage("/images/spritenuevo.png");
        
        SpreadSheet spritesheet = new SpreadSheet(Playersprites);
        playerUp = new BufferedImage[4];
        playerLeft = new BufferedImage[4];
        playerDown = new BufferedImage[4];
        playerRight = new BufferedImage[4];
        
        for (int i = 0; i < 4 ; i++){
           playerUp[i] = spritesheet.crop(i * 76, 0, 76, 77);
            playerLeft[i] = spritesheet.crop(i * 76, 77, 76, 77);
            playerDown[i] = spritesheet.crop(i * 76, 154, 76, 77);
            playerRight[i] = spritesheet.crop(i * 76, 231, 76, 77);
        }
        
        farm = ImageLoader.loadImage("/images/farmhouse.png");
        wood = ImageLoader.loadImage("/images/boardlargo.png");
        background = ImageLoader.loadImage("/images/gray.jpg");
        clearGray = ImageLoader.loadImage("/images/clearGray.jpg");
        pasto = ImageLoader.loadImage("/images/2278.jpg");
        bar = ImageLoader.loadImage("/images/cian.jpg");
        block = ImageLoader.loadImage("/images/block.png");
        button = ImageLoader.loadImage("/images/button.png");
        instrucciones = ImageLoader.loadImage("/images/instrucciones.png");
        
        fireball = ImageLoader.loadImage("/images/fireball.png");
        shield = ImageLoader.loadImage("/images/shield.png");
        play = ImageLoader.loadImage("/images/play.png");
        hearth = ImageLoader.loadImage("/images/Vidas.png");
        
        music = new SoundClip("/sounds/music.wav");
        moo = new SoundClip("/sounds/moo.wav");
    }
}