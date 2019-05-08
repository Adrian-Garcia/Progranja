/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.Font;
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
    private int index;                  // index
    private boolean running;            // to set the game
    private boolean newInst;            // to now if game need new instruction
    private boolean shootFire;          // to know if player shoot a fireball
    private boolean shootShield;        // to know if player shoot a shield
    private boolean gameStarted;        // To know if the game has begun
    private boolean run;                // To make the player to begin
    private boolean win;                // to win
    private boolean loss;               // to lose
    private boolean level1;             // to go to level 1
    private boolean level2;             // to go to level 2
    private boolean level3;             // to go to level 3
    private boolean level4;             // to go to level 4
    private boolean level5;             // to go to level 5
    private boolean loop;               // to know if there is a loop
    private boolean changeLevel;        // to make the game know when to change game
    private Thread thread;              // thread to create the game
    private Player cow;                 // to use player 1
    private Bad wolf;                   // to use wolfs
    private Casa farm;                  // to win levels
    private Bar wood;                   // to use Bars
    private Power fire;                 // to use fireball
    private Button help;                // to display instructions of the game
    private Window window;              // to display windows
    private Power powerShield;          // to use shield
    private LinkedList<Boolean> Ident;  // to know if it is necesary to ident
    private LinkedList<String> Inst;    // to show instructions to the user
    private LinkedList<Block> blocks;   // to use blocks
    private LinkedList<Integer> Instructions;// to use Instructions as numbers
    private LinkedList<Live> lives;     // to use lives
    private KeyManager keyManager;      // to manage the keyboard
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
        this.noLives = 5;
        this.shootFire = false;
        this.shootShield = false;
        this.running = false;
        this.gameStarted = false;
        this.turn = 1;
        this.run = false;
        this.index = 0;
        this.win = false;
        this.loss = false;
        this.level1 = false;
        this.level2 = false;
        this.level3 = false;
        this.level4 = false;
        this.level5 = false;
        this.loop = false;
        mouseManager = new MouseManager();
        keyManager = new KeyManager();
        blocks = new LinkedList<Block>();
        Instructions = new LinkedList<Integer>();
        Inst = new LinkedList<String>();
        Ident = new LinkedList<Boolean>();
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
    
    /**
     * To get instruction at certain position
     * @param i
     * @return instruction at i
     */
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
    }
    
    /**
     * Get the position value of X of the cow
     * @return cow.x
     */
    public int getPlayerX() {
        return cow.getX();
    }
    
    /**
     * Get the position value of Y of the cow
     * @return cow.y
     */
    public int getPlayerY() {
        return cow.getY();
    }
    
    /**
     * Restart the instructions, clear the screen
     */
    public void clear() {
        
        for (int i=0; i<Inst.size(); i++) {
            Inst.set(i, "");
            Ident.set(i,false);
            index = 0;
        }
        
        Instructions.clear();
    }
    
    /**
     * initializing the display window of the game
     */
    private void init() {
        
        display = new Display(title, width, height);
        
        Assets.init();
        
        // Generate Bars
        wood = new Bar(960, 25, 280, 650, this);
        
        // Generate Button of information
        help = new Button(0, 200, 25, 100, this);
        
        // Generate Window with information
        window = new Window(-1000, -1000, 700, 300, this);
        
        // Generate lives
        for (int i=0; i<noLives; i++) {
            lives.add(new Live(i*70+55, 30, 60, 65, this));
        }
        
        // Generate Instructions
        for (int i=0; i<30; i++) {
            Inst.add(new String(""));
            Ident.add(false);
        }
        
        // Generate Blocks
        // eje y izquierdo
        for (int i=0; i<5; i++) {
            blocks.add(new Block(50, i*75+150, 50, 65, this));
        }
        // eje y derecho
        for (int i=0; i<5; i++) {
            blocks.add(new Block(800, i*75+275, 50, 65, this));
        }
        
        // eje x arriba
         for (int i=0; i<8; i++) {
            blocks.add(new Block(i*75+130, 150, 50, 65, this));
        } 
        //eje x abajo
        for (int i=0; i<8; i++) {
            blocks.add(new Block(i*75+200, 575, 50, 65, this));
        }
        
        // eje x medio izquierdo
         for (int i=0; i<5; i++) {
            blocks.add(new Block(i*75+115, 425, 50, 65, this));
        }
        // eje x medio derecho
        for (int i=0; i<6; i++) {
            blocks.add(new Block(i*75+350, 300, 50, 65, this));
        }
        
        // Generate Player
//        cow = new Player(600, 200, 75, 75, 0 , 1, this);
        cow = new Player(105, 555, 75, 75, 0 , this);
        
        // Generate Farm
        farm = new Casa(700, 50, 325, 325, this);

        // Generate Enemy
        wolf = new Bad(400, 555, 100, 100, this);
        
        // Generate Powers
        fire = new Power(850, 605, 40, 40, this);
        powerShield = new Power(850, 605, 40, 40, this);
        
        //Key and Mouse methods
        display.getJframe().addKeyListener(keyManager);
        display.getJframe().addMouseListener(mouseManager);
        display.getJframe().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        
        //Start music
//        Assets.music.play();
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
     * Used to control keys
     * @return keyManager
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }
    
    /**
     * Used to control mouse
     * @return 
     */
    public MouseManager getMouseManager() {
        return mouseManager;
    }
    
    private void initLevel(int level) {
        
        for (int i=0; i<blocks.size(); i++) {
            Block block = blocks.get(i);
            block.setX(-100);
        }
        
        cow.setX(-100);
        wolf.setX(-100);
        farm.setX(-100);
        
        int i=0;
        
        switch(level) {
            
            case 1:     // Level 1
                
                for (;i<blocks.size(); i++) {
                    Block block = blocks.get(i);
                    block.setX(50);
                    block.setY(30);
                }
                
                cow.setX(600);
                cow.setY(200);
                
                farm.setX(700);
                farm.setY(50);
                
            break;
            
            case 2:     // Level 2
            break;
            
            case 3:     // Level 3
            break;
            
            case 4:     // Level 4
                
                cow.setX(100);
                cow.setY(555);
                
                wolf.setX(800);
                wolf.setY(555);
                
                farm.setX(700);
                farm.setY(50);
            
            break;
            
            case 5:     // Level 5
            break;
        }
        
        changeLevel = false;
    }
    
    
    /**
     * Control actions of items and instances of the game. 
     * It also control the management of the levels
     */
    private void tick() {
       
        keyManager.tick();
        display.tick();
        
        if (this.getKeyManager().enter) {
            System.out.print("1 ");
            display.setEnter(true);
        } 
        
        if (loss || win)
            return;
        
        // collide Blocks
        for (int i=0; i<blocks.size(); i++) {
            
            Block block = blocks.get(i);
            block.tick();
            
            // Check collition between player and block
            if (cow.intersecta(block)) {
                cow.setX(cow.getPrevX());
                cow.setY(cow.getPrevY());
            }

            // Collision of fireball with player 2
            if (fire.intersecta(farm)) {
                fire.setX(cow.getX());
                fire.setY(cow.getY());
                setShootFire(false);
            }
        }
        
        // Farm Collide cow
        if (farm.intersecta(cow)) {
            win = true;
        }
        
        // If level 1 is started
        if (level1) {
            
            if (changeLevel)
                initLevel(1);
            
            if (run) {
                cow.setFinish(false);
                cow.tick();
                
                if (cow.getFinish()) {
                    run = false;
                    cow.setFinish(true);
                    clear();
                    noLives--;
                    Assets.moo.play();
                }   
            }
            
            help.tick();
            window.tick();
            fire.tick();
            powerShield.tick();
            
            window.tick();
            
            if (help.getPressed()) {
                window.setX(300);
                window.setY(300);
                window.setPressed(false);
            }
            
            if (window.getPressed()) {
                window.setX(-1000);
                window.setY(-1000);
                help.setPressed(false);
            }
            
            if (noLives <= 0) {
                loss = true;
            }   
        }
        
        // If Level 2 is starter
        else if (level2) {
            
            if (changeLevel)
                initLevel(2);
            
            if (run) {
                cow.setFinish(false);
                cow.tick();
                
                if (cow.getFinish()) {
                    run = false;
                    cow.setFinish(true);
                    clear();
                    noLives--;
                }   
            }
            
            if (noLives <= 0) {
                loss = true;
            }   
        }
        
        // If Level 3 is started
        else if (level3) {
            
            if (changeLevel)
                initLevel(3);
            
            if (run) {
                cow.setFinish(false);
                cow.tick();
                
                if (cow.getFinish()) {
                    run = false;
                    cow.setFinish(true);
                    clear();
                    noLives--;
                }   
            }
            
            if (noLives <= 0) {
                loss = true;
            }
        }
        
        else if (level4) {
            
            if (changeLevel)
                initLevel(4);
            
            if (run) {
                
                cow.setFinish(false);
                cow.tick();
                
                if (cow.getFinish()) {
                    run = false;
                    cow.setFinish(true);
                    clear();
                    noLives--;
                    Assets.moo.play();
                }   
            }
            
            help.tick();
            window.tick();
            wolf.tick();
            
            if (help.getPressed()) {
                window.setX(300);
                window.setY(300);
                window.setPressed(false);
            }
            
            if (window.getPressed()) {
                window.setX(-1000);
                window.setY(-1000);
                help.setPressed(false);
            }
            
            if (noLives <= 0 || wolf.intersecta(cow)) {
                loss = true;
            }
        }
    }
    
    /**
     * Read de instructions that the user gave. This function is used in all the 
     * levels when thick and read are being used 
     */
    private void instructions() {
        
        if (display.getNewInstruction()) {
            
            String newInst = display.getInstruction();
            Inst.set(index, newInst);

            // Posible instructions of the user
            if (newInst.equals("game.level1()") || newInst.equals("game.restartLevel1()")) {
                level1 = true;
                level2 = false;
                level3 = false;
                level4 = false;
                level5 = false;
                changeLevel = true;
                clear();
            } 
            
            else if (newInst.equals("game.level2()") || newInst.equals("game.restartLevel2()")) {
                level1 = false;
                level2 = true;
                level3 = false;
                level4 = false;
                level5 = false;
                changeLevel = true;
                clear();
            } 
            
            else if (newInst.equals("game.level3()") || newInst.equals("game.restartLevel3()")) {
                level1 = false;
                level2 = false;
                level3 = true;
                level4 = false;
                level5 = false;
                changeLevel = true;
                clear();
            } 
            
            else if (newInst.equals("game.level4()") || newInst.equals("game.restartLevel4()")) {
                level1 = false;
                level2 = false;
                level3 = false;
                level4 = true;
                level5 = false;
                changeLevel = true;
                clear();
            } 
            
            else if (newInst.equals("game.level5()") || newInst.equals("game.restartLevel5()")) {
                level1 = false;
                level2 = false;
                level3 = false;
                level4 = false;
                level5 = true;
                changeLevel = true;
                clear();
            } 
            
            else if (newInst.equals("cow.up()")) {
                Instructions.add(0);
                if (loop) Ident.set(index, true);
            } 
            
            else if (newInst.equals("cow.down()")) {
                Instructions.add(1);
                if (loop) Ident.set(index, true);
            } 
            
            else if (newInst.equals("cow.left()")) {
                Instructions.add(2);
                if (loop) Ident.set(index, true);
            } 
            
            else if (newInst.equals("cow.right()")) {
                Instructions.add(3);
                if (loop) Ident.set(index, true);
            }
            
            else if (newInst.equals("cow.run()")) {
                run = true;
            } 
            
            else if (newInst.equals("clear")) {
                clear();
            } 
            
            else if (newInst.equals("for x in range(1)") || newInst.equals("for x in range (1)") || newInst.equals("for x in range(1) ") || newInst.equals("for x in range (1) ")) {
                Instructions.add(11);
                loop = true;
            }
            
            else if (newInst.equals("for x in range(2)") || newInst.equals("for x in range (2)") || newInst.equals("for x in range(2) ") || newInst.equals("for x in range (2) ")) {
                Instructions.add(12);
                loop = true;
            } 
            
            else if (newInst.equals("for x in range(3)") || newInst.equals("for x in range (3)") || newInst.equals("for x in range(3) ") || newInst.equals("for x in range (3) ")) {
                Instructions.add(13);
                loop = true;
            } 
            
            else if (newInst.equals("for x in range(4)") || newInst.equals("for x in range (4)") || newInst.equals("for x in range(4) ") || newInst.equals("for x in range (4) ")) {
                Instructions.add(14);
                loop = true;
            } 
            
            else if (newInst.equals("for x in range(5)") || newInst.equals("for x in range (5)") || newInst.equals("for x in range(5) ") || newInst.equals("for x in range (5) ")) {
                Instructions.add(15);
                loop = true;
            } 
            
            else if (newInst.equals("for x in range(6)") || newInst.equals("for x in range (6)") || newInst.equals("for x in range(6) ") || newInst.equals("for x in range (6) ")) {
                Instructions.add(16);
                loop = true;
            } 
            
            else if (newInst.equals("for x in range(7)") || newInst.equals("for x in range (7)") || newInst.equals("for x in range(7) ") || newInst.equals("for x in range (7) ")) {
                Instructions.add(17);
                loop = true;
            } 
            
            else if (newInst.equals("for x in range(8)") || newInst.equals("for x in range (8)") || newInst.equals("for x in range(8) ") || newInst.equals("for x in range (8) ")) {
                Instructions.add(18);
                loop = true;
            } 
            
            else if (newInst.equals("for x in range(9)") || newInst.equals("for x in range (9)") || newInst.equals("for x in range(9) ") || newInst.equals("for x in range (9) ")) {
                Instructions.add(19);
                loop = true;
            } 
            
            else if (newInst.equals("for x in range(10)") || newInst.equals("for x in range (10)") || newInst.equals("for x in range(10) ") || newInst.equals("for x in range (10) ")) {
                Instructions.add(20);
                loop = true;
            } 
            
            else if (newInst.equals("end")) {
                Instructions.add(10);
                loop = false;
            }
            
            else {
                if (loop) Ident.set(index, true);
            }

            if (index < Inst.size()) index++;
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
            
            if (level1) {
                                
                g = bs.getDrawGraphics();
                g.drawImage(Assets.pasto, 0, 0, width, height, null);
                
                for (int i=0; i<blocks.size(); i++) {
                    Block block = blocks.get(i);
                    block.render(g);
                }
                
                wood.render(g);
                cow.render(g);
                farm.render(g);
                help.render(g);
                window.render(g);
                
                if (getShootFire()) {
                    fire.render(g);
                }
                
                for (int i=0; i<noLives; i++) {
                    Live live = lives.get(i);
                    live.render(g);
                }
                
                instructions();
                
                if (win) {
                    g.setColor(Color.red);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                    g.drawString("YOU WIN!", getWidth() / 2 - 175, getHeight() / 2);
                } 
                if (loss) {
                    g.setColor(Color.red);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                    g.drawString("GAME OVER", getWidth() / 2 - 175, getHeight() / 2);
                }
                             
                for (int i=0; i<Inst.size(); i++) {
                    String instruction = Inst.get(i);
                    String space = (Ident.get(i)) ? "     " : "" ;
                    
                    g.setColor(Color.white);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                    g.drawString(space+instruction, 1054, i*30+100);
                } 
                
                bs.show();
                g.dispose();
            }
            
            else if (level2) {
                
            }
            
            else if (level3) {
                
            }

            else if (level4) {
                
                g = bs.getDrawGraphics();
                g.drawImage(Assets.pasto, 0, 0, width, height, null);
                
                for (int i=0; i<blocks.size(); i++) {
                    Block block = blocks.get(i);
                    block.render(g);
                }
                
                wood.render(g);
                cow.render(g);
                farm.render(g);
                help.render(g);
                window.render(g);
                wolf.render(g);
                
                if (getShootFire()) {
                    fire.render(g);
                }
                
                for (int i=0; i<noLives; i++) {
                    Live live = lives.get(i);
                    live.render(g);
                }
                
                instructions();
                
                if (win) {
                    g.setColor(Color.red);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                    g.drawString("YOU WIN!", getWidth() / 2 - 175, getHeight() / 2);
                } 
                if (loss) {
                    g.setColor(Color.red);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                    g.drawString("GAME OVER", getWidth() / 2 - 175, getHeight() / 2);
                }
                             
                for (int i=0; i<Inst.size(); i++) {
                    String instruction = Inst.get(i);
                    String space = (Ident.get(i)) ? "     " : "" ;
                    
                    g.setColor(Color.white);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                    g.drawString(space+instruction, 1054, i*30+100);
                } 
                
                bs.show();
                g.dispose();
            }
            
            else if (level5) {
                
            }
            
            else {
                
                g = bs.getDrawGraphics();
                g.drawImage(Assets.pasto, 0, 0, width, height, null);
                g.drawImage(Assets.instrucciones, 0, 0, 900, 750, null);
                
                wood.render(g);
                
                if (display.getNewInstruction()) {
                    
                    String newInst = display.getInstruction();
                    Inst.set(index, newInst);
                    
                    // Posible instructions of the user
                    if (newInst.equals("play")) {
                        level1 = true;
                        clear();
                    } else if (newInst.equals("clear")) {
                        clear();
                    }
                    
                    if (index < Inst.size()) {
                        index++;
                    }
                }
                                
                for (int i=0; i<Inst.size(); i++) {
                    String instruction = Inst.get(i);
                    g.setColor(Color.white);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                    g.drawString(instruction, 1054, i*30+100);
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