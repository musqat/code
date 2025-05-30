import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        LinkedList<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push")) {
                queue.add(Integer.valueOf(st.nextToken()));
            } else if (s.equals("pop")) {
                sb.append(queue.isEmpty() ? "-1" : queue.poll()).append('\n');
            } else if (s.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (s.equals("empty")) {
                sb.append(queue.isEmpty() ? "1" : "0").append('\n');
            } else if (s.equals("front")) {
                sb.append(queue.isEmpty() ? "-1" : queue.peek()).append('\n');
            } else if (s.equals("back")) {
                sb.append(queue.isEmpty() ? "-1" : queue.getLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
