
package wizard.s.tower;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Text 
{
    public static void drawString(Graphics g,String text,int xpos,int ypos, boolean center,Color c,Font font)
    {
        g.setColor(c);
        g.setFont(font);
        int x = xpos;
        int y = ypos;
        if(center)
        {
            FontMetrics fm = g.getFontMetrics(font);
            x = xpos - fm.stringWidth(text)/2;
             y = (ypos - fm.getHeight()/2+ fm.getAscent());
        }
        g.drawString(text, x, y);
    }
}
