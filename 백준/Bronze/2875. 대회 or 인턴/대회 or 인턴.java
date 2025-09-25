
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int girl = N /2;
        int boy = M;
        int people = (N + M - K) / 3;

        int ans = Math.max(0, Math.min(girl, Math.min(boy, people)));
        System.out.println(ans);

    }
}