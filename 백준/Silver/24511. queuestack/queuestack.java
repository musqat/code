import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] type = new int[N];
        int[] storage = new int[N];
        for (int i = 0; i < N; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N; i++) {
            storage[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] C = new long[M];
        for (int i = 0; i < M; i++) {
            C[i] = Long.parseLong(st.nextToken());
        }
        List<Long> qs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (type[i] == 0) qs.add((long) storage[i]);
        }
        int K = qs.size();

        for (int i = 0; i < M; i++) {
            if (i < K) sb.append(qs.get(K -1 - i));
            else sb.append(C[i - K]);
            if (i < M - 1) sb.append(" ");
        }

        System.out.println(sb);
    }


}