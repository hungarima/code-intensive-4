public class EnergyDrink {
    int x = 0;
    int y = 0;

    public EnergyDrink (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean match(int x, int y) {
        if(this.x == x && this.y == y) {
            return true;
        } else {
            return false;
        }
    }

}
