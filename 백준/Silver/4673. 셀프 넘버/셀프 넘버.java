import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] check = new boolean[10036];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = 1;

        while (n <= 10000){
            if (!check[n]){
                sb.append(n).append("\n");
            }
            selfNum(n);
            n++;
        }
        System.out.println(sb);
    }

    static void selfNum(int n ){
        int sum = n;
        int temp = n;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if (sum < check.length) {
            check[sum] = true;
        }
    }

}
