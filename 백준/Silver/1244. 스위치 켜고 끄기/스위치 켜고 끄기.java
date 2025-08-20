import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            changeSwitch(gender, num);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
        System.out.println();
    }

    static void changeSwitch(int gender, int num) {
        if (gender == 1) {
            for (int i = num; i < arr.length; i += num) {
                arr[i] = 1 - arr[i];
            }
        } else if (gender == 2) {
            int left = num;
            int right = num;

            while (left > 1 && right < arr.length - 1) {
                if (arr[left -1] == arr[right + 1]){
                    left--;
                    right++;
                }else {
                    break;
                }
            }
            for (int i = left; i <= right; i++) {
                arr[i] = 1 - arr[i];
            }

        }

    }
}