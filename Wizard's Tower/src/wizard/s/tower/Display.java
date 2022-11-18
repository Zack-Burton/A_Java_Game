
package wizard.s.tower;

import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;

public class Display 
{
public JFrame frame;
private Canvas canvas;
private final String title;
private final int width,height;

    public Display(String title, int width, int height)
    {
        this.title = title;
        this.height = height;
        this.width = width;
        createDisplay();
    }
    public void createDisplay()
    {
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        canvas.setBackground(Color.GRAY);
        frame.add(canvas);
        frame.pack();
        
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
    
}
