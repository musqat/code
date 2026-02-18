import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = find(arr);
        if (idx == -1) {
            System.out.println(-1);
            return;
        }

        swap(arr, idx);
        reverse(arr, idx + 1);


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }

    }

    static int find(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    static void swap(int[] arr, int idx) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[idx] < arr[i]) {
                int tmp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = tmp;
                return;
            }
        }
    }

    static void reverse(int[] arr, int idx) {
        int left = idx;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }

    }
}