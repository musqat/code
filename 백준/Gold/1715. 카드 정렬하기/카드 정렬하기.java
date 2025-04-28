import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> arr = new PriorityQueue<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        while (arr.size() > 1){
            int a = arr.remove();
            int b = arr.remove();
            int c = a + b;
            result += c;
            arr.add(c);
        }

        System.out.println(result);
    }
}
