import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Room{
        int s, t;

        Room(int s, int t){
            this.s = s;
            this.t = t;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Room[] arr = new Room[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i] = new Room(s, t);
        }

        Arrays.sort(arr, (a,b) -> a.s != b.s ? a.s - b.s : a.t - b.t);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Room x : arr){
            if (!pq.isEmpty() && pq.peek() <= x.s){
                pq.poll();
            }
            pq.offer(x.t);
        }

        System.out.println(pq.size());
    }
}