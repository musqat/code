import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(findZ(N, r, c));




    }

    public static int findZ(int N, int r, int c){
        if (N == 0){
            return 0;
        }

        int half = 1 << (N - 1);
        int size = half * half;

        if (r < half && c < half){
            return findZ(N -1, r, c);
        }else if (r < half && c >= half){
            return size + findZ(N - 1, r, c -half);
        } else if (r >= half && c < half) {
            return 2 * size + findZ(N - 1, r - half, c);
        } else {
            return 3 * size + findZ(N - 1, r - half, c - half);
        }

    }
}
