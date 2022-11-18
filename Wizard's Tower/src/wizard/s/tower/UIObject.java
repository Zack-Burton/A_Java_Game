
package wizard.s.tower;

import wizard.s.tower.GUI.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
 
public class UIObject {
 
    FontMetrics fm;
    Font font = GUI.font;
    public String text;
    public Rectangle bounds;
    private boolean clicked = false;
    public int x;
    public int y;
    public boolean clickable = true;
    public boolean center;
    public boolean hovering = false;
    public Color color;
    public Color newColor;
    public Color original;
    public boolean active = true;
    public Handler handler;
 
    public UIObject(String text, int x, int y, boolean center, Color color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.center = center;
        this.color = color;
        original = color;
        bounds = new Rectangle(0, 0, 0, 0);
    }

    public UIObject(String text, int x, int y, boolean center, Color color, Color newColor) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.center = center;
        this.color = color;
        original = color;
        this.newColor = newColor;
        bounds = new Rectangle(0, 0, 0, 0);
    }
 
    public UIObject(String text, int x, int y, boolean center, Color color, Font font) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.center = center;
        this.color = color;
        original = color;
        this.font = font;
        bounds = new Rectangle(0, 0, 0, 0);
    }
 
    public UIObject(String text, int x, int y, boolean center, Color color, Color newColor, Font font) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.center = center;
        this.color = color;
        original = color;
        this.newColor = newColor;
        this.font = font;
        bounds = new Rectangle(0, 0, 0, 0);
    }
 
    public void onClick() {
        if (!active) {
            return;
        }
        clicked = true;
    }
 
    public boolean wasClick() {
        if (!clickable) {
            clicked = false;
            return false;
        }
        if (clicked) {
            clicked = false;
            return true;
        }
        return false;
    }
 
    public void tick() {
        if (!active) {
            return;
        }
        if (hovering) {
            color = newColor;
        } else {
            color = original;
        }
    }
 
    public void onMouseMove(MouseEvent e) {
        if (bounds.contains(e.getX(), e.getY())) {
            hovering = true;
        } else {
            hovering = false;
        }
    }
 
    public void onMouseReleased(MouseEvent e) {
        if (hovering) {
            onClick();
        }
    }
 
    public void render(Graphics g) {
        if (!active) {
            return;
        }
        if (fm == null) {
            fm = g.getFontMetrics(font);
        }
        drawString(g, text, x, y, center, color, font);
    }
 
    public void drawString(Graphics g, String text, int xPos, int yPos, boolean center, Color c, Font font) {
        g.setColor(c);
        g.setFont(font);
        int x = xPos;
        int y = yPos;
 
        if (center) {
 
            x = xPos - fm.stringWidth(text) / 2;
            y = (yPos - fm.getHeight() / 2) + fm.getAscent();
 
            bounds = new Rectangle((int) x, (int) y - ((int) fm.getHeight() - 5), (int) fm.stringWidth(text), (int) fm.getHeight());
        }
 
        if (!center) {
            bounds = new Rectangle((int) x, (int) y - ((int) fm.getHeight() - 5), (int) fm.stringWidth(text), (int) fm.getHeight());
        }
 
        g.drawString(text, x, y);
    }
 
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
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
 
    public boolean isCenter() {
        return center;
    }
 
    public void setCenter(boolean center) {
        this.center = center;
    }
 
    public boolean isHovering() {
        return hovering;
    }
 
    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }
 
    public Color getColor() {
        return color;
    }
 
    public void setColor(Color color) {
        this.color = color;
    }
 
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
 
}