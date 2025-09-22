
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[7][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            arr[grade][gender]++;
        }

        int result = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                int cnt = arr[i][j];
                if (cnt == 0) continue;
                result += (cnt + K - 1) / K;
            }
        }

        System.out.println(result);
    }

}