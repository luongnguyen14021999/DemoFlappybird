package com.company;
import framework.QueueList;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChimneyGroup {
    private QueueList<Chimney> chimneys;
    private BufferedImage chimneyImage1,chimneyImage2;
    public ChimneyGroup() {
       try {
           chimneyImage1 = ImageIO.read(new File("pipe-green.png"));
           chimneyImage2 = ImageIO.read(new File("pipe-green1.jpg"));
       } catch (IOException e) {
       }
       chimneys = new QueueList<Chimney>();
       Chimney cn;
       for(int i=0;i<3;i++)
       {
           cn = new Chimney(830+i*300,350,74,400);
           chimneys.push(cn);
           cn = new Chimney(830+i*300,-200,74,400);
           chimneys.push(cn);
       }
    }
    public void update()
    {
        for(int i=0;i<6;i++)
        {
            chimneys.get(i).Update();
        }
        if(chimneys.get(0).getPosX() < -74)
        {
            Chimney cn;
            cn = chimneys.pop();
            cn.setPosX(chimneys.get(4).getPosX()+300);
            chimneys.push(cn);
            cn = chimneys.pop();
            cn.setPosX(chimneys.get(4).getPosX());
            chimneys.push(cn);
        }
    }
    public void paint(Graphics2D g2)
    {
        for(int i=0;i<6;i++)
        {
            if(i%2==0)
            {
                g2.drawImage(chimneyImage1,(int) chimneys.get(i).getPosX(),(int) chimneys.get(i).getPosY(),null,null);
            } else
            {
                g2.drawImage(chimneyImage2,(int) chimneys.get(i).getPosX(),(int) chimneys.get(i).getPosY(),null,null);
            }
        }
    }

}
