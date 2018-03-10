public class EnemyShoot {

    private FrameCounter frameCounter = new FrameCounter(10);

    public void run(Enemy enemy) {
        if (this.frameCounter.run()) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(0, 6);
            GameObject.add(bulletEnemy);
        }
    }
}
