import java.util.Random;

public class SquareSpawner extends GameObject {

    private int count = 0;
    private Random random = new Random();

    public SquareSpawner() {
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 30) {
            Square square = new Square();
            square.x = random.nextInt(400);
            square.dy = random.nextInt(4) + 2;
            GameObject.add(square);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
