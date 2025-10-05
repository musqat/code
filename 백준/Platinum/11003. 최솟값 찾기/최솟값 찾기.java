
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx, value;

        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.getLast().value > now) {
                dq.removeLast();
            }

            dq.addLast(new Node(i, now));

            if (dq.getFirst().idx <= i - L){
                dq.removeFirst();
            }

            sb.append(dq.getFirst().value).append(" ");
        }

        System.out.println(sb);
    }
}