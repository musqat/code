import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
            return;
        }

        int[] time = new int[MAX];
        Arrays.fill(time, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        time[n] = 0;
        deque.offer(n);

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            if (cur == k) {
                System.out.println(time[cur]);
                return;
            }

            //순간이동
            if (cur * 2 < MAX && time[cur * 2] == -1) {
                time[cur * 2] = time[cur];
                deque.offerFirst(cur * 2);
            }

            // 뒤로 한 칸
            if (cur - 1 >= 0 && time[cur - 1] == -1) {
                time[cur - 1] = time[cur] + 1;
                deque.offerLast(cur - 1);
            }
            
            //앞으로 한 칸
            if (cur + 1 < MAX && time[cur + 1] == -1) {
                time[cur + 1] = time[cur] + 1;
                deque.offerLast(cur + 1);
            }

        }
    }

}
