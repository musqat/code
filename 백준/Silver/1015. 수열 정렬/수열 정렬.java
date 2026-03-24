import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) {
            idx[i] = i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(idx, (a, b) -> A[a] != A[b] ? A[a] - A[b] : a - b);

        for (int i = 0; i < N; i++) {
            B[idx[i]] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(B[i]).append(" ");
        }
        System.out.println(sb);
    }

}
