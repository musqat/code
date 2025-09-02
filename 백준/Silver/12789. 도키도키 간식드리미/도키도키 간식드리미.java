import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int cur = 1;

        for (int i = 0; i < N; i++) {
            int student = arr[i];

            if (student == cur){
                cur++;
            }else {
                stack.push(student);
            }

            while (!stack.isEmpty() && stack.peek() == cur){
                stack.pop();
                cur++;
            }

        }


        if (cur == N + 1){
            System.out.println("Nice");
        }else {
            System.out.println("Sad");
        }

    }
}