import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] copy = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            copy[i] = arr[i];
        }

        Arrays.sort(copy);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for (int num : copy){
            if (!map.containsKey(num)){
                map.put(num, rank);
                rank++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(map.get(arr[i])).append(" ");
        }

        System.out.println(result.toString().trim());
    }


}
