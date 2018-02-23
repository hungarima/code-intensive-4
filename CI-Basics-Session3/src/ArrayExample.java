import java.util.ArrayList;
import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {

        // Array
        String[] badHabits = new String[]{
                "Learning outsideasdfasfsadfsadf",
                "Watching neighbor'asdfsafsadfdsfsdsafdsfasdfsads roof",
                "Watching movie in lasddfecture"
        };

        //List
        ArrayList<String> badHabitList = new ArrayList<>();
        badHabitList.add("Mua cung doan voi co giao");
        badHabitList.add("Hoc ngoai gioi");

        System.out.println(badHabitList.get(0));
        System.out.println(badHabitList.set(0, "Nhin tu cau thang len tren"));




//        for (int i = 0; i < badHabits.length; i++) {
//            System.out.println(i+1 + ". " + badHabits[i]);
//        }
        //for each loop

//        boolean hasShortString = false;
//
//        for (String habit : badHabits) {
//            if (habit.length() < 22) {
//                hasShortString = true;
//            }
//        }
//
//        System.out.println(hasShortString);


    }
}
