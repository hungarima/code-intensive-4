import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    Player player;
    BufferedImage backBuffered;
    Graphics graphics;

    int countBullet = 0;

    public GameCanvas() {
        this.setup();
        this.setupBackBuffered();
        this.setupBackground();
        this.setupPlayer();
        GameObject.add(new SquareSpawner());
        GameObject.add(new EnemySpawner());
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
        this.player.x = 200;
        this.player.y = 300;
        GameObject.add(this.player);
    }

    private void setupBackground() {
        GameObject.add(new Background());
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
