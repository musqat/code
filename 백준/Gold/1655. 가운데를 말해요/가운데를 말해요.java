import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> A,B;
        A = new PriorityQueue<>((a, b) -> b - a);
        B = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (A.isEmpty() || x <= A.peek()){
                A.add(x);
            }else {
                B.add(x);
            }

            if (A.size() > B.size() + 1){
                B.add(A.remove());
            }
            if (B.size() > A.size()){
                A.add(B.remove());
            }
            sb.append(A.peek()).append('\n');
        }

        System.out.println(sb);

    }
}
