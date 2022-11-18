
package wizard.s.tower;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
 
public class MouseManager implements MouseListener, MouseMotionListener {
 
    private boolean leftPressed, rightPressed, middlePressed;
    private int mouseX, mouseY;
    public Rectangle bounds = new Rectangle();
    private Handler handler;
 
    public MouseManager(Handler handler) {
        this.handler = handler;
    }
 
    public boolean isLeftPressed() {
        return leftPressed;
    }
 
    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }
 
    public boolean isRightPressed() {
        return rightPressed;
    }
 
    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }
 
    public boolean isMiddlePressed() {
        return middlePressed;
    }
 
    public void setMiddlePressed(boolean middlePressed) {
        this.middlePressed = middlePressed;
    }
 
    public int getMouseX() {
        return mouseX;
    }
 
    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }
 
    public int getMouseY() {
        return mouseY;
    }
 
    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
 
    @Override
    public void mouseClicked(MouseEvent e) {
    }
 
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
        }
        if (e.getButton() == MouseEvent.BUTTON2) {
            middlePressed = true;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = true;
        }
 
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {
 
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = false;
        }
        if (e.getButton() == MouseEvent.BUTTON2) {
            middlePressed = false;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = false;
        }
 
        handler.getState().getGui().onMouseRelease(e);
        //System.out.println(true);
    }
 
    @Override
    public void mouseEntered(MouseEvent e) {
    }
 
    @Override
    public void mouseExited(MouseEvent e) {
    }
 
    @Override
    public void mouseDragged(MouseEvent e) {
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {
        bounds = new Rectangle(e.getX() - 15, e.getY() - 15, 30, 30);
        mouseX = e.getX();
        mouseY = e.getY();
        handler.getState().getGui().onMouseMove(e);
    }
 
}