package com.example.tank;


import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import org.junit.Assert;
import org.junit.Test;

public class ImageTest {


    @Test
    public void testLoadImage() throws Exception {
        BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("static\\images\\BadTank1.png"));

        Assert.assertNotNull(image);
    }

}
