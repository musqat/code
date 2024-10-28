import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(fruit(arr, N));

    }

    public static int fruit(int[] arr, int N) {
        Map<Integer, Integer> fruitCount  = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            fruitCount.put(arr[right], fruitCount.getOrDefault(arr[right], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(arr[left], fruitCount.get(arr[left]) - 1);
                if (fruitCount.get(arr[left]) == 0){
                    fruitCount.remove(arr[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;

    }
}