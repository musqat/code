import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> homes = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) homes.add(new int[]{i, j});
                else if (tmp == 2) chickens.add(new int[]{i, j});
            }
        }


        combination(new ArrayList<>(), 0);
        System.out.println(min);

    }

    static void combination(List<int[]> selected, int idx){
        if (selected.size() == m) {
            int totalDist = 0;
            for (int[] home : homes) {
                int dist = Integer.MAX_VALUE;
                for (int[] chicken : selected) {
                    dist = Math.min(dist, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
                }
                totalDist += dist;
            }
            min = Math.min(min, totalDist);
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            combination(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }
}
