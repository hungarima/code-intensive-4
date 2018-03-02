public class Enemy {
    int x;
    int y;

    public Enemy() {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean match (int x, int y) {
        return this.x == x && this.y == y;
    }
}
