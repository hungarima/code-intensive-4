public class Wall {
    int x = 0;
    int y = 0;

    public Wall(int x, int y) { // constructor
        this.x = x;
        this.y = y;
    }

    public boolean match(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return String.format("{x = %s, y = %s}", x, y);
    }
}
