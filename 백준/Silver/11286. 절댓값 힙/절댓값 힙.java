import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB){
                return Integer.compare(a,b);
            }
            return Integer.compare(absA,absB);
        });
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                pq.add(x);
            } else {
                if (pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            }
        }

    }
}
