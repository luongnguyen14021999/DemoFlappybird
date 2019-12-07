package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background {
    private BufferedImage background;
    public Background()
    {
        try {
            background = ImageIO.read(new File("background-day.png"));
        } catch (IOException e) {
        }
    }
    public void Paint(Graphics2D g2)
    {
        g2.drawImage(background,0,0,null);
    }
}
