import tracemap.Tracemap;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        char[][] map = {
                {'0','0','0','0','0'},
                {'1','1','0','0','0'},
                {'1','0','0','1','1'},
        };
        List<String> path = new ArrayList<>();
        path.add("right");
        path.add("up");
        path.add("right");
        path.add("right");
        System.out.println();
        System.out.println(Tracemap.findPotentialLocation(map, '1', path));
    }
}
