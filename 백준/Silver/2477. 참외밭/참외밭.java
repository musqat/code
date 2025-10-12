import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        int[] dir = new int[6];
        int[] len = new int[6];

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
        }

        int maxW = 0, maxH = 0;
        int idxW = -1, idxH = -1;

        for (int i = 0; i < 6; i++) {
            if (dir[i] == 1 || dir[i] == 2) {
                if (len[i] > maxW) {
                    maxW = len[i];
                    idxW = i;
                }
            } else {
                if (len[i] > maxH) {
                    maxH = len[i];
                    idxH = i;
                }
            }
        }

        int minW = len[(idxW + 3) % 6];
        int minH = len[(idxH + 3) % 6];

        long area = (long) maxW * maxH - (long) minW * minH;
        long answer = area * K;

        System.out.println(answer);
    }
}