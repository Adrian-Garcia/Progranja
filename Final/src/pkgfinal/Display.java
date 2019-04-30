/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author adria
 */
public class Display {
    public JFrame jframe;  // this is the app class
    private Canvas canvas;  // to display images
    
    private String title;   // title of the window
    private int width;      // width of the window
    private int height;     // height of the window
    
    private boolean start;  // To know if game has start
    public JTextField t1;  // To put a textfield at the game
            
            
    /**
     * initializes the values for the application game
     * @param title to display the title of the window
     * @param width to set the width
     * @param height to set the height
     */
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.start = start;        
        createDisplay();
    }
    
    /**
     * Setter of title
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * To get if the game has start
     * @return 
     */
    public boolean getStart() {
        return start;
    }
    
    /**
     * Setter to start the game
     * @param start 
     */
    public void setStart(boolean start) {
        
        System.out.println("1");
        
        boolean prev = this.start;
        
        if (prev != start) {
            if (start) {
                initTextField();
            }
        }   
        
        System.out.println("3");
        this.start = start;
        
    }
    
    /**
     * create the app and the canvas and add the canvas to the window app
     */
    public void createDisplay() {
        // create the app window
        jframe = new JFrame(title);
        
        // set the size of the window
        jframe.setSize(width, height);
        
        // setting not resizable, visible and possible to close
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        
        // creating the canvas to paint and setting size
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        // adding the canvas to the app window and packing to
        // get the right dimensions
        jframe.add(canvas);
        jframe.pack();
    }

    /**
     * to get the jframe of the game
     * @return jframe
     */
    public JFrame getJframe() {
        return jframe;
    }
    
    /**
     * to get the canvas of the game
     * @return the canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }
    
    public void initTextField() {
        System.out.println("2");
        JTextField t1 = new JTextField("Instrucciones: ");  
        t1.setBounds(975, 630, 250,30);
        jframe.add(t1);
        System.out.println("2");
    }
}
