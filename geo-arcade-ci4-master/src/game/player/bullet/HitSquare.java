package game.player.bullet;

import base.GameObject;
import base.GameObjectManager;
import game.square.Square;
import physic.BoxCollider;

/**
 * Created by huynq on 3/15/18.
 */
public class HitSquare {

    public void run(Bullet bullet) {
        BoxCollider boxCollider = bullet.boxCollider;
        Square square = GameObjectManager.instance.checkCollision(boxCollider);
        if (square != null) {
            square.isAlive = false;
            bullet.getHit();
        }
    }
}
