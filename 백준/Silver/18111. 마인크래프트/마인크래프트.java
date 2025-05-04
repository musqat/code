import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] heightCount = new int[257];
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int h = arr[i][j];
                heightCount[h]++;
            }
        }
        int minTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        for (int i = 0; i <= 256; i++) {
            int time = 0;
            int inventory = B;

            for (int j = 0; j <= 256; j++) {
                int count = heightCount[j];

                if (j > i) {
                    time += (j - i) * count * 2;
                    inventory += (j - i) * count;
                } else if (j < i) {
                    time += (i - j) * count;
                    inventory -= (i - j) * count;
                }
            }

            if (inventory >= 0) {
                if (time < minTime || (time == minTime && i > resultHeight)) {
                    minTime = time;
                    resultHeight = i;
                }
            }
        }
        System.out.println(minTime +" "+resultHeight);

    }
}
