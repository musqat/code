import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char c : line.toCharArray()){
            left.addLast(c);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();

            switch (tmp){
                case "L":
                    if (!left.isEmpty()){
                        right.addFirst(left.removeLast());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()){
                        left.addLast(right.removeFirst());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()){
                        left.removeLast();
                    }
                    break;
                case "P":
                    char c = st.nextToken().charAt(0);
                    left.addLast(c);
                    break;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        for (char c : right) sb.append(c);
        System.out.println(sb);



    }
}
