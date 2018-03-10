public class Bullet extends GameObject {

    public Vector2D velocity;

    public Bullet() {
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D();

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}
