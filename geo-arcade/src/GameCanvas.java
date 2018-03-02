import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage playerImage;
    BufferedImage enemySmall;
    BufferedImage enemyMedium;
    BufferedImage backBuffered;
    Graphics graphics;
    int playerX;
    int playerY;
    int enemyX;
    int enemyY;

    int enemyMediumY;
    Random rand = new Random();
    int enemyMediumX;
    int vx = 5;
    int vy = 5;






    public GameCanvas () {
        this.setSize(400, 600);
        this.setVisible(true);
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics(); // Get graphics to backBuffered

        // Load Images
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.playerImage = ImageIO.read(new File("resources/player/straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.enemySmall = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.enemyMedium = ImageIO.read(new File("resources/square/enemy_square_medium.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    @Override
    protected void paintComponent(Graphics g) {
        //Draw Images
        g.drawImage(this.backBuffered,0,0,null);


    }

    public void setSquare() {
        this.enemyMediumX = rand.nextInt(400);
    }


    public void moveVertically () {

        this.enemyMediumY +=4;
        if (this.enemyMediumY > 600) {
            this.enemyMediumY = 0;
            this.enemyMediumX = rand.nextInt(370);
        }
    }

    public void moveDiagonally () {
        this.enemyX += vx;
        this.enemyY += vy;

    }


    public void bounceBack() {
        if (this.enemyX > 380) {
            if (borderRight()) {
                this.vx = -5;
                this.vy = 5;
            } else {
                this.vx = -5;
                this.vy = -5;
            }
        }
        if (this.enemyX < 0) {
            if (borderLeft()) {
                this.vx = 5;
                this.vy = 5;
            } else {
                this.vx = 5;
                this.vy = -5;
            }
        }
        if (this.enemyY > 580) {
            if (borderBottom()) {
                this.vx = 5;
                this.vy = -5;
            } else {
                this.vx = -5;
                this.vy = -5;
            }
        }
        if (this.enemyY < 0) {
            if (borderTop()) {
                this.vx = 5;
                this.vy = 5;
            } else {
                this.vx = -5;
                this.vy = 5;
            }
        }
    }

    public boolean borderLeft () {
        return this.vx == -5 && this.vy == 5;
    }

    public boolean borderRight() {
        return this.vx == 5 && this.vy == 5;
    }

    public boolean borderTop () {
        return this.vx == 5 && this.vy == -5;
    }

    public boolean borderBottom () {
        return this.vx == 5 && this. vy == 5;
    }

//    public void randomPositionEnemy () {
//        if (this.enemyY > 600) {
//            this.enemyY = 0;
//            this.enemyX = rand.nextInt(400);
//        }
//    }
    public void renderAll() {
        this.graphics.drawImage(this.background, 0,0, null);
        this.graphics.drawImage(this.playerImage, this.playerX, this.playerY, null);
        this.graphics.drawImage(this.enemySmall, this.enemyX, this.enemyY, null);
        this.graphics.drawImage(this.enemyMedium, this.enemyMediumX, this.enemyMediumY, null);
        this.repaint();
    }
}
