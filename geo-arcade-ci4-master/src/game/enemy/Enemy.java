package game.enemy;

import base.GameObject;
import base.Vector2D;
import game.enemy.bullet.EnemyShoot;
import physic.BoxCollider;
import utils.Utils;

public class Enemy extends GameObject {
    public Vector2D velocity;
    private EnemyShoot enemyShoot;
    public BoxCollider boxCollider;


    public Enemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.enemyShoot = new EnemyShoot();
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(40,40);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);

    }
}
