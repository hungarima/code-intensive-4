import java.util.ArrayList;
import java.util.Arrays;
public class Map {
    String [][] data;

    public Map() {
        data = new String[][] {
                {"-", "W", "-", "-", "-"},
                {"-", "K", "-", "-", "-"},
                {"-", "W", "-", "-", "-"},
                {"-", "W", "W", "W", "-"},
                {"-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "E"}
        };
    }

    public int height() {
        return data.length;
    }

    public int width() {
        return data[0].length;
    }

    public boolean isValid(int x, int y) {
//        if (x < 0 || x >= width()) return false;
//        if (y < 0 || y >= height()) return false;
//        return true;
        return x >= 0 && x < width()
                && y >= 0 && y < height();
    }

    public String cellAt(int x, int y) {
        if (!isValid(x, y)) return null;
        return data[y][x];
    }

    public void setCellAt(int x, int y, String value) {
        if (!isValid(x, y)) return;
        data[y][x] = value;
    }

    public int count(String value) {

        int result = 0;

        for (String[] row : data) {
            for (String cell : row) {
                if (cell.equalsIgnoreCase(value)) {
                    result++;
                }
            }
        }

        return result;
    }

    public void print() {
        for(String[] row : data) {
            for(String cell : row) {
                System.out.print(cell);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Map testMap = new Map();

        testMap.setCellAt(2, 1, "y");
        testMap.print();
    }
}
