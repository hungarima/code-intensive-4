public class Player extends GameObject {

    private PlayerShoot playerShoot;

    public Player() {
        this.image = Utils.loadImage("resources/player/straight.png");
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.playerShoot.run(this);
    }
}
