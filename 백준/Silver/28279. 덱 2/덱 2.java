import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            switch (num) {
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                case 4:
                    System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                case 5 :
                    System.out.println(deque.size());
                    break;
                case 6:
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case 7 :
                    System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                case 8 :
                    System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
                    break;

            }
        }

    }
}