
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = 100;

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            int next = sum + a;

            if (next >= goal) {
                if (Math.abs(goal - sum) < Math.abs(goal - next)){
                    System.out.println(sum);
                }else {
                    System.out.println(next);
                }
                return;
            }
            sum = next;

        }

        System.out.println(sum);
    }
}