package wizard.s.tower;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

    private Thread thread;
    private Display display;
    private Handler handler ;
    private final String title;
    private final int width, height;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    private State gameState;
    private State inventoryState;
    public MouseManager mouseManager;
   
  
  

    public Game(String title, int width, int height) {
        handler = new Handler(this);
        
        this.title = title;
        this.width = width;
        this.height = height;
        gameState = new GameState(handler);
        mouseManager = new MouseManager(handler);
        State.currentState = gameState; 
       
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        thread = new Thread(this);
        running = true;
        thread.start();

    }

    public synchronized void stop() throws InterruptedException {
        if (!running) {
            return;
        }
        running = false;
        thread.join();
    }

    public void tick() {
       handler.getKeyManager().tick();
        State.currentState.tick();
    }

    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(2);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
       State.currentState.render(g); 
        bs.show();
        g.dispose();
    }

    public int fps = 80;

    public void run() {
        //Init initilzes most of the program.
        init();

        //The only varible you should ever change here is the FPS.
        //The math is a bit much, just ignore it.
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            //delta >= 1
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                if (ticks != fps) {
                    // System.out.println("FPS: " + ticks);
                }
                ticks = 0;
                timer = 0;
            }

        }

        try {
            //Is the game still running? Well if you got here, the answers no.
            stop();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
 

    public double temp;
    public void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(handler.getKeyManager());
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
       
        
      
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferStrategy getBs() {
        return bs;
    }

    public void setBs(BufferStrategy bs) {
        this.bs = bs;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }

    public State getInventoryState() {
        return inventoryState;
    }

    public void setInventoryState(State inventoryState) {
        this.inventoryState = inventoryState;
    }

   
}
