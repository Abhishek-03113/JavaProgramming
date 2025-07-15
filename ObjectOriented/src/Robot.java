import java.util.HashMap;
import java.util.Scanner;

class robo {


    public String Direction;

    public String getDirection() {
        return Direction;
    }

    String movement(String direction, String Command, int[] position) {
        HashMap<String, String> north = new HashMap<>(), south = new HashMap<>(), east = new HashMap<>(), west = new HashMap<>();
        north.put("left", "west");
        north.put("right", "east");
        south.put("left", "east");
        south.put("right", "west");
        east.put("left", "north");
        east.put("right", "south");
        west.put("left", "south");
        west.put("right", "north");

        switch (direction) {
            case "north" -> {
                switch (Command) {
                    case "L" -> direction = north.get("left");
                    case "R" -> direction = north.get("right");
                    case "F" -> position[1] += 1;
                    case "B" -> position[1] -= 1;
                }
            }
            case "east" -> {

                switch (Command) {
                    case "L" -> direction = east.get("left");
                    case "R" -> direction = east.get("right");
                    case "F" -> position[0] += 1;
                    case "B" -> position[0] -= 1;
                }
            }
            case "west" -> {
                switch (Command) {
                    case "L" -> direction = west.get("left");
                    case "R" -> direction = west.get("right");
                    case "F" -> position[0] -= 1;
                    case "B" -> position[0] += 1;
                }
            }
            case "south" -> {
                switch (Command) {
                    case "L" -> direction = south.get("left");
                    case "R" -> direction = south.get("right");
                    case "F" -> position[1] -= 1;
                    case "B" -> position[1] += 1;
                }
            }
        }

        if (position[0] >= 5) {
            System.out.println("The Robot Has Fallen off the plane");
            return "";
        } else if (position[1] >= 5) {
            System.out.println("The Robot Has Fallen off the plane");
            return "";
        }

        return direction;
    }
}

public class Robot {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        robo robo = new robo();
        String Direction = "north";
        String commands = "LRFBRFRL";
        int[] pos = {0, 0};
        String dir = "";
        for (int i = 0; i < commands.length(); i++) {
            String cmd = commands.charAt(i) + "";
            dir = robo.movement(Direction, cmd, pos);
        }
        System.out.println(pos[0]);
        System.out.println(pos[1]);

        System.out.println(dir);
//        Scanner input = new Scanner(System.in);


    }

}