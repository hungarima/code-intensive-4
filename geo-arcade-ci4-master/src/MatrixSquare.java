import java.util.Vector;

public class MatrixSquare extends GameObject{

    private Vector<Square> squares = new Vector<>();
    public int dx;
    public int dy;
    private int count = 0;
    private boolean collision = false;

    public void create() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Square square = new Square();
                square.x = this.x + j * (20 + 20);
                square.y = this.y + i * (20 + 20);
                square.dx = this.dx;
                square.dy = this.dy;
                this.squares.add(square);
                GameObject.add(square);
            }
        }
    }

    @Override
    public void run() {
        super.run();
        if (this.x <= 0 ) {
            if (this.count >= 10) {
                this.dx = 3;
                this.count = 0;
                this.dy = 0;
                this.collision = true;
            } else {
                this.dx = 0;
                this.count += 1;
                this.dy = 3;
            }

        }
        if (this.x >= 400 - 20 * 5 - 20 * 4){
            if (this.count >= 10) {
                this.dx = -3;
                this.count = 0;
                this.dy = 0;
            } else {
                this.dx = 0;
                this.count += 1;
                this.dy = 3;
            }

        }
        this.x += this.dx;
        this.y += this.dy;
        this.squares.forEach(square -> {
            square.dx = dx;
            square.dy = dy;
        });
    }
}
