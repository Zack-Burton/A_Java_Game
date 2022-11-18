package wizard.s.tower;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GUI {

    public static Font font;
    public Handler handler;
    public ArrayList<UIObject> objects = new ArrayList<>();
    public ArrayList<String> text = new ArrayList<>();
    public boolean active;
    private final String titleText = "welcome to the shop";
  

    public GUI(Handler handler) {
       
        this.handler = handler;
        active = false;
        font = FontLoader.loadFont("src\\wizard\\s\\tower\\OpenSans-Regular.ttf", 20);
        for (Item e : Item.items) {
            text.add(e.name);
        }
         
    }

    public static void init() {
    }

    public void tick() {
        for (UIObject e : objects) {
            e.tick();
        }
        System.out.println(State.currentState);
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_SHIFT)) {
            active = !active;
        }
    }

    public void render(Graphics g) {
        for (UIObject e : objects) {
            e.render(g);
        }
    }

    public void onMouseMove(MouseEvent e) {
        //System.out.println(State.currentState + " TRUE");
        for (UIObject o : objects) {
            o.onMouseMove(e);
        }
    }

    public void onMouseRelease(MouseEvent e) {
        for (UIObject o : objects) {
            o.onMouseReleased(e);
        }
    }

    public void addText(UIObject e) {
        objects.add(e);
        //System.out.println("add Text");
    }

    public void removeText(UIObject e) {
        objects.remove(e);
    }
}
