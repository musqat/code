import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] weight = new long[26];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            long p = 1;
            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                weight[c - 'A'] += p;
                p *= 10;
            }
        }

        ArrayList<Long> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (weight[i] > 0) arr.add(weight[i]);
        }
        Collections.sort(arr, Collections.reverseOrder());

        int digit = 9;
        long answer = 0;
        for (long w : arr) {
            if (digit < 0) break;
            answer += w * digit;
            digit--;
        }

        System.out.println(answer);


    }
}