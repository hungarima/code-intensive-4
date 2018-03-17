package game.square.circle;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.square.Square;

import java.util.Vector;

/**
 * Created by huynq on 3/15/18.
 */
public class CircleSquare extends GameObject {

    private Vector<Square> squares;
    public Vector2D velocity;
    private int count;

    public CircleSquare() {
        this.squares = new Vector<>();
        this.velocity = new Vector2D();
    }

    public void create() {
        for (double angle = 0.0; angle < 360.0; angle+=360.0/15) {
            Square square = new Square();
            Vector2D vector2D = new Vector2D(0, 80); //vector goc
            Vector2D rotate = vector2D.rotate(angle); //quay vector goc
            square.position.set(rotate).addUp(100, 100); //gan rotate vao position
            this.squares.add(square);
            GameObjectManager.instance.add(square);
        }
    }

    @Override
    public void run() {
        super.run();
        if (this.position.x <= 50) {
            if (this.count >= 5) {
                this.count = 0;
                this.velocity.set(2, 2);
            } else {
                this.velocity.set(0, 2);
                this.count += 1;
            }

        }
        if (this.position.x >= 450 - 20 * 5 - 20 * 4) {
            if (this.count >= 5) {
                this.count = 0;
                this.velocity.set(-2, 2);
            } else {
                this.velocity.set(0, 2);
                this.count += 1;
            }

        }
        this.position.addUp(this.velocity);
        this.squares.forEach(square -> square.velocity.set(velocity));
    }
}
