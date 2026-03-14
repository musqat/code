import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int aSize = n * (n + 1) / 2;
        int bSize = m * (m + 1) / 2;

        long[] aSum = new long[aSize];
        long[] bSum = new long[bSize];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = i; j < n; j++) {
                tmp += arrA[j];
                aSum[idx++] = tmp;
            }
        }

        idx = 0;

        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = i; j < m; j++) {
                tmp += arrB[j];
                bSum[idx++] = tmp;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        int left = 0, right = bSum.length - 1;
        long count = 0;

        while (left < aSum.length && right >= 0) {
            long a = aSum[left], b = bSum[right];
            if (a + b == T) {
                long cntA = 0, cntB = 0;
                while (left < aSum.length && aSum[left] == a) {
                    cntA++;
                    left++;
                }
                while (right >= 0 && bSum[right] == b) {
                    cntB++;
                    right--;
                }

                count += cntA * cntB;
            } else if (a + b < T) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);

    }
}
