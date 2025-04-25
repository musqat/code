import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int height = arr[i];

            while (!stack.isEmpty() && stack.peek()[1] < height){
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            }else {
                sb.append(stack.peek()[0] + 1).append(" ");
            }

            stack.push(new int[]{i, height});
            
        }

        System.out.println(sb);

    }
}
