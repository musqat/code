
import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        findPrime();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            if (N % 2 == 0 && N != 0){
                for (int i = 2; i <= N / 2; i++) {
                    if (!prime[i]){
                        if (!prime[N- i]){
                            count++;
                        }
                    }

                }
            }
            System.out.println(count);
        }
    }

    static void findPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = 2; i * j < prime.length; j++) {
                    prime[i * j] = true;
                }
            }

        }
    }
}