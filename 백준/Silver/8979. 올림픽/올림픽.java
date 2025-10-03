
import java.io.*;
import java.util.*;

public class Main {

    static class Country {
        int id, g, s, b;

        Country(int id, int g, int s, int b) {
            this.id = id;
            this.g = g;
            this.s = s;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Country[] arr = new Country[N];
        Country target = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Country(id, g, s, b);
            if (id == K) target = arr[i];
        }

        int better = 0;
        for (Country c : arr) {
            if (isBetter(c, target)) better++;
        }

        System.out.println(better + 1);
    }

    static boolean isBetter(Country a, Country b) {
        if (a.g != b.g) return a.g > b.g;
        if (a.s != b.s) return a.s > b.s;
        return a.b > b.b;
    }
}