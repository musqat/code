
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] prev = new int[m];
        int[] curr = new int[m];
        
        int maxSide = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int left = 0;
            for (int j = 0; j < m; j++) {
                int val = line.charAt(j) - '0';
                int up = prev[j];
                int upLeft = (j == 0) ? 0 : prev[j - 1];
                int leftDp = left;

                int here;

                if (val == 0){
                    here = 0;
                }else {
                    if (i == 0 || j == 0){
                        here = 1;
                    }else {
                        here = Math.min(up, Math.min(leftDp, upLeft)) + 1;
                    }
                }

                curr[j] = here;
                maxSide = Math.max(maxSide, here);

                left = here;
            }

            int[] tmp = prev;
            prev = curr;
            curr = tmp;
            Arrays.fill(curr, 0);
        }
        System.out.println(maxSide * maxSide);

    }
}