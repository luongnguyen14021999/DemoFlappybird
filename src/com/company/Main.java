package com.company;

import framework.AFrameOnImage;
import framework.Animation;
import framework.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
public class Main extends GameScreen {
    private BufferedImage birds;
    private Animation bird_amin;

    public static float g = 0.1f;

    private Bird bird;
    private int BEGIN_SCREEN = 0;
    private int GAMEPLAY_SCREEN = 1;
    private int GAMEOVER_SCREEN = 2;
    private int currentScreen = BEGIN_SCREEN;
    private Ground ground;
    private ChimneyGroup chimneyGroup;
    private BufferedImage message;
    private BufferedImage gameover;
    BufferedImage chimney1;
    BufferedImage chimney2;

    public Main() {
        super(800, 600);
        ground = new Ground();
        try {
            birds = ImageIO.read(new File("bluebird.png"));
            chimney1 = ImageIO.read(new File("pipe-green1.jpg"));
            chimney2 = ImageIO.read(new File("pipe-green.png"));
        } catch (IOException e) {
        }

        bird_amin = new Animation(100);
        AFrameOnImage f;
        f = new AFrameOnImage(0, 0, 50, 35);
        bird_amin.AddFrame(f);
        f = new AFrameOnImage(50, 0, 50, 35);
        bird_amin.AddFrame(f);
        f = new AFrameOnImage(100, 0, 50, 35);
        bird_amin.AddFrame(f);
        f = new AFrameOnImage(50, 0, 50, 35);
        bird_amin.AddFrame(f);
        bird = new Bird(350, 250, 50, 50);
        chimneyGroup = new ChimneyGroup();
        BeginGame();
    }

    public static void main(String[] args) {
        new Main();
    }




    private void resetGame() {
        bird.setPos(350, 250);
        bird.setVt(0);
    }

    @Override
    public void GAME_UPDATE(long deltaTime) {
        if (currentScreen == BEGIN_SCREEN) {
            resetGame();
        } else if (currentScreen == GAMEPLAY_SCREEN) {
            bird_amin.Update_Me(deltaTime);
            bird.update(deltaTime);
            ground.Update();
            chimneyGroup.update();

            if (bird.getPosY() + bird.getH() > ground.getYGround() + 14) {
                currentScreen = GAMEOVER_SCREEN;
            }
        } else {

        }
    }


    @Override
    public void GAME_PAINT(Graphics2D g2) {

        chimneyGroup.paint(g2);
        ground.Paint(g2);

        if (bird.getIsFlying() == false) {
                bird_amin.PaintAnims((int) bird.getPosX(), (int) bird.getPosY(), birds, g2, 0, 0);
        } else {
                bird_amin.PaintAnims((int) bird.getPosX(), (int) bird.getPosY(), birds, g2, 0, -1);
        }

        if (currentScreen == BEGIN_SCREEN) {
            try
            {
                message = ImageIO.read(new File("message.png"));
            } catch (IOException e) {
            }
            g2.drawImage(message, 250, 100, null);
            g2.setColor(Color.red.darker());
            g2.setFont(new Font("Arial", Font.BOLD, 40));
            g2.drawString("Press space to play game", 170, 220);
            }
        if (currentScreen == GAMEOVER_SCREEN) {
            try {
                gameover = ImageIO.read(new File("gameover.png"));
            } catch (IOException e) {
            }
            g2.drawImage(gameover, 300, 200, null);
            g2.setColor(Color.red.darker());
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString("Please press space to turn back begin screen", 220, 160);
        }


    }


    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        if (Event == KEY_PRESSED) {
            if (currentScreen == BEGIN_SCREEN) {
                currentScreen = GAMEPLAY_SCREEN;
            } else if (currentScreen == GAMEPLAY_SCREEN) {
                bird.fly();
            } else if (currentScreen == GAMEOVER_SCREEN) {
                currentScreen = BEGIN_SCREEN;
            }


        }
    }

}
