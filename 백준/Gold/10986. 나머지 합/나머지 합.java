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

        long[] arr = new long[M];
        long prefix = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            prefix = (prefix + x) % M;
            arr[(int) prefix]++;
        }

        long ans = 0;
        ans += arr[0];


        for (int i = 0; i < M; i++) {
            long c = arr[i];
            if (c >= 2) ans += c * (c -1) / 2;
        }

        System.out.println(ans);
    }
}