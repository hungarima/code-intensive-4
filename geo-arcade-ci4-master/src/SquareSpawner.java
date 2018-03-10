import java.util.Random;

public class SquareSpawner extends GameObject {

    private FrameCounter frameCounter;
    private Random random = new Random();

    public SquareSpawner() {
        this.frameCounter = new FrameCounter(60);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Square square = new Square();
            square.x = random.nextInt(400);
            square.dy = random.nextInt(4) + 2;
            GameObject.add(square);
        }
    }
}
