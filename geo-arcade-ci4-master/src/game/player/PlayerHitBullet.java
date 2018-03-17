package game.player;

import base.GameObjectManager;
import game.enemy.Enemy;
import game.enemy.bullet.BulletEnemy;
import game.player.bullet.Bullet;
import game.square.bullet.BulletSquare;
import physic.BoxCollider;

public class PlayerHitBullet {
    public void run(Player player) {
        BoxCollider boxCollider = player.boxCollider;
        BulletEnemy bulletEnemy = GameObjectManager.instance.checkCollisionBullet(boxCollider);
        if (bulletEnemy != null) {
            bulletEnemy.isAlive = false;
            player.hitBullet();
        }
    }
}
