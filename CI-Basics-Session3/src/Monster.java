public class Monster {
    int x = 0;
    int y = 0;
    int atk = 0;
    int hp = 0;
    boolean killed = false;

    public Monster (int x, int y, boolean killed, int atk, int hp) {
        this.x = x;
        this.y = y;
        this.killed = killed;
        this.atk = atk;
        this.hp = hp;
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
