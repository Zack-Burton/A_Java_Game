
package wizard.s.tower;

import java.awt.Graphics;
import java.util.ArrayList;

public class Gate extends wall
{
    public ArrayList<Gate> gates = new ArrayList<>();
    private boolean open;
    
    public Gate(Handler handler, int x, int y) {
        super(handler, x, y);
    }
    @Override
    public void tick()
    {
        for(Gate e: gates)
        {
            if(e.open)
            {
                
            }
        }
    }
    @Override 
    public void render(Graphics g)
    {
        
    }
}
