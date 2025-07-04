import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tree = new long[N + 1];
        arr = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            long val = Long.parseLong(br.readLine());
            arr[i] = val;
            update(i, val);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(b, diff);
            } else if (a == 2) {
                System.out.println(prefixSum((int)c) - prefixSum(b - 1));
            }

        }
    }

    static long prefixSum(int i) {
        long sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }

    static void update(int i, long diff) {
        while (i <= N) {
            tree[i] += diff;
            i += (i & -i);
        }
    }
}
