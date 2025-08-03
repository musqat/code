import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line> {
        int a, b;

        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line o) {
            return this.a - o.a;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[i] = new Line(a, b);
        }

        Arrays.sort(lines);

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (lines[i].b > lines[j].b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int lis = Arrays.stream(dp).max().getAsInt();
        System.out.println(N - lis);

    }

}

