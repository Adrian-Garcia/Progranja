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
    private int noLives;                // number of lives of player 
    private int instructions;           // number of instructions
    private int turn;                   // number of the player that have the turn
    private boolean playPressed;        // to know if user play the game
    private boolean running;            // to set the game
    private boolean newInst;            // to now if game need new instruction
    private boolean shootFire;          // to know if player shoot a fireball
    private boolean shootShield;        // to know if player shoot a shield
    private Thread thread;              // thread to create the game
    private Player player1;             // to use player 1
    private Player player2;             // to use player 2
    private LinkedList<Button> buttons; // to use buttons
    private LinkedList<Block> blocks;   // to use blocks
    private LinkedList<Bar> bars;       // to use Bars
    private LinkedList<Integer> Instructions;// to use Instructions as numbers
    private LinkedList<Instruction>Inst;// to use Instructions items
    private LinkedList<Live> lives;     // to use lives
    private Action arrowUp;             // to use arrowUp
    private Action arrowDown;           // to use arrowDown
    private Action arrowLeft;           // to use arrowLeft
    private Action arrowRight;          // to use arrowRight
    private Action fireball;            // to use fireball to atack
    private Action shield;              // to use shield to defend
    private Action play;                // to play the secuence
    private Power fire;                 // to use fireball
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
        this.newInst = false;
        this.instructions = 0;
        this.noLives = 3;
        this.shootFire = false;
        this.shootShield = false;
        running = false;
        playPressed = false;
        turn = 1;
        mouseManager = new MouseManager();
        buttons = new LinkedList<Button>();
        blocks = new LinkedList<Block>();
        bars = new LinkedList<Bar>();
        Instructions = new LinkedList<Integer>();
        Inst = new LinkedList<Instruction>();
        lives = new LinkedList<Live>();
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
    
    public int getInstructionAt(int i) {
        return Instructions.get(i);
    }
    
    /**
     * To get number of instructions
     * @return instructions
     */
    public int getInstructions() {
        return Instructions.size();
    }
    
    /**
     * Get if a Fireball was shooted
     * @return shootFire
     */
    public boolean getShootFire() {
        return shootFire;
    }
    
    /**
     * Get if a Shield was shooted
     * @return shootShield
     */
    public boolean getShootShield() {
        return shootShield;
    }
    
    /**
     * Set  number of instructions
     * @param instructions 
     */
    public void setInstructions(int instructions) {
        this.instructions = instructions;
    }

    /**
     * Set title of the game
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Set if a Fireball is being shooted
     * @param shootFire 
     */
    public void setShootFire(boolean shootFire) {
        this.shootFire = shootFire;
    }
    
    /**
     * Set if a Shield is being shooted
     * @param shootFire 
     */
    public void setShootShield(boolean shootFire) {
        this.shootShield = shootShield;
    }
    
    /**
     * Add instruction arrow
     * @param val 
     */
    public void newInst(int val) {
        instructions++;
        Inst.get(instructions).setVal(val);
    }
    
    /**
     * initializing the display window of the game
     */
    private void init() {
        
        display = new Display(title, width, height);
        
        Assets.init();
        
        // Generate Bars
        bars.add(new Bar(1100, 0, 150, 700, 1, this));
        bars.add(new Bar(950, 0, 150, 700, 2, this));
        bars.add(new Bar(0, 0, 950, 50, 3, this));
        
        // Instrucciones dummies
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        Instructions.add(2);
        
//        Instructions.add(0);
//        Instructions.add(0);
//        Instructions.add(0);
//        Instructions.add(0);
//        
//        Instructions.add(4);
//        
//        Instructions.add(0);
//        Instructions.add(0);
//        Instructions.add(0);
//        
//        Instructions.add(4);
        
        instructions = Instructions.size();
        
        // Generate lives
        for (int i=0; i<noLives; i++) {
            lives.add(new Live(i*40+55, 5, 40, 40, this));
        }
        
        // Generate Buttons
        for (int i=0; i<4; i++) {
            buttons.add(new Button(i*300+60, 320, 200, 60, i+1, false, this));
        }
        buttons.add(new Button(510, 420, 200, 60, 4, false, this));
        
        // Generate Blocks
        for (int i=0; i<13; i++) {
            blocks.add(new Block(0, i*50+50, 50, 50, this));
        } for (int i=0; i<18; i++) {
            blocks.add(new Block(i*50+50, 50, 50, 50, this));
        } for (int i=0; i<12; i++) {
            blocks.add(new Block(900, i*50+100, 50, 50, this));
        } for (int i=0; i<17; i++) {
            blocks.add(new Block(i*50+50, 650, 50, 50, this));
        }
        
        // Generate instructionss
        for (int i=0; i<10; i++) {
            Inst.add(new Instruction(1150, i*70+5, 70, 70, -1, i+1, this));
        }
        
        // Generate Players 
        player1 = new Player(900, 605, 40, 40, 1, this);
        player2 = new Player(55, 105, 40, 40, 2, this);
        
        // Generate Arrows
        arrowUp = new Action(975, 10, 100, 100, 0, this);
        arrowDown = new Action(975, 100, 100, 100, 1, this);
        arrowLeft = new Action(975, 190, 100, 100, 2, this);
        arrowRight = new Action(975, 270, 100, 100, 3, this);
        
        // Generate Actions
        fireball = new Action(975, 705, 100, 100, 4, this);
        shield = new Action(975, 460, 100, 100, 5, this);
        play = new Action(975, 570, 100, 100, 6, this);
        
        // Generate Powers
        fire = new Power(900, 605, 40, 40, this);
        
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
        
        // press Buttons
        for (int i=0; i<buttons.size(); i++) {
            Button button = buttons.get(i);
            button.tick();
        }
        
        // Tick and collide Blocks
        for (int i=0; i<blocks.size(); i++) {
            
            Block block = blocks.get(i);
            block.tick();
            
            // Checking collition between player and block
            if (player1.intersecta(block)) {
                player1.setX(player1.getPrevX());
                player2.setY(player1.getPrevY());
            }
        }
        
        // If level 1 is started
        if (buttons.get(0).getPressed()) {
            player1.tick();
            fire.tick();
        }
        
//        arrowUp.tick();
//        arrowDown.tick();
//        arrowLeft.tick();
//        arrowRight.tick();
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

                for (int i=0; i<bars.size(); i++) {
                    Bar bar = bars.get(i);
                    bar.render(g);
                }
                
                for (int i=0; i<blocks.size(); i++) {
                    Block block = blocks.get(i);
                    block.render(g);
                }
                
                player1.render(g);
                player2.render(g);
                
                fire.render(g);
                
                for (int i=0; i<Inst.size(); i++) {
                    Instruction instruction = Inst.get(i);
                    instruction.render(g);
                }
                
                for (int i=0; i<noLives; i++) {
                    Live live = lives.get(i);
                    live.render(g);
                }
                
                arrowUp.render(g);
                arrowDown.render(g);
                arrowLeft.render(g);
                arrowRight.render(g);
                
                fireball.render(g);
                shield.render(g);
                play.render(g);
                
                String a = "Health:                                                                                      Mana: 100";
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
