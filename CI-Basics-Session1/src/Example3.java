import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        System.out.println("n = ?");
        int n = keyboardScanner.nextInt();

        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
