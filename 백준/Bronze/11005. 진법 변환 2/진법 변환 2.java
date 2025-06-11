import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());


        while (N > 0){
            long r = N % B;
            if (r < 10){
                sb.append((char) (r + '0'));
            }else {
                sb.append((char) (r - 10 + 'A'));
            }
            N /= B;
        }

        System.out.println(sb.reverse());
    }
}
