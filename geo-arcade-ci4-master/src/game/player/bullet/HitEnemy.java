package game.player.bullet;

import base.GameObjectManager;
import game.enemy.Enemy;
import game.player.Player;
import physic.BoxCollider;

public class HitEnemy {
    public void run(Bullet bullet) {
        BoxCollider boxCollider = bullet.boxCollider;
        Enemy enemy = GameObjectManager.instance.checkCollisionEnemy(boxCollider);
        if (enemy != null) {
            enemy.isAlive = false;
            bullet.getHitEnemy();
        }
    }
}
