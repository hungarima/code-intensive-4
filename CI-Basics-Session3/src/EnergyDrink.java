public class EnergyDrink {
    int x = 0;
    int y = 0;
    boolean hasRB = false;

    public EnergyDrink (int x, int y) {
        this.x = x;
        this.y = y;
        this.hasRB = hasRB;
    }

    public boolean match(int x, int y) {
        if(this.x == x && this.y == y) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean getDrunk(int x, int y, int atk) {
//        if (this.x == x && this.y == y) {
//            System.out.println("You got 1 Red Bull");
//            System.out.println("Double your Attack Damage!");
//            atk *= 2;
//            hasRB = true;
//            return true;
//        } else {
//            return false;
//        }

}
