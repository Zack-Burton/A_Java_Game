
package wizard.s.tower;

import java.awt.Graphics;

public abstract class State 
{
    protected Handler handler;
    protected GUI gui;
    public static State currentState = null;
    
    public State(Handler handler)
    {
        this.handler = handler;
        
    }
    
 public void addText(UIObject x) {
        gui.addText(x);
        x.handler = handler;
    }
 
 public abstract void tick();
 
 public abstract void render(Graphics g);

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public static State getState() {
        return currentState;
    }

    public static void setState(State state) {
       currentState = state;
    }
 
}
