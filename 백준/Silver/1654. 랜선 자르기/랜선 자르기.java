import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] cables = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = sc.nextInt();
            if (cables[i] > max){
                max = cables[i];
            }
        }

        long start = 1;
        long end = max;
        long result = 0;

        while (start <= end){
            long mid = (start+end) /2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += cables[i] / mid;
            }

            if (count >= N){
                result = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
