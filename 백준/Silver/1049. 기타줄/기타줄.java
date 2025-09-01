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

        int minSet = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int set = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());
            if (set < minSet) minSet = set;
            if (each < minEach) minEach = each;
        }

        int costA = minEach * N;

        int setAll = (N + 5) / 6;
        int costB = setAll * minSet;

        int k = N / 6;
        int r = N % 6;

        int costC = k * minSet + Math.min(minSet, r * minEach);

        int ans = Math.min(costA, Math.min(costB,costC));
        System.out.println(ans);

    }
}