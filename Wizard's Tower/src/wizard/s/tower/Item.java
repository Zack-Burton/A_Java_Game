
package wizard.s.tower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Item extends Entity
{
  private Rectangle bound = new Rectangle();
  public static ArrayList<Item> items = new ArrayList<>();
  public String name;
  private int damage;
  private Color color;

    public Item(String name,int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        bound.x = x;
        bound.y = y;
        bound.width = width;
        bound.height = height;
        
        this.name = name;
        this.health = health;
        if(name.equalsIgnoreCase("mace"))
        {
            this.x = 200;
            this.y = 200;
            bound.x = this.x;
            bound.y = this.y;
            bound.width = 10;
            bound.height = 10;
            this.damage = 15;
            this.health = -1;
            this.color = Color.black;
        }
        else if(name.equalsIgnoreCase("hammer"))
        {
             this.x = 250;
            this.y = 250;
            bound.x = this.x;
            bound.y = this.y;
            bound.width = 10;
            bound.height = 10;
            this.damage = 20;
            this.health = -1;
            this.color = Color.blue;
        }
       
        items.add(this);
        
    }

    @Override
    public void tick() {
         bound.x = x;
        bound.y = y;
        bound.width = width;
        bound.height = height;

    }

    @Override
    public void render(Graphics g) {
        for(Item e: items)
        {
        g.setColor(e.color);
        g.fillRect(e.x, e.y, e.width, e.height);
        }
    }

    public Rectangle getBound() {
        return bound;
    }

    public void setBound(Rectangle bound) {
        this.bound = bound;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Item> items) {
        Item.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
   

}
