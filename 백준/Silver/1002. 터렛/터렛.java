import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;

            double d = Math.sqrt(dx * dx + dy * dy);

            if (x1 == x2 && y1 == y2 && r1 == r2){
                System.out.println("-1");
            }else if (d > r1 + r2 || d < Math.abs(r1- r2)){
                System.out.println("0");
            }else if (d == r1 + r2 || d == Math.abs(r1 - r2)){
                System.out.println("1");
            }else {
                System.out.println("2");
            }


        }
    }

}
