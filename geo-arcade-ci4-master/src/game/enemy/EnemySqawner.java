package game.enemy;

import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EnemySqawner extends GameObject {
    private int count = 0;
    private Random random;

    public EnemySqawner() {
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 80) {
            Enemy enemy = new Enemy();
            enemy.position.set(random.nextInt(400), 0);
            enemy.velocity.set(0, random.nextInt(2) + 1);
            GameObjectManager.instance.add(enemy);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
