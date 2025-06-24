import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] time = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K){
            System.out.println((N-K) + "\n1");
            return;
        }

        bfs();

        System.out.println(minTime);
        System.out.println(count);

    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (minTime < time[now]) return;

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) next = now + 1;
                else if (i == 1) next = now - 1;
                else  next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (next == K){
                    minTime = time[now];
                    count++;
                }

                if (time[next] == 0 || time[next] == time[now] + 1){
                    queue.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }

    }
}