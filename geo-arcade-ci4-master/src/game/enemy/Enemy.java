package game.enemy;

import base.GameObject;
import base.Vector2D;
import game.enemy.bullet.EnemyShoot;
import utils.Utils;

public class Enemy extends GameObject {
    public Vector2D velocity;
    private EnemyShoot enemyShoot;


    public Enemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.enemyShoot = new EnemyShoot();
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
    }
}
