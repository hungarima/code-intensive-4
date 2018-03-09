import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public BufferedImage image;
    public int x;
    public int y;

    private static Vector<GameObject> vector = new Vector<>();
    private static Vector<GameObject> temp = new Vector<>();

    public static void runAll() {
        vector.forEach(gameObject -> gameObject.run());
        vector.addAll(temp);
        temp.clear();
    }

    public static void renderAll(Graphics graphics) {
        vector.forEach(gameObject -> gameObject.render(graphics));
    }

    public static void add(GameObject gameObject) {
        temp.add(gameObject);
    }

    public void run() {

    }

    public void render(Graphics graphics) {
        if (this.image != null) {
            graphics.drawImage(this.image, this.x, this.y, null);
        }
    }
}
