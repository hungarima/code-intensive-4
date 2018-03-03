import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        this.setup();
        this.setupCanvas();
        this.listener();
        this.setVisible(true);
    }

    private void setup() {
        this.setSize(400, 600);
    }

    private void setupCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void listener() {
        this.mouseMotionListener();
        this.windowListener();
    }

    private void mouseMotionListener() {
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gameCanvas.player.x = e.getX();
                gameCanvas.player.y = e.getY();
            }
        });
    }

    private void windowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
