import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] people = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());


        long  result = 0;

        for (int i = 0; i < N; i++) {
            int tmp = people[i] - B;
            result++; // 총 감독관


            if (tmp > 0) {
                result += tmp / C;
                if (tmp % C != 0) {
                    result++; // 부 감독관
                }
            }

        }

        System.out.println(result);
    }


}