/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

/**
 *
 * @author adria
 */
public class Game implements Runnable{

    private BufferStrategy bs;          // to have several buffers displaying
    private Graphics g;                 // to paint objects
    private Display display;            // to display in the game
    String title;                       // title of the window
    private int width;                  // width of the window
    private int height;                 // height of the window
    private Thread thread;              // thread to create the game
    private boolean running;            // to set the game
    private Player player1;             // to use player 1
    private Player player2;             // to use player 2
    private Block block1;               // to use block
    private Block block2;               // to use block
    private Block block3;               // to use block
    private LinkedList<Button> buttons; // to use buttons
    private Bar bar;                    // to use bar
    private Bar Bar;                    // to use bar
    private Bar barUp;                    // to use bar
    private Arrow arrowUp;              // to use arrowUp
    private Arrow arrowDown;            // to use arrowDown
    private Arrow arrowLeft;            // to use arrowLeft
    private Arrow arrowRight;           // to use arrowRight
    private Arrow fireball;             // to use fireball to atack
    private Arrow shield;               // to use shield to defend
    private Arrow play;                 // to play the secuence
    private moveArrow mArrowUp;         // to use arrowUp
    private moveArrow mArrowDown;       // to use arrowDown
    private moveArrow mArrowLeft;       // to use arrowLeft
    private moveArrow mArrowRight;      // to use arrowRight
    private moveArrow mFireball;        // to use fireball to atack
    private moveArrow mShield;          // to use shield to defend

    
    private MouseManager mouseManager;  // to manage the mouse
    
    /**
     * to create title, width and height and set the game is still not running
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the hight of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        mouseManager = new MouseManager();
        buttons = new LinkedList<Button>();
    }
    
    /**
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set title of the game
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * initializing the display window of the game
     */
    private void init() {
        
        display = new Display(title, width, height);
        
        Assets.init();
        
        // Bar
        bar = new Bar(1100, 0, 150, 700, 1, this);
        Bar = new Bar(950, 0, 150, 700, 2, this);
        barUp = new Bar(0, 0, 950, 30, 3, this);
        
        //Block lines
        block1 = new Block(0, 140, 500, 50, this);
        block2 = new Block(450, 500, 500, 50, this);
        block3 = new Block(260, 320, 500, 50, this);
        
        // Generate buttons
        for (int i=0; i<4; i++) {
            buttons.add(new Button(i*300+60, 320, 200, 60, i+1, false, this));
        }
        
        player1 = new Player(850, 600, 90, 90, 1, this);
        player2 = new Player(10, 40, 80, 90, 2, this);
        
        // Arrows
        arrowUp = new Arrow(975, 10, 100, 100, 0, this);
        arrowDown = new Arrow(975, 100, 100, 100, 1, this);
        arrowLeft = new Arrow(975, 190, 100, 100, 2, this);
        arrowRight = new Arrow(975, 270, 100, 100, 3, this);
        
        // Powers
        fireball = new Arrow(975, 360, 100, 100, 4, this);
        shield = new Arrow(975, 460, 100, 100, 5, this);
        play = new Arrow(975, 570, 100, 100, 6, this);
        
        // move Arrows
        mArrowUp = new moveArrow(1540, 10, 150, 150, 0, this);
        mArrowDown = new moveArrow(1540, 160, 150, 150, 1, this);
        mArrowLeft = new moveArrow(1540, 300, 150, 150, 2, this);
        mArrowRight = new moveArrow(1540, 430, 150, 150, 3, this);
        
        // move Powers
        mFireball = new moveArrow(1540, 570, 150, 150, 4, this);
        mShield = new moveArrow(1540, 730, 150, 150, 5, this);
        
        //Mouse methods
        display.getJframe().addMouseListener(mouseManager);
        display.getJframe().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
    }
    
    @Override
    public void run() {
        init();
        // frames per second
        int fps = 50;
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running) {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            // updating the last time
            lastTime = now;

            // if delta is positive we tick the game
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }
    
    /**
     * Used to control mouse
     * @return 
     */
    public MouseManager getMouseManager() {
        return mouseManager;
    }
    
    private void tick() {
        
        // move Arrows
        mArrowUp.tick();
        mArrowDown.tick();
        mArrowLeft.tick();
        mArrowRight.tick();
        
        // move Powers
        mFireball.tick();
        mShield.tick();
        
        for (int i=0; i<buttons.size(); i++) {
            
            Button button = buttons.get(i);
            button.tick();
        }
    }
    
    private void render() {
        
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectanlge, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
         */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            
            if (buttons.get(0).getPressed()) {
                
                
                
                g = bs.getDrawGraphics();
                g.drawImage(Assets.cian, 0, 0, width, height, null);
                
                player1.render(g);
                player2.render(g);
                
                block1.render(g);
                block2.render(g);
                block3.render(g);
                
                bar.render(g);
                Bar.render(g);
                barUp.render(g);

                arrowUp.render(g);
                arrowDown.render(g);
                arrowLeft.render(g);
                arrowRight.render(g);
                
                fireball.render(g);
                shield.render(g);
                play.render(g);
                
                mArrowUp.render(g);
                mArrowDown.render(g);
                mArrowLeft.render(g);
                mArrowRight.render(g);
                
                mFireball.render(g);
                mShield.render(g);
                
                String a = "Health: 100             Mana: 100";
                g.drawString(a, 10, 20);
                
                bs.show();
                g.dispose();
            }
            
            else {
                
                g = bs.getDrawGraphics();
                g.drawImage(Assets.background, 0, 0, width, height, null);

                for (int i = 0; i < buttons.size(); i++) {
                    Button button = buttons.get(i);
                    button.render(g);
                }

                bs.show();
                g.dispose();
            }
        }
    }
    
    /**
     * setting the thread for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    
    /**
     * stopping the thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
