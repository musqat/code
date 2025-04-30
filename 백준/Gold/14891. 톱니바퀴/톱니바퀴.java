import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] cogwheel = new int[4][8];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                cogwheel[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            visited = new boolean[4];
            rotate(num, dir);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (cogwheel[i][0] == 1) score += (1 << i);
        }
        System.out.println(score);
    }

    public static void rotate(int num, int dir) {
        visited[num] = true;

        if (num > 0 && !visited[num - 1]) {
            if (cogwheel[num - 1][2] != cogwheel[num][6]) {
                rotate(num - 1, -dir);
            }
        }

        if (num < 3 && !visited[num + 1]) {
            if (cogwheel[num][2] != cogwheel[num + 1][6]) {
                rotate(num + 1, -dir);
            }
        }
        spin(num, dir);
    }

    public static void spin(int num, int dir) {
        if (dir == 1) { // 시계
            int temp = cogwheel[num][7];
            for (int i = 7; i > 0; i--) {
                cogwheel[num][i] = cogwheel[num][i - 1];
            }
            cogwheel[num][0] = temp;
        } else { // 반시계
            int temp = cogwheel[num][0];
            for (int i = 0; i < 7; i++) {
                cogwheel[num][i] = cogwheel[num][i + 1];
            }
            cogwheel[num][7] = temp;
        }
    }
}
