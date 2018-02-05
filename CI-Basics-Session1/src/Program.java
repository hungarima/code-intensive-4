public class Program {
    public static void main(String[] args){
        System.out.println("Hello World!");
        System.out.println("Hello CI!!!!!!!");

        // 1. Variables
        int a = 5;
        int b = 6;
        int c = a+b;

//        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
//        String output = String.format("a = %d, b = %d, c = %d", a, b, c);
//        System.out.println(output);

        System.out.println(String.format("a = %s, b = %s, c = %s", a, b, c ));

        System.out.println(a);
        System.out.println(b);
        System.out.println(a*b);
        System.out.println(c);

        // Using string for:
        // File path
        // string formatting

        String s = "Who am I?";
        String s1 = "Where am I?";
        System.out.println(s);
        System.out.println(s1);

        System.out.println(s + ", " + s1); // concatenate

        System.out.print(s);
        System.out.print(", ");
        System.out.println(s1);

    }
}
