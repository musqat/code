import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] maxDp = new int[2][3];
        int[][] minDp = new int[2][3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxDp[0][i] = num;
            minDp[0][i] = num;
        }


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            maxDp[1][0] = Math.max(maxDp[0][0], maxDp[0][1]) + a;
            maxDp[1][1] = Math.max(Math.max(maxDp[0][0], maxDp[0][1]), maxDp[0][2]) + b;
            maxDp[1][2] = Math.max(maxDp[0][1], maxDp[0][2]) + c;

            minDp[1][0] = Math.min(minDp[0][0], minDp[0][1]) + a;
            minDp[1][1] = Math.min(Math.min(minDp[0][0], minDp[0][1]), minDp[0][2]) + b;
            minDp[1][2] = Math.min(minDp[0][1], minDp[0][2]) + c;


            for (int j = 0; j < 3; j++) {
                maxDp[0][j] = maxDp[1][j];
                minDp[0][j] = minDp[1][j];
            }
        }
        int max = Math.max(Math.max(maxDp[0][0], maxDp[0][1]),maxDp[0][2]);
        int min = Math.min(Math.min(minDp[0][0], minDp[0][1]),minDp[0][2]);

        System.out.println(max + " " + min);
    }
}
