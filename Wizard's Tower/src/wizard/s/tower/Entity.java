
package wizard.s.tower;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity 
{
protected int x,y;
        protected Rectangle bound = new Rectangle();
        protected Handler handler;
        protected int width;
        protected int height;
        protected float health;
        
        public Entity(int x,int y,int width, int height,Handler handler)
        {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.handler = handler;
            bound.x = x;
            bound.y = y;
            bound.width = width;
            bound.height = height;
        }
         public abstract void tick();
        public abstract void render(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getBound() {
        return bound;
    }

    public void setBound(Rectangle bound) {
        this.bound = bound;
    }

    

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
        
        
}
