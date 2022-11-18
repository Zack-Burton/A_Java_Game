
package wizard.s.tower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Enemy extends Player
{

    public static Enemy[] enemies = new Enemy[256];
    public float test;
    final int total;
    public int speed;
    
    public Enemy(int x, int y, int width, int height,int health,int speed, Handler handler) {
        super(x, y, width, height,speed,handler);
        this.health = health;
        this.total= health;
        this.speed = speed;
        for(int i =0; i<enemies.length;i++)
        {
            if(enemies[i] == null)
            {
                enemies[i]=this;
                break;
            }
        }
    }
    
    @Override
    public void tick()
    {
        bound.x = x;
        bound.y = y;
        bound.width = width;
        bound.height = height;
           test = bound.width*(health/total);
           if(x==0)
           {
               x=1;
           }
           if(y==0)
           {
               y=1;
           }
           for(int i =0; i<enemies.length;i++)
           {
             if(enemies[i]!= null && enemies[i].health<0)
            {
                enemies[i]=null;
            }
           }
    }

    @Override
    public void render(Graphics g)
    {
        
        
        for(int i = 0; i < enemies.length; i++)
        {
            if(enemies[i]!=null)
            {
                g.setColor(Color.red);
                g.drawRect(x, y, width, height);
                g.setColor(Color.red);
                 g.fillRect(x,y-10,Math.round(test),5);
            }
        }
        
        
    }
    
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

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
