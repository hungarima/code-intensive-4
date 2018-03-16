package physic;

import base.Vector2D;

import java.awt.*;

public class BoxCollider {
    public Vector2D position;
    private float width;
    private float height;

    public BoxCollider(float width, float height) {
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }

    public boolean checkCollider(BoxCollider other) {
        Rectangle r1 = new Rectangle((int) this.position.x, (int) this.position.y, (int) this.width, (int)this.height);
        Rectangle r2 = new Rectangle((int) other.position.x, (int) other.position.y, (int) other.width, (int)other.height);

        return r1.intersects(r2);
    }
}
