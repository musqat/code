
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        int cur = 0;
        for (int i = 0; i < W; i++) {
            if (height[i] > cur) cur = height[i];
            leftMax[i] = cur;
        }

        cur = 0;
        for (int i = W - 1; i >= 0; i--) {
            if (height[i] > cur) cur = height[i];
            rightMax[i] = cur;
        }

        int total = 0;
        for (int i = 0; i < W; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            int trapped = waterLevel - height[i];
            if (trapped > 0) total += trapped;
        }

        System.out.println(total);
    }
}