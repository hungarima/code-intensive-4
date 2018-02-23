import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by huynq on 2/3/18.
 */

/**
 * Vector, ArrayList and LinkedList
 *
 * ArrayList is implemented as a resizable array. As more elements are added to ArrayList, its size is increased dynamically. Its elements can be accessed directly using get and set methods
 *
 * LinkedList is implemented as a double linked list. Its performance on add and remove is better than Arraylist but worse on get and set methods. The real difference is their underlying implementation and their operation complexity.
 *
 * Vector is similar with ArrayList, but it''s synchronized
 *
 */
public class DungeonGame {

    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        Map map = new Map (6,5 );

        Player player1 = new Player(1, 0);

        Exit exit = new Exit(3, 3);

        Key key = new Key(0, 3, false);

        Monster monster = new Monster(2, 3, false);

        ArrayList<Wall> walls = new ArrayList<>();

        walls.add(new Wall(1,1));
        walls.add(new Wall(2,1));
        walls.add(new Wall(3,1));


        int vx = 0;
        int vy = 0;



        while (true) {
            for (int y = 0; y < map.height; y ++) {
                for (int x = 0; x < map.width; x++) {

                    for (Wall wall: walls) {
                        if (wall.match(x, y)) {
                            System.out.print("W ");
                            x++;
                        }

                    }

                    if (player1.match(x, y)) {
                        System.out.print("P ");
                    }
                    else if (key.match(x, y) && !key.hasKey) {
                        System.out.print("K ");
                    }
                    else if (monster.match(x, y) && !monster.killed) {
                        System.out.print("M ");
                    }
                    else if (exit.match(x, y)) {
                        System.out.print("E ");
                    }
                    else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }

            System.out.print("Your move? ");
            String command = keyboardScanner.nextLine();

            vx = 0;
            vy = 0;

            if (command.equalsIgnoreCase("w")) {
                vy = -1;
            }
            else if(command.equalsIgnoreCase("s")) {
                vy = 1;
            }
            else if(command.equalsIgnoreCase("a")) {
                vx = -1;
            }
            else if(command.equalsIgnoreCase("d")) {
                vx = 1;
            }

            player1.x += vx;
            player1.y += vy;

            if (player1.x < 0) player1.x = 0;
            if (player1.x >= map.width) player1.x = map.width - 1;
            if (player1.y < 0) player1.y = 0;
            if (player1.y >= map.height) player1.y = map.height - 1;

//            if (player1.x == wx && player1.y == wy) {
//                player1.x -= vx;
//                player1.y -= vy;
//            }


            for (Wall wall : walls) {
                if(player1.x == wall.x && player1.y == wall.y) {
                    player1.x -= vx;
                    player1.y -= vy;
                }
            }


//            if (player1.x == key.x && player1.y == key.y) {
//                System.out.println("You got the key");
//                key.hasKey = true;
//            }
            key.matchKey(player1.x, player1.y);


            // Monster
            if (player1.x == monster.x && player1.y == monster.y && !monster.killed) {
                int choice;
                System.out.println("Say hi to the monster!");
                System.out.println("You can:");
                System.out.println("1. Attack ittttttt!");
                System.out.println("2. Or runaway like a coward!");
                do
                {
                    choice = keyboardScanner.nextInt();
                } while (choice != 1 && choice != 2);

                if (choice == 1) {
                    monster.killed = true;
                    System.out.println("How dare you kill this cute monster!");
                }
                else if (choice == 2) {
                    System.out.println("You coward!!!!");
                    if (vy == -1) player1.y -= vy;;
                    if (vy == 1) player1.y -= vy;;
                    if (vx == -1) player1.x -= vx;
                    if (vx == 1) player1.x -= vx;
                    }

            }

            if (player1.x == exit.x && player1.y == exit.y) {
                if (!key.hasKey) {
                    System.out.println("Get the key dude!");
                } else {
                    System.out.println("You won");
                    break;
                }
            }
        }
    }
}
