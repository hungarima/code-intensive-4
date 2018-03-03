import java.awt.*;
import java.awt.image.BufferedImage;

public class Square {

    public BufferedImage image;
    public int x;
    public int y;
    public int dx;
    public int dy;

    public Square(BufferedImage image, int x, int y, int dx, int dy) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void run() {
        this.x += this.dx;
        this.y += this.dy;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, null);
    }
}
