import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N - 1];
        int[] price = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0;
        int minPrice = price[0];

        for (int i = 0; i < N - 1; i++) {
            if (price[i] < minPrice){
                minPrice = price[i];
            }
            total += (long) minPrice * dist[i];
        }
        System.out.println(total);
    }
}
