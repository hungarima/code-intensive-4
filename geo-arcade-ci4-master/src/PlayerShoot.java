public class PlayerShoot {

    private int count = 0;
    private FrameCounter frameCounter;

    public PlayerShoot () {
        this.frameCounter = new FrameCounter(30);
    }

    public void run(Player player) {
        if (this.frameCounter.run()) {
            Bullet bullet = new Bullet();
            bullet.x = player.x;
            bullet.y = player.y;
            bullet.dy = -4;
            GameObject.add(bullet);
        }
    }
}
