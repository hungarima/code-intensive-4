package game.player.bullet;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import utils.Utils;

public class Bullet extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    private HitSquare hitSquare;

    public Bullet() {
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10, 10);
        this.hitSquare = new HitSquare();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position); //cho box di chuyen theo
        this.hitSquare.run(this);
    }

    public void getHit() {
        this.isAlive = false;
        System.out.println("hit square");
    }
}
