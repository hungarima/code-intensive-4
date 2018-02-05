import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        int n = 5;
        int m = 4;

        int x = 3;
        int y = 2;

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
    }
}
