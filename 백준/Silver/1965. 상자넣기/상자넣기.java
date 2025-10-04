
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] tails = new int[N];
        int len = 0;

        for (int x : A){
            int low = 0, high = len;
            while (low < high){
                int mid = (low + high) >>> 1;
                if (tails[mid] < x) low = mid + 1;
                else high = mid;
            }
            tails[low] = x;
            if (low == len) len++;
        }
        System.out.println(len);
    }
}