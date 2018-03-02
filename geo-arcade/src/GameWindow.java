import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;


    public GameWindow() {
            this.setSize(400, 600);
            this.gameCanvas = new GameCanvas();
            this.gameCanvas.setSquare();
            this.add(this.gameCanvas);

            this.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    gameCanvas.playerX = e.getX();
                    gameCanvas.playerY = e.getY();

                }
            });

            // Stop App
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
            this.setVisible(true);
        }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000 ) {
                this.gameCanvas.moveDiagonally();
                this.gameCanvas.bounceBack();
                this.gameCanvas.renderAll();
                this.gameCanvas.moveVertically();

                lastTime = currentTime;
            }

        }
    }
}
