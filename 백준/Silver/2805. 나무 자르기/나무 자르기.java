import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] tree = new int[N];
        int highTree = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            if (tree[i] > highTree){
                highTree = tree[i];
            }
        }

        long low = 0;
        long high = highTree;
        long result = 0;

        while (low <= high){
            long mid = (low + high) / 2;
            long wood = 0;

            for (int i = 0; i < N; i++) {
                if (tree[i] > mid){
                    wood += tree[i] - mid;
                }
            }

            if (wood >= M){
                result = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        System.out.println(result);
    }
}
