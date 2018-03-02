import java.util.ArrayList;
import java.util.Random;

public class DungeonMaster {
    Map map;
    Player player;
    boolean gameEnd = false;
    boolean winning = false;
    ArrayList<Enemy> enemies;

    public DungeonMaster() {
        map = new Map();
        player = new Player();
        enemies = new ArrayList<>();

        //Test
//        enemies.add(new Enemy(2, 1));
//        enemies.add(new Enemy(3, 4));
        spawnEnemies();
    }

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void spawnEnemies() {
        // List all candidate position
        ArrayList<Point> candidatePosition = new ArrayList<>();
        Random random = new Random();

        for (int y = 0; y < map.height(); y++) {
            for (int x = 0; x < map.width(); x++) {
                if (!player.match(x, y) &&
                        map.cellAt(x, y).equalsIgnoreCase("-")) {
                    Point candidate = new Point(x, y);
                    candidatePosition.add(candidate);
                }
            }
        }
        // Random enemy position
        for (int i = 0; i < 2; i++) {
            if (candidatePosition.size() == 0) break;
            int index= random.nextInt(candidatePosition.size());
            Point p = candidatePosition.get(index);
            candidatePosition.remove(index);
            enemies.add(new Enemy(p.x, p.y));
        }

    }


    public void runCommand(String cmd) {
        int dx = 0;
        int dy = 0;

        if (cmd.equalsIgnoreCase("w")) dy = -1;
        else if (cmd.equalsIgnoreCase("s")) dy = 1;
        else if (cmd.equalsIgnoreCase("a")) dx = -1;
        else if (cmd.equalsIgnoreCase("d")) dx = 1;

        int nextX = player.getX() + dx;
        int nextY = player.getY() + dy;


        //Outside map
        if (!map.isValid(nextX, nextY)) return;

        String cellAtNextPosition = map.cellAt(nextX, nextY);

        // Hit a wall

        if (cellAtNextPosition.equalsIgnoreCase("w")) return;

        if (cellAtNextPosition.equalsIgnoreCase("k")) {
            System.out.println("You got the key");
            map.setCellAt(nextX, nextY, "-");
        }

        if(cellAtNextPosition.equalsIgnoreCase("e")) {
            if (map.count("k") == 0) {
                System.out.println("You won!");
                gameEnd = true;
                winning = true;
            } else {
                System.out.println("Get the key, dude");
            }
        }

        // Valid Move
        player.setX(nextX);
        player.setY(nextY);


    }

    public void print() {
        for(int y = 0; y < map.height() ;y++) {
            for (int x = 0; x < map.width(); x++) {
                if (!printPlayer(x, y)) {
                    if (!printEnemies(x, y)) {
                        System.out.print(map.cellAt(x, y));
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public boolean printPlayer(int x ,int y) {
        if (player.match(x, y)) {
            System.out.print("P ");
            return true;
        } else {
            return false;
        }
    }

    public boolean printEnemies(int x,int y) {
        for (Enemy enemy : enemies) {
            if (enemy.match(x, y)) {
                System.out.print("M ");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DungeonMaster master= new DungeonMaster();
    }
}
