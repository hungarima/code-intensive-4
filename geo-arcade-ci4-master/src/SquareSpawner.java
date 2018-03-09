import java.util.Random;

public class SquareSpawner extends GameObject {

    private int count = 0;
    private Random random = new Random();

    public SquareSpawner() {
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 40) {
            Square square = new Square();
            Square square1 = new Square();
            Square square2 = new Square();

            square.y = 50;
            square1.y = 100;
            square2.y = 150;
            square1.dx = 3;
            square2.dx = 3;
            square.dx = 3;


            GameObject.add(square);
            GameObject.add(square1);
            GameObject.add(square2);

//            square.dy = random.nextInt(4) + 2;

            this.count = 0;
        } else {

            this.count += 1;
        }
    }
}
