import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] arr = new long[91];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(fibo(N));


    }

    public static long fibo (int N){
        if (N == 0){
            return 0;
        }
        if (N == 1){
            return 1;
        }

        if (arr[N] != 0){
            return arr[N];
        }

        return arr[N] = fibo(N-1) + fibo(N-2);
    }

}
