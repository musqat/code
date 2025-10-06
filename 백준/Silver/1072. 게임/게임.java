
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        long Z = (Y * 100) / X;

        if (Z >= 99){
            System.out.println(-1);
            return;
        }

        long low = 1, high = 1_000_000_000L, ans = -1;

        while (low <= high){
            long mid = (low + high) / 2;
            long newZ = ((Y +mid) * 100) / (X + mid);

            if (newZ > Z){
                ans = mid;
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }

        System.out.println(ans);

    }
}