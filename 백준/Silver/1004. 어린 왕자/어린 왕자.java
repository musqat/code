import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean startIsInside = isInside(x1, y1, cx, cy, r);
                boolean endIsInside = isInside(x2, y2, cx, cy, r);

                if (startIsInside != endIsInside) count++;
            }

            System.out.println(count);
        }
    }

    public static boolean isInside(int px, int py, int cx, int cy, int r) {
        int dx = px - cx;
        int dy = py - cy;
        return dx * dx + dy * dy < r * r;
    }

}

