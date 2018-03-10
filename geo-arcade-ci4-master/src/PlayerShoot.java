public class PlayerShoot {

    private int count = 0;

    public void run(Player player) {
        if (this.count >= 30) {
            Bullet bullet = new Bullet();
            bullet.position.set(player.position);
            bullet.velocity.set(0, -4);
            GameObject.add(bullet);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
