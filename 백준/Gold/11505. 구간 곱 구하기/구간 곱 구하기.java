import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tree = new long[N * 4];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, 0, N - 1, b - 1, c);
            } else {
                System.out.println(query(1, 0, N - 1, b - 1, c - 1));
            }

        }

    }

    static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            return tree[node] = (init(node * 2, start, mid) % MOD) * (init(node * 2 + 1, mid + 1, end) % MOD) % MOD;
        }
    }

    static long query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 1;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return (query(node * 2, start, mid, left, right) % MOD) * (query(node * 2 + 1, mid + 1, end, left, right) % MOD) % MOD;
    }

    static void update(int node, int start, int end, int idx, long val) {
        if (start == end) {
            tree[node] = val;
            arr[idx] = (int) val;
            return;
        }
        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(node * 2, start, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, val);
        }

        tree[node] = (tree[node * 2] % MOD) * (tree[node * 2 + 1] % MOD) % MOD;
    }

}
