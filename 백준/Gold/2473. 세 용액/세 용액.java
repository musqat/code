import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0;
        int b = 0;
        int c = 0;

        Arrays.sort(arr);
        long best = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;


            while (left < right) {
                long sum = (long)arr[i] + arr[left] + arr[right];
                
                if (Math.abs(sum) < Math.abs(best)) {
                    best = sum;
                    a = arr[i];
                    b = arr[left];
                    c = arr[right];
                }

                if (sum > 0) right--;
                else if (sum < 0) left++;
                else {
                    System.out.println(a + " " + b + " " + c);
                    return;
                }
            }

        }


        System.out.println(a + " " + b + " " + c);

    }
}