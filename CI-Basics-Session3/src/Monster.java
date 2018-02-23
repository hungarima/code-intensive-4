public class Monster {
    int x = 0;
    int y = 0;
    boolean killed = false;

    public Monster (int x, int y, boolean killed) {
        this.x = x;
        this.y = y;
        this.killed = killed;
    }

    public boolean match(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        }
        else {
            return false;
        }
    }

}
