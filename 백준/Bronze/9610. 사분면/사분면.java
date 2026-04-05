import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr = new int[5]; // Q1, Q2, Q3, Q4, AXIS

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cal(x, y);
        }

        //Q1: 2
        for (int i = 0; i < 4; i++) {
            System.out.println("Q"+ (i+1) + ": " + arr[i] );
        }
        System.out.println("AXIS: " + arr[4]);
    }


    static void cal(int x, int y) {
        if (x == 0 || y == 0) { // AXIS
            arr[4]++;
        } else if (x > 0 && y > 0) { // Q1
            arr[0]++;
        } else if (x < 0 && y > 0){ // Q2
            arr[1]++;
        }else if (x < 0 && y < 0){ // Q3
            arr[2]++;
        }else if (x > 0 && y < 0){ // Q4
            arr[3]++;
        }
    }
}
