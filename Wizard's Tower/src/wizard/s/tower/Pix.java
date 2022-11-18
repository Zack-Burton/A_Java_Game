
package wizard.s.tower;

import java.awt.Color;
import java.awt.Graphics;

public class Pix 
{
    
    public int x;
    public int y;
    public boolean active;
    public Handler handler;
    
    public Pix(int x, int y,Handler handler)
    {
        this.x = x;
        this.y = y;
        this.handler = handler;
        active = true;
    }
    
    public void tick()
    {
        if(!active)
        {
            return;
        }        
        double distance = Math.sqrt((GameState.getPlayer().x-this.x)^2+(GameState.getPlayer().y-this.y)^2);
    }
    
    public void render(Graphics g)
    {
        if(!active)
        {
            return;
        }
        g.setColor(Color.black);
        g.drawRect(x,y,1,1);
    }

}
