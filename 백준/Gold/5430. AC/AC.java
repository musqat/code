import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String Str = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] elements = Str.substring(1, Str.length() - 1).split(",");
                for (String element : elements) {
                    deque.add(Integer.parseInt(element));
                }
            }

            boolean reverse = false;
            boolean error = false;

            for (char pWord : p.toCharArray()) {
                if (pWord == 'R') {
                    reverse = !reverse;
                } else if (pWord == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    } else {
                        if (reverse) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                }
            }

            if (!error) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (reverse) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }

        }
        System.out.println(sb.toString());
    }
    
}
