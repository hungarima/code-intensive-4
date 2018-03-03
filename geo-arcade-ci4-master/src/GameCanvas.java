
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class GameCanvas extends JPanel {

    BufferedImage background;
    Player player;
//    Vector<MediumSquare> mediumSquareVector;
    MediumSquare mediumSquare;
    Vector<Square> squareVector;
    Vector<PlayerBullet> playerBulletVector;
    BufferedImage backBuffered;
    Graphics graphics;
    Random rand = new Random();

    int countSquare = 0;
    int countPlayerBullet = 0;

    public GameCanvas() {
        this.setup();
        this.setupBackBuffered();
        this.setupBackground();
        this.setupPlayer();
        this.createMediumSquare();
        this.squareVector = new Vector<>();
        this.playerBulletVector = new Vector<>();
//        this.mediumSquareVector = new Vector<>();
    }

    private void setup() {
        this.setSize(400, 600);
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupPlayer() {
        try {
            this.player = new Player(ImageIO.read(new File("resources/player/straight.png")), 200, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void setupBackground() {
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void runAll() {
        this.checkPlayerBorder();
        this.runMediumSquare();
        this.runBullets();
        this.runSquares();
    }

    private void checkPlayerBorder () {
        if (player.x > 400) player.x = 350;
        if (player.y > 600) player.y = 550;
    }

    private void createMediumSquare () {
        try {
            this.mediumSquare = new MediumSquare(ImageIO.read(new File("resources/square/enemy_square_medium.png")), 200 , -100, 0, 5);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void runMediumSquare () {

        this.mediumSquare.y += 2;
        if (this.mediumSquare.y > 600) {
            this.mediumSquare.y = -80;
            this.mediumSquare.x = rand.nextInt(350);
        }
//        for (MediumSquare square : mediumSquareVector) {
//            square.y += 2;
//            if (square.y > 600) {
//                square.y = -80;
//                square.x = rand.nextInt(350);
//            }
//
//        }
//        this.mediumSquareVector.forEach(mediumSquare -> mediumSquare.run());
    }


    private void runSquares() {

        this.createSquare();
        this.squareVector.forEach(square -> square.run());
    }

    private void createSquare () {
        if (this.countSquare >= 30) {
            try {
                Square square1 = new Square(ImageIO.read(new File("resources/square/enemy_square_bullet.png")), mediumSquare.x, mediumSquare.y, 0, 5);
                Square square2 = new Square(ImageIO.read(new File("resources/square/enemy_square_bullet.png")), mediumSquare.x, mediumSquare.y, 5, 5);
                Square square3 = new Square(ImageIO.read(new File("resources/square/enemy_square_bullet.png")), mediumSquare.x, mediumSquare.y, -5, 5);
                this.squareVector.add(square1);
                this.squareVector.add(square2);
                this.squareVector.add(square3);
                this.countSquare = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.countSquare += 1;
        }
    }



    private void runBullets() {
        this.createBullet();
        this.playerBulletVector.forEach(playerBullet -> playerBullet.run());
    }

    private void createBullet() {
        if (this.countPlayerBullet >= 30) {
            try {
                PlayerBullet playerBullet = new PlayerBullet(ImageIO.read(new File("resources/player/player_bullet.png")), player.x , player.y, 0, -4);
                this.playerBulletVector.add(playerBullet);
                this.countPlayerBullet = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.countPlayerBullet += 1;
        }
    }

    public void renderAll() {
        this.graphics.drawImage(this.background, 0, 0, null);
        this.player.render(this.graphics);
//        this.mediumSquareVector.forEach(mediumSquare -> mediumSquare.render(graphics));
        this.mediumSquare.render(this.graphics);
        this.squareVector.forEach(square -> square.render(graphics));
        this.playerBulletVector.forEach(playerBullet -> playerBullet.render(graphics));
        this.repaint();
    }
}
