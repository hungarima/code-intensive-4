public class Player {
    int x = 0;
    int y = 0;
    int atk = 0;
    int hp = 0;

    int vx = 0;
    int vy = 0;



    public Player (int x, int y, int atk, int hp) {
        this.x = x;
        this.y = y;
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
