import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            int first = sc.nextInt();
            int last = sc.nextInt();
            int sum = prefixSum[last] - prefixSum[first - 1];
            System.out.println(sum);
        }

    }



}
