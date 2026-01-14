import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int solution(String dirs) {
        int answer = 0;

        Map<Character, Integer> dirMap = new HashMap<>();
        dirMap.put('U', 0);
        dirMap.put('D', 1);
        dirMap.put('L', 2);
        dirMap.put('R', 3);

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Set<String> visited = new HashSet<>();

        int x = 0, y = 0;

        for (char dir : dirs.toCharArray()){
            int idx = dirMap.get(dir);
            int nx = x + dx[idx];
            int ny = y + dy[idx];


            if (nx < -5 || nx > 5 || ny < -5 || ny > 5){
                continue;
            }

            String path = makePath(x,y,nx,ny);
            visited.add(path);

            x = nx;
            y = ny;
        }


        return visited.size();
    }

    private String makePath(int x1, int y1, int x2, int y2){
        if (x1 > x2 || (x1 == x2 && y1 > y2)){
            return x2 + "," + y2 + "-" + x1 + "," + y1;
        }

        return x1 + "," + y1 + "-" + x2 + "," + y2;
    }
}