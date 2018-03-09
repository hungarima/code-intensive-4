public class EnemyShoot {

    private int count = 0;

    public void run(Enemy enemy) {
        if (this.count >= 10) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.x = enemy.x;
            bulletEnemy.y = enemy.y;
            bulletEnemy.dy = 7;
            GameObject.add(bulletEnemy);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
