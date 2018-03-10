import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    Player player;
    BufferedImage backBuffered;
    Graphics graphics;

    public GameCanvas() {
        this.setup();
        this.setupBackBuffered();
        this.setupBackground();
        this.setupPlayer();
        GameObject.add(new SquareSpawner());
        GameObject.add(new EnemySqawner());
        MatrixSquare matrixSquare = new MatrixSquare();
        matrixSquare.position.set(20, 20);
        matrixSquare.velocity.set(3, 0);
        matrixSquare.create();
        GameObject.add(matrixSquare);
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
        this.player = new Player();
        this.player.position.set(200, 300);
        GameObject.add(this.player);
    }

    private void setupBackground() {
        Background background = new Background();
        background.position.set(200, 300);
        GameObject.add(background);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void runAll() {
        GameObject.runAll();
    }

    public void renderAll() {
        GameObject.renderAll(this.graphics);
        this.repaint();
    }
}
