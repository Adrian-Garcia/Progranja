/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author adria
 */
public class Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // creating a Game object
        Game g = new Game("Juego", 1250, 700);
        
        // initializing the game
        g.start();
    }   
}