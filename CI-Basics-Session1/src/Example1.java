import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        System.out.println("n = ?");
        int n = keyboardScanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }
}
