public class BulletEnemy extends GameObject {
    public Vector2D velocity;

    public BulletEnemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");
        this.velocity = new Vector2D();

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}
