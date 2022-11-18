
package wizard.s.tower;
import java.awt.image.BufferedImage;
 
public class Assets {
 
    public static final int width = 2700, height = 2000;
 
    public static BufferedImage player, space, planet, hurtPlanet, cupcake;
   
 
    public static void init() {
 
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("Character.png"));
 
        player = sheet.crop(275, 275, width, height);
//        cupcake = sheet.crop(height, 0, width, height);
//        space = sheet.crop(0, height * 6, width * 2, height * 2);
//        planet = sheet.crop(0, height, width, height);
//        hurtPlanet = sheet.crop(width, height, width, height);
 
    }
}
