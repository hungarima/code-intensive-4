import base.GameObjectManager;
import game.background.Background;
import game.enemy.EnemySqawner;
import game.player.Player;
import game.square.circle.CircleSquare;
import game.square.matrix.MatrixSquare;
import game.square.SquareSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//Co rat nhieu thang su dung den chuot

public class GameCanvas extends JPanel {

    //object
    Player player;
    BufferedImage backBuffered;
    Graphics graphics;

    public GameCanvas() {
        this.setup();
        this.setupBackBuffered();
        this.setupBackground();
        this.setupPlayer();
        GameObjectManager.instance.add(new SquareSpawner());
        GameObjectManager.instance.add(new EnemySqawner());
        this.setupMatrix();
        this.setCircleSquare();
    }

    private void setup() {
        this.setSize(400, 600);
        this.setVisible(true);
    }

    private void setupMatrix() {
        MatrixSquare matrixSquare = new MatrixSquare();
        matrixSquare.position.set(20, 20);
        matrixSquare.velocity.set(3, 0);
        matrixSquare.create();
        GameObjectManager.instance.add(matrixSquare);
    }

    private void setCircleSquare() {
        CircleSquare circleSquare = new CircleSquare();
        circleSquare.position.set(100, 100);
        circleSquare.create();
        GameObjectManager.instance.add(circleSquare);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        GameObjectManager.instance.add(this.player);
    }

    private void setupBackground() {
        Background background = new Background();
        background.position.set(200, 300);
        GameObjectManager.instance.add(background);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }
}
