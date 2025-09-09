import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while (deque.size() != 1){
            sb.append(deque.pollFirst()).append(' ');
            deque.addLast(deque.pollFirst());
        }
        sb.append(deque.pollFirst());
        System.out.println(sb);




    }
}
