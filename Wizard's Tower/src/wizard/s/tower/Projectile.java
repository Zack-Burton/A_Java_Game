/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizard.s.tower;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Alec_Hardison
 */
public class Projectile extends Entity {

    public int x,y;
    public int xspeed,yspeed;
    public int count;
    public static int damage = 5;
    public static Projectile [] projectiles =new Projectile[256] ;
    public Projectile(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        this.x = x+12;
        this.y = y+12;
        for(int i =0; i < projectiles.length;i++)
        {
            if(projectiles[i]==null)
            {
                projectiles[i]=this;
                break;
            }
        }
    }

    @Override
    public void tick() {
        bound.x = x;
        bound.y = y;
        bound.width = width;
        bound.height=height;
        x += xspeed;
        y += yspeed;
        count ++;
        for (int i = 0; i < projectiles.length; i++) {
            if(projectiles[i]!= null && projectiles[i].count>300)
            {
                projectiles[i]= null;
            }
        }
        
    }

    @Override
    public void render(Graphics g) {
        for(Projectile p : projectiles)
        {
        g.setColor(Color.yellow);
        g.fillRect(x,y,5,5);
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

    public int getXspeed() {
        return xspeed;
    }

    public void setXspeed(int xspeed) {
        this.xspeed = xspeed;
    }

    public int getYspeed() {
        return yspeed;
    }

    public void setYspeed(int yspeed) {
        this.yspeed = yspeed;
    }

    
    
}
