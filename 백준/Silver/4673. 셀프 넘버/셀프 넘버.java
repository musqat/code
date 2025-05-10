import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] check = new boolean[10036];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = 1;

        while (n <= 10000) {
            if (!check[n]) {
                sb.append(n).append("\n");
            }
            selfNum(n);
            n++;
        }
        System.out.println(sb);
    }

    static void selfNum(int n) {
        int sum = 0;
        sum += n;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        check[sum] = true;
    }

}
