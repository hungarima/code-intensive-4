import java.util.ArrayList;

public class WallTest {
//    public static void main(String[] args) {
//
//        Wall ghostWall;
//
//        Wall brickWall = new Wall();
//
//        Wall concreteWall = new Wall();
//
//        ghostWall = brickWall;
//        ghostWall.x = 10;
//        System.out.println(ghostWall.x);
//        System.out.println(concreteWall.x);
//        System.out.println(brickWall.x);
//    }
public static void main(String[] args) {
    //1. ArrayList toàn wall
    ArrayList<Wall> walls = new ArrayList<>();

    //2. Create Wall
    Wall newWall = new Wall(1, 2);

    //3.
    walls.add(newWall);
        walls.add(new Wall(2, 3));

    Wall temp = walls.get(0);
    if (temp.match(2, 2)) {
        System.out.println("Hura");
    }

    System.out.println(walls);

}
}
