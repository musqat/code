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

        int[] a = new int[N];
        int[] b = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < N && j < M){
            if (a[i] <= b[j]) sb.append(a[i++]).append(' ');
            else sb.append(b[j++]).append(' ');
        }

        while (i < N) sb.append(a[i++]).append(' ');
        while (j < M) sb.append(b[j++]).append(' ');



        System.out.println(sb);
    }
}
