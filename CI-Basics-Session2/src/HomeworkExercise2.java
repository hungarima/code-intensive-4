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

        int xW = 2;
        int yW = 1;

        Boolean gotKey = false;

        int turn = 0;

        while (true) {
            // view
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
                    else if (x == xW && y == yW) {
                        System.out.print("W ");
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
                turn++;
            } else if (move.equals("S")) {
                yP++;
                turn++;
            } else if (move.equals("A")) {
                xP--;
                turn++;
            } else if (move.equals("D")) {
                xP++;
                turn++;
            } else {
                System.out.println("Wrong Command!!");
            }


            // Clamp
            // for border

            if (yP < 0) yP = 0;
            if (yP >= m) yP = m - 1;

            if (xP < 0) xP = 0;
            if (xP >= n) xP = n-1;

            // for wall
            if (move.equals("W") && xP == xW && yP == yW) yP++;
            if (move.equals("S") && xP == xW && yP == yW) yP--;
            if (move.equals("A") && xP == xW && yP == yW) xP++;
            if (move.equals("D") && xP == xW && yP == yW) xP--;



            if (xP == xK && yP == yK) {
                gotKey = true;
                System.out.println("You got the key!");
            }

            if ( xP == xE && yP == yE ){
                if (gotKey) {
                    System.out.println("You won!!");
                    break;
                } else {
                    System.out.println("You forgot the key dude");
                }

            }

        }


    }
}
