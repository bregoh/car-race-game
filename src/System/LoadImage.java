package System;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class LoadImage {
    
    //loads image from spritesheets
    public static BufferedImage LoadImageFrom (Class<?>classfile, String path) {
        URL url = classfile.getResource(path);
        BufferedImage img = null;
        
        try {
            img = ImageIO.read(url);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        return img;
    }
}
