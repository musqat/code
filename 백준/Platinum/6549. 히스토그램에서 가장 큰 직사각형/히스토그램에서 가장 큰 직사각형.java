
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) break;

            long[] height = new long[N];
            for (int i = 0; i < N; i++) {
                height[i] = Long.parseLong(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();
            long max = 0;

            for (int i = 0; i <= N; i++) {
                long curHeight = (i == N) ? 0 : height[i];

                while (!stack.isEmpty() && height[stack.peek()] > curHeight) {
                    long h = height[stack.pop()];
                    long w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, h * w);
                }
                stack.push(i);
            }

            System.out.println(max);
        }
    }
}


