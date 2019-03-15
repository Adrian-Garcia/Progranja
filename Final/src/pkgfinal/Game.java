/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author adria
 */
public class Game implements Runnable{

    private BufferStrategy bs;  // to have several buffers when displaying
    private Graphics g;         // to paint objects
    private Display display;    // to display in the game
    String title;               // title of the window
    private int width;          // width of the window
    private int height;         // height of the window
    private Thread thread;      // thread to create the game
    private boolean running;    // to set the game
    
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
    }
    
    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, width, height);
    }
    
    @Override
    public void run() {
        init();
        while (running) {
            tick();
            render();
        }
        stop();
    }
    
    private void tick() {
        
    }
    
    private void render() {
        
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectangle, getting the graphic object from the 
        buffer strategy element.
        show the graphic and dispose it to the trash system
        */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        }
        else {
            g = bs.getDrawGraphics();
            g.clearRect(0, 0, width, height);
            g.setColor(Color.red);
            g.drawRect(10,10,40,40);
            bs.show();
            g.dispose();
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
