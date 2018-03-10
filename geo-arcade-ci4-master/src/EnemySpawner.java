import java.util.Random;

public class EnemySpawner extends GameObject {
    private int count = 0;
    private Random random;

    public EnemySpawner() {
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 80) {
            Enemy enemy = new Enemy();
            enemy.x = random.nextInt(400);
            enemy.dy = random.nextInt(3) + 1;
            GameObject.add(enemy);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
