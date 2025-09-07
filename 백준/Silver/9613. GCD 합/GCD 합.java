import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long[] arr = new long[N];


            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            long sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    sum += gcd(arr[i],arr[j]);
                }
            }

            System.out.println(sum);
        }
    }

    static long gcd(long a, long b) {
        while (b != 0){
            long t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}