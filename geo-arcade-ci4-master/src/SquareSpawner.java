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
            square.position.set(random.nextInt(400), 0);
            square.velocity.set(0, random.nextInt(4) + 2);
            GameObject.add(square);
        }
    }
}
