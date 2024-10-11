import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        double average = calculateAverage(arr);
        System.out.println(Math.round(average));
    }

    public static double calculateAverage(int[] arr){
        Arrays.sort(arr);

        int len = arr.length;
        int trimCount = (int) Math.round(len * 0.15);
        int sum = 0;
        for (int i = trimCount; i < len - trimCount ; i++) {
            sum += arr[i];
        }
        int trimLen = len - (2 * trimCount);
        return (double) sum / trimLen;
    }
}
