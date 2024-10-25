import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(times(A, B, C));
    }

    public static long times(long A, long B, long C) {
        if (B == 0){
            return 1;
        }
        long half = times(A, B / 2, C);

        half = (half * half) % C;

        if (B % 2 != 0) {
            half = (half * A) % C;
        }

        return half;
    }
}
