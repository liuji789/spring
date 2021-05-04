package com.tank;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author qingn
 */
public class ResourceMgr {

    public static BufferedImage tankL, tankR, tankU, tankD;

    public static BufferedImage bulletL, bulletR, bulletU, bulletD;

    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("static"+ File.separator+"images"+File.separator+"tankL.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("static"+ File.separator+"images"+ File.separator+"tankR.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("static"+ File.separator+"images"+ File.separator+"tankU.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("static"+ File.separator+"images"+ File.separator+"tankD.gif"));


            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("static"+ File.separator+"images"+ File.separator+"bulletL.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("static"+ File.separator+"images"+ File.separator+"bulletR.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("static"+ File.separator+"images"+ File.separator+"bulletU.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("static"+ File.separator+"images"+ File.separator+"bulletD.gif"));

            for (int i = 0; i < explodes.length; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("static"+ File.separator+"images"+ File.separator+"e" + (i + 1) + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
