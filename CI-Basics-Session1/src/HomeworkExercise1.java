import java.util.Scanner;

public class HomeworkExercise1 {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        int n = 5;
        int m = 4;

        int x = 1;
        int y = 2;

        while (true) {

            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == x && j == y ) {
                        System.out.print("P ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }

            System.out.println("Your move? (W,S,D,A)");
            String move = keyboardScanner.nextLine().toUpperCase();

            if (move.equals("W")) {
                if (x == 0) {
                    System.out.println("Can't move!");
                } else {
                    x -= 1;
                }
            } else if (move.equals("S")) {
                if (x == m -1) {
                    System.out.println("Can't move!");
                } else {
                    x += 1;
                }
            } else if (move.equals("A")) {
                if (y == 0) {
                    System.out.println("Can't move!");
                } else {
                    y -= 1;
                }
            } else if (move.equals("D")) {
                if (y == n-1) {
                    System.out.println("Can't move!");
                } else {
                    y += 1;
                }
            } else {
                System.out.println("Wrong Command!!");
            }


        }

    }
}
