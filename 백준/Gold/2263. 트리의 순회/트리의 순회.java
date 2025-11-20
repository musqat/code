import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] inorder, postorder, idx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inorder = new int[N];
        postorder = new int[N];
        idx = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            idx[inorder[i]] = i;
        }

        solve(0, N - 1, 0, N - 1);
        System.out.println(sb);
    }

    static void solve(int inL, int inR, int postL, int postR) {
        if (inL > inR || postL > postR) return;

        int root = postorder[postR];
        sb.append(root).append(" ");

        int mid = idx[root];
        int leftSize = mid - inL;

        solve(inL, mid - 1, postL, postL + leftSize - 1);
        solve(mid + 1, inR, postL + leftSize, postR - 1);
    }
}