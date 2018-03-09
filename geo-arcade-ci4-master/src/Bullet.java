public class Bullet extends GameObject {

    public int dx;
    public int dy;

    public Bullet() {
        this.image = Utils.loadImage("resources/player/player_bullet.png");

    }

    @Override
    public void run() {
        super.run();
        this.x += this.dx;
        this.y += this.dy;
    }
}
