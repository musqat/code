import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        StringTokenizer type = new StringTokenizer(br.readLine());
        StringTokenizer storage = new StringTokenizer(br.readLine());

        List<Long> qs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(type.nextToken());
            long b =  Long.parseLong(storage.nextToken());
            if (t == 0) qs.add(b);
        }

        int K = qs.size();

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] C = new long[M];
        for (int i = 0; i < M; i++) {
            C[i] = Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (i > 0) sb.append(" ");
            sb.append(i < K ? qs.get(K -1 - i) : C[i - K]);
        }

        System.out.println(sb);
    }


}