import java.util.Scanner;


public class HomeworkExercise2 {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        int n = 5;
        int m = 4;

        int xP = 2;
        int yP = 0;

        int xE = 4;
        int yE = 3;

        int xK = 2;
        int yK = 2;


        int [][] walls =
                {
                        {1, 1},
                        {2, 1},
                        {3, 1}
                };

        int xM = 4;
        int yM = 2;


        Boolean gotKey = false;
        Boolean monKilled = false;

        int turnP = 0;
        int turnM = 0;


        while (true) {

            // view
            int wallNum = 0;
            for (int y = 0; y < m ; y++) {
                for (int x = 0; x < n; x++) {
                    if (x == xP && y == yP ) {
                        System.out.print("P ");
                    }
                    else if (x == xE && y == yE) {
                        System.out.print("E ");
                    }
                    else if (x == xK && y == yK && !gotKey){
                        System.out.print("K ");
                    }
                    else if (x == xM && y == yM && !monKilled) {
                        System.out.print("M ");
                    }
                    else if (x == walls[wallNum][0] && y == walls[wallNum][1]) {
                        System.out.print("W ");
                        if (wallNum < walls.length - 1) {
                            wallNum++;
                        }
                    }
                    else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }

            System.out.println("Your move? (W,S,D,A)");
            String move = keyboardScanner.nextLine().toUpperCase();

            if (move.equals("W")) {
                yP--;
                turnP++;
            } else if (move.equals("S")) {
                yP++;
                turnP++;
            } else if (move.equals("A")) {
                xP--;
                turnP++;
            } else if (move.equals("D")) {
                xP++;
                turnP++;
            } else {
                System.out.println("Wrong Command!!");
            }


            // Clamp
            // for border

            if (yP < 0) yP = 0;
            if (yP >= m) yP = m - 1;

            if (xP < 0) xP = 0;
            if (xP >= n) xP = n-1;

            // for wallNum

            for (int z = 0; z < walls.length; z++) {
                if (move.equals("W") && xP == walls[z][0] && yP == walls[z][1]) yP++;
                if (move.equals("S") && xP == walls[z][0] && yP == walls[z][1]) yP--;
                if (move.equals("A") && xP == walls[z][0] && yP == walls[z][1]) xP++;
                if (move.equals("D") && xP == walls[z][0] && yP == walls[z][1]) xP--;
            }

            // for Monsters


            if (xP == xM && yP == yM && !monKilled) {
                int choice;
                System.out.println("Say hi to the little monster!");
                System.out.println("You can:");
                System.out.println("1. Attack ittttttt!");
                System.out.println("2. Or runaway like a coward!");
                do
                {
                   choice = keyboardScanner.nextInt();
                } while (choice != 1 && choice != 2);

                if (choice == 1) {
                    monKilled = true;
                    System.out.println("How dare you kill this cute monster!! God bless!!");
                }
                else if (choice == 2) {
                    System.out.println("You coward!!!!");
                    if (turnM < 2) {
                        if (move.equals("W") && xP == xM && yP == yM) yP++;
                        if (move.equals("S") && xP == xM && yP == yM) yP--;
                        if (move.equals("A") && xP == xM && yP == yM) xP++;
                        if (move.equals("D") && xP == xM && yP == yM) xP--;
                        turnM++;
                    } else {
                        System.out.println("You death!!");
                        break;
                    }

                    turnP--;
                }


            }


            if (xP == xK && yP == yK) {
                gotKey = true;
                System.out.println("You got the key!");
            }

            if ( xP == xE && yP == yE ){
                if (gotKey) {
                    System.out.println("You won!!");
                    System.out.println(String.format("Number of turnP you did: %d", turnP));
                    break;
                } else {
                    System.out.println("You forgot the key dude");
                }

            }

        }



    }
}
