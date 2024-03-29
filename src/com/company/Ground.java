package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ground {
    private BufferedImage groundImage;
    private int x1 = 0, y1 = 500, x2 = x1 + 800, y2 = 500;

    public Ground()
    {
       try {
           groundImage = ImageIO.read(new File("bg.png"));
       } catch (IOException e) {
       }
    }

    public void Update()
    {
        x1 -= 2;
        x2 -= 2;
        if(x2 < 0) x1 = x2 + 800;
        if(x1 < 0) x2 = x1 + 800;
    }
    public void Paint(Graphics2D g2)
    {
        g2.drawImage(groundImage,x1,y1,null);
        g2.drawImage(groundImage,x2,y2,null);
    }
    public int getYGround()
    {
        return y1;
    }
}
