import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if ((line.length() & 1) == 1) continue;
            Deque<Character> deque = new ArrayDeque<>();

            for (char c : line.toCharArray()){
                if (!deque.isEmpty() && deque.peek() == c) deque.pop();
                else deque.push(c);
            }
            if (deque.isEmpty()) count++;

        }
        System.out.println(count);

    }
}