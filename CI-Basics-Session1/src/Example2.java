import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.println("n = ?");
        int n = keyboardScanner.nextInt();

        for (int i = 0; i < n*2; i++) {
            System.out.print("*");
            System.out.print("x");
        }
    }
}
