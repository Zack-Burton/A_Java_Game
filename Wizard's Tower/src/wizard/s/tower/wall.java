package wizard.s.tower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class wall {

    public static ArrayList<wall> maps = new ArrayList<>();
    private Rectangle bound = new Rectangle();
    private Handler handler;
    private int x,y;
    public wall(Handler handler, int x, int y) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        bound.x = x;
        bound.y = y;
        bound.width = 100;
        bound.height = 50;
        maps.add(this);
    }
    
    public void tick() {

    }

    public void render(Graphics g) {
        
        g.setColor(Color.black);
        g.fillRect(bound.x,bound.y,bound.width,bound.height);
        
    }

    public Rectangle getBound() {
        return bound;
    }

    public void setBound(Rectangle bound) {
        this.bound = bound;
    }

    public static ArrayList<wall> getMaps() {
        return maps;
    }

    public static void setMaps(ArrayList<wall> maps) {
        wall.maps = maps;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
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

}
