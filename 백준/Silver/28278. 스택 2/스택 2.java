import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());


            switch (x) {
                case 1:
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println(stack.pop());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case 3:
                    System.out.println(stack.size());
                    break;
                case 4:
                    if (!stack.isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(1);
                    }
                    break;
                case 5:
                    if (!stack.isEmpty()) {
                        System.out.println(stack.peek());
                    } else {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}
