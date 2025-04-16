import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        int c = Integer.parseInt(br.readLine());


        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] scores = new int[n];

            int sum = 0;

            for (int j = 0; j < n; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }

            double average = (double) sum / n;
            int countAverage = 0;
            for (int score : scores){
                if (score > average){
                    countAverage++;
                }
            }
            double ratio = (double) countAverage / n  * 100;
            System.out.printf("%.3f%%\n", ratio);


        }
    }

}
