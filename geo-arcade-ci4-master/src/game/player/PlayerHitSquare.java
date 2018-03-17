package game.player;

import base.GameObjectManager;
import game.square.Square;
import physic.BoxCollider;

public class PlayerHitSquare {
    public void run(Player player) {
        BoxCollider boxCollider = player.boxCollider;
        Square square= GameObjectManager.instance.checkCollisionSquare(boxCollider);
        if (square != null) {
            square.isAlive = false;
            player.hitSquare();
        }
    }
}
