
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            stack.push(num);
        }

        int top = stack.pop();
        int count = 1;
        while (!stack.isEmpty()){
            int num = stack.pop();
            if (num > top){
                top = num;
                count++;
            }

        }

        System.out.println(count);
    }
}