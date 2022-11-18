package wizard.s.tower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Player extends Entity {
    
    private float test;
    public Rectangle projectile = new Rectangle();
    public static ArrayList<Entity> pc = new ArrayList<>();
    public static ArrayList<Item> inventory = new ArrayList<>();
    public int damage;
    public int ammo;
    public int speed;
    private int size = 100;
    public int jumpTime =5;
       int countDown = 5;
    public Player(int x, int y, int width,int height,int speed,Handler handler) {
        super(x, y,width,height, handler);
        this.speed = speed;
        health = 100;
        damage = 10;
        pc.add(this);
    }

    @Override
    public void tick() {
        bound.x = x;
        bound.y = y;
        bound.width = 25;
        bound.height = 25;
        if(x==0)
           {
               x=1;
           }
        if(x== 475)
            {
                x = 474;
            }
        if(y==0)
           {
               y=1;
           }
        if(y==475)
            {
                y = 474;
            }
           
        test = bound.width*(health/100);
        if(test<0)
            test = 0;
        if (handler.getKeyManager().up) {          
            countDown ++;
            if(countDown <= jumpTime)
                y -=2;
        }
        
//        if (handler.getKeyManager().down) {
//            y++;
//        }
        if (handler.getKeyManager().left) {
            x--;
        }
        if (handler.getKeyManager().right) {
            x++;
        }
        if(countDown>jumpTime)
        {
            countDown--;
            y++;
        }
        if(!inventory.isEmpty())
        {
           
        }
        
    }

   
    
    @Override
    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.drawRect(x ,y,25,25);
       //g.drawImage(Assets.player, x, y, size, size, null);
       

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

    public float getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static ArrayList<Entity> getPc() {
        return pc;
    }

    public static void setPc(ArrayList<Entity> pc) {
        Player.pc = pc;
    }

   
}
