public class Enemy extends GameObject {
    public int dx;
    public int dy;
    private EnemyShoot enemyShoot;


    public Enemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.enemyShoot = new EnemyShoot();
    }

    @Override
    public void run() {
        super.run();
        this.x += this.dx;
        this.y += this.dy;
        this.enemyShoot.run(this);
    }
}
