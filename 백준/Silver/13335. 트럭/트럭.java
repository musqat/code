import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int curWeight = 0; // 현재 하중
        int time = 0; // 시간
        int idx = 0; // N 인덱스
        Queue<Integer> q = new LinkedList<>();
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < W; i++) {
            q.add(0);
        }


        while (idx < N) {
            curWeight -= q.poll();

                if (curWeight + arr[idx] <= L) {
                    curWeight += arr[idx];
                    q.add(arr[idx]);
                    idx++;
                } else {
                    q.add(0);
                }
            time++;
        }
        time += W;
        System.out.println(time);
    }

}
