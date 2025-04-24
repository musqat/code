import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean zero = false;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > 0) {
                maxHeap.add(value);
            } else if (value < 0) {
                minHeap.add(value);
            } else {
                zero = true;
            }
        }

        int answer = 0;
        while (maxHeap.size() >= 2) {
            int a = maxHeap.remove();
            int b = maxHeap.remove();
            answer += Math.max(a * b, a + b);
        }
        if (maxHeap.size() == 1) {
            answer += maxHeap.remove();
        }
        while (minHeap.size() >= 2) {
            int a = minHeap.remove();
            int b = minHeap.remove();
            answer += a * b;
        }
        if (minHeap.size() == 1 && !zero) {
            answer += minHeap.remove();
        }
        System.out.println(answer);

    }

}
