import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    public BufferedImage image;
    public int x;
    public int y;

    public Player(BufferedImage image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, null);
    }
}
