import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[N * 2];
        boolean[] robot = new boolean[N];
        int zeroCnt = 0;
        int step = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < belt.length; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }


        while (zeroCnt < K) {
            step++;
            // 벨트 회전
            int lastBelt = belt[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = lastBelt;

            //로봇 회전

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }

            robot[0] = false;

            robot[N - 1] = false;


            for (int i = N - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    belt[i + 1]--;
                    if (belt[i + 1] == 0) zeroCnt++;
                }
            }

            robot[N - 1] = false;

            if (!robot[0] && belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
                if (belt[0] == 0) zeroCnt++;
            }

        }


        System.out.println(step);
    }
}