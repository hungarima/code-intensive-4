package game.enemy.bullet;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import utils.Utils;

public class BulletEnemy extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletEnemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10,10);

    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
        this.position.addUp(this.velocity);
    }
}
