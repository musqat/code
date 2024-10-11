import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int current = 1;
        boolean isPossible = true;

        for (int number : arr){
            while (current <= number){
                stack.push(current);
                sb.append("+\n");
                current++;
            }
            if (!stack.isEmpty() && stack.peek() == number){
                stack.pop();
                sb.append("-\n");
            }else {
                isPossible = false;
                break;
            }
        }
        
        if (isPossible){
            System.out.println(sb);
        }else {
            System.out.println("NO");
        }
        
        br.close();

    }
}
