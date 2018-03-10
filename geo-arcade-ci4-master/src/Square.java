public class Square extends GameObject {

    public int dx;
    public int dy;

    public Square() {
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
    }

    @Override
    public void run() {
        super.run();
        this.x += this.dx;
        this.y += this.dy;
    }
}
