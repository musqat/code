import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int idx;   // 풍선 번호
        int move;  // 이동값
        Node(int idx, int move)
        { this.idx = idx; this.move = move; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Node> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.addLast(new Node(i, num));
        }

        StringBuilder sb = new StringBuilder();

        Node cur = deque.pollFirst();
        sb.append(cur.idx);
        int move = cur.move;

        while (!deque.isEmpty()) {
            if (move > 0){
                int rot = (move - 1) % deque.size();
                for (int i = 0; i < rot; i++) deque.addLast(deque.pollFirst());
                cur = deque.pollFirst();
            }else {
                int rot = (-move) % deque.size();
                for (int i = 0; i < rot; i++) deque.addFirst(deque.pollLast());
                cur = deque.pollFirst();
            }
            sb.append(' ').append(cur.idx);
            move = cur.move;
        }

        System.out.println(sb);
    }
}
