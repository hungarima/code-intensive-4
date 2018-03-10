public class EnemyShoot {

    private FrameCounter frameCounter;

    public EnemyShoot () {
        this.frameCounter = new FrameCounter(10);
    }

    public void run(Enemy enemy) {
        if (this.frameCounter.run()) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.x = enemy.x;
            bulletEnemy.y = enemy.y;
            bulletEnemy.dy = 7;
            GameObject.add(bulletEnemy);
        }
    }
}
