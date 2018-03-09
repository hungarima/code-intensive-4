public class BulletEnemy extends GameObject {
    public int dx;
    public int dy;

    public BulletEnemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");

    }

    @Override
    public void run() {
        super.run();
        this.x += this.dx;
        this.y += this.dy;
    }
}
