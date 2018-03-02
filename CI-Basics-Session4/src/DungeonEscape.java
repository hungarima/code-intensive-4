import java.util.Scanner;

public class DungeonEscape {
    public static void main(String[] args) {
        DungeonMaster dungeonMaster = new DungeonMaster();
        Scanner keyboardScanner = new Scanner(System.in);

        while(!dungeonMaster.gameEnd) {
            dungeonMaster.print();

            System.out.println("You command?");
            String command = keyboardScanner.nextLine();
            dungeonMaster.runCommand(command);
        }
    }
}
