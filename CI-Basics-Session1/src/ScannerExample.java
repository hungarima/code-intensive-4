import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

//        System.out.print("Enter a number? ");
//        int number = keyboardScanner.nextInt();
//        System.out.println(String.format("You just entered %s", number));

        // "Enter a string?"
//        System.out.println("Enter a string? ");
//        String string = keyboardScanner.nextLine(); // different from .next()
//        System.out.println(String.format("You just entered %s", string));

//        for (int i = 0; i < 4; i++)
        while (true) { // game loop
            System.out.println("Enter a: ");
            int a = keyboardScanner.nextInt();

            System.out.println("Enter b: ");
            int b = keyboardScanner.nextInt();

            System.out.println("Operation: ");
            String sign = keyboardScanner.next();

            // int, float, double, byte ==
            // String, map
            if (sign.equals("+")) {
                System.out.println(String.format("%s + %s = %s", a, b, a+b));
            } else if( sign.equals("-")) {
                System.out.println(String.format("%s - %s = %s", a, b, a-b));
            } else if(sign.equals("*")) {
                System.out.println(String.format("%s * %s = %s", a, b, a*b));
            } else if(sign.equals("/")) {
                System.out.println(String.format("%s / %s = %s", a, b, a/b));
            } else {
                System.out.println("Error!");
            }
        }

    }
}
