package game.enemy.bullet;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.enemy.Enemy;

public class EnemyShoot {

    private FrameCounter frameCounter = new FrameCounter(50);

    public void run(Enemy enemy) {
        if (this.frameCounter.run()) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(0, 4);
            GameObjectManager.instance.add(bulletEnemy);
        }
    }
}
