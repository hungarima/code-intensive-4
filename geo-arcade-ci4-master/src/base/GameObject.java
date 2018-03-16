package base;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    public BufferedImage image;
    public Vector2D position;
    public boolean isAlive;

    public GameObject() {
        this.position = new Vector2D();
        this.isAlive = true;
    }


    public void run() {

    }

    public void render(Graphics graphics) {
        if (this.image != null) {
            graphics.drawImage(this.image, (int)this.position.x - this.image.getWidth() / 2, (int)this.position.y - this.image.getHeight() / 2, null);
        }
    }


}
