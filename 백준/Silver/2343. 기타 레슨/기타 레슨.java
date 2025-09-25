
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        long low = 0;
        long high = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            low = Math.max(low, A[i]);
            high += A[i];
        }

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (count(mid) <= M) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        System.out.println(low);
    }

    static int count(long cap) {
        int cnt = 1;
        long sum = 0;
        for (int x : A) {
            if (sum + x <= cap) {
                sum += x;
            } else {
                cnt++;
                sum = x;
            }
        }
        return cnt;
    }
}