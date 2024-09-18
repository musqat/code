import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dot = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dot, (a, b) -> {
            if (a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            }else {
                return Integer.compare(a[0],b[0]);
            }
        });

        for (int i = 0; i <n; i++) {
            System.out.println(dot[i][0] + " " + dot[i][1]);
        }
    }

}
